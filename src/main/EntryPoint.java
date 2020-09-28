package main;

import java.sql.SQLException;

import model.User;
import view.applayout.MainJFrame;

public class EntryPoint {
	
	public static void main(String[] args) throws SQLException {
		//initiate();
		MainJFrame.createAndShowGUI();
	}		

	@SuppressWarnings("unused")
	private static void initiate() throws SQLException{
		System.out.println(User.deleteAll() + " Deleted all users");		
		User user = new User("dnguyenv", "Duy Nguyen", "admin");
		user.save();		
		User user1 = new User("hhwang4", "Hosung Hwang", "admin");
		user1.save();		
		User user2 = new User("aupadhy3", "Abhishek Upadhyaya", "admin");
		user2.save();		
		User user3 = new User("wshi6", "Weichen Shi", "admin");
		user3.save();
		System.out.println("====================================");
		
		for (User u : User.all()) {
			System.out.println(u);
		}
	}
}
