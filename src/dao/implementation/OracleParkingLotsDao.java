package dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;
import dao.interfaces.ParkingLotsDao;
import daoFactory.DaoFactory;
/**
 * The class UserDao has the responsibility 
 * of access the user's data
 * 
 */
public class OracleParkingLotsDao implements ParkingLotsDao {

	private static final String
	INSERT = "INSERT INTO users (name, login) VALUES (?, ?)";

	private static final String
	ALL = "SELECT * FROM users";

	private static final String 
	FIND_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
	
	private static final String
	FIND_BY_ID = "SELECT * FROM users WHERE id = ?";

	private static final String 
	DELETE = "DELETE FROM users where id = ?";
	
	private static final String 
	DELETE_ALL = "DELETE FROM users";
	
	
	/**
	 * Method to insert a user in the database
	 * @param user the user that will be inserted 
	 * @return user the inserted
	 * @throws SQLException
	 */
	public User insert(User user) throws SQLException {
		Connection c = DaoFactory.getDatabase().openConnection();
		
		PreparedStatement pstmt = c.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

		pstmt.setString(1, user.getName());
		pstmt.setString(2, user.getLogin());

		pstmt.executeUpdate();

		pstmt.close();
		c.close();
		
		return user;
	}

	/**
	 * Method to retrieve all users from the database
	 * @return users all users in the database	
	 * @throws SQLException 
	 */
	public List<User> all() throws SQLException {
		ArrayList<User> users = new ArrayList<User>();
		
		Connection c = DaoFactory.getDatabase().openConnection();
		PreparedStatement pstmt = c.prepareStatement(ALL);

		ResultSet rset = pstmt.executeQuery();
		while (rset.next()){
			users.add(createUser(rset));
		}

		pstmt.close();
		c.close();

		return users;
	}

	/**
	 * Method to delete all users in the database
	 * @return rowsAffected the numbers of rows Affected
	 * @throws SQLException 
	 */
	public int deleteAll() throws SQLException {
		Connection c = DaoFactory.getDatabase().openConnection();
		PreparedStatement pstmt = c.prepareStatement(DELETE_ALL);

		int rowsAffected = pstmt.executeUpdate();
		
		pstmt.close();
		c.close();
		
		return rowsAffected;
	}
	
	/**
	 * Method to delete all users in the database
	 * @return rowsAffected the numbers of rows Affected
	 * @throws SQLException 
	 */
	public int delete(User user) throws SQLException {
		Connection c = DaoFactory.getDatabase().openConnection();
		PreparedStatement pstmt = c.prepareStatement(DELETE);
		pstmt.setString(1, user.getLogin());
		
		int rowsAffected = pstmt.executeUpdate();
		
		pstmt.close();
		c.close();
		
		return rowsAffected;
	}
	
	
	/**
	 * Method to find a user by login
	 * @return user User find by the login, otherwise null	
	 * @throws SQLException 
	 */
	public User findByLogin(String login) throws SQLException {
		Connection c = DaoFactory.getDatabase().openConnection();

		PreparedStatement pstmt = c.prepareStatement(FIND_BY_LOGIN);
		pstmt.setString(1, login);
		
		User user = null;
		ResultSet rset = pstmt.executeQuery();

		while (rset.next()){
			user = createUser(rset);
		}

		pstmt.close();
		c.close();

		return user;
	}	
	
	/**
	 * Method to find a user by login
	 * @return user User find by the id, otherwise null	
	 * @throws SQLException 
	 */
	public User findById(Long id) throws SQLException {
		Connection c = DaoFactory.getDatabase().openConnection();

		PreparedStatement pstmt = c.prepareStatement(FIND_BY_ID);
		pstmt.setLong(1, id);
		
		User user = null;
		ResultSet rset = pstmt.executeQuery();

		while (rset.next()){
			user = createUser(rset);
		}

		pstmt.close();
		c.close();

		return user;
	}
	
	/* method to create users **/
	private User createUser(ResultSet rset) throws SQLException{
		User user = new User(rset.getString("name"),
							 rset.getString("login"));
		
	
		return user;
	}
}
