package daoFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.implementation.*;
import dao.interfaces.UserDao;

public class Oracle extends DaoFactory {
	
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String driver = "oracle.jdbc.OracleDriver";
	private static String user = "system";
	private static String password = "oracle";
	
	public Connection openConnection() {   
		try {
			Class.forName(driver).newInstance();
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex){
			System.err.println(
				"SOmething wrong with connecting to the database!");
		}
		return null;
	}
	
	@Override
	public UserDao getUserDao() {
		return new OracleUserDao();
	}
}
