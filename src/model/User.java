package model;

import java.sql.SQLException;
import java.util.List;

import dao.interfaces.UserDao;
import daoFactory.DaoFactory;

/**
 * The class User represent a user

 */
public class User {
	
	private String name;
	private String login;
	private String role;
	
	public User(String name, String login) {
		this.name = name;
		this.login = login;
	}

	public User(String login, String name, String role) {
		this.name = name;
		this.login = login;
		this.role = role;
	}

	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String[] toArray(){
		return new String[] {this.login, this.name, this.role};
	}
	
	@Override
	public String toString() {
		return  " Login: " + this.login + 
			 	" Name: "  + this.name +
				" Role: " + this.role;				
	}
	

	/**
	 * Method to save the current user in the database
	 */
	public void save() throws SQLException{
		userDAO().insert(this);
	}
	
	/**
	 * Method to save the current user in the database
	 */
	public void delete() throws SQLException{
		userDAO().delete(this);
	}
	
	
	/**
	 * Method to find all users from the database
	 * @return users all users from the database
	 */
	public static List<User> all() throws SQLException {
		return userDAO().all();
	}
	
	/**
	 * Method to find one user by login
	 * @param login user's login
	 * @return user the user with the login given,
	 * 		   if the login doesn't exists, the method return null
	 */
	public static User findByLogin(String login) throws SQLException {
		return userDAO().findByLogin(login);
	}

	
	/**
	 * Method to delete all users
	 * @return the numbers of users deleted
	 */
	public static int deleteAll() throws SQLException {
		return userDAO().deleteAll();
	}
	
	/* 
	 * Method to return the user DAO
	 * @return dao the user dao 
     */
	private static UserDao userDAO(){
		DaoFactory dao = DaoFactory.getDatabase();
		return dao.getUserDao();
	}
}
