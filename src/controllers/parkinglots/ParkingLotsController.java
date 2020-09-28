package controllers.parkinglots;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controllers.users.listeners.UsersTriggerEvent;
import controllers.users.listeners.UserListener;
import model.User;

public class ParkingLotsController {
	
	private List<UserListener> userListeners = new ArrayList<UserListener>();
	
	private static ParkingLotsController instance = new ParkingLotsController();
	
	private ParkingLotsController(){}
	
	public static ParkingLotsController getInstance() {
		return instance;
	}
	
	public User save(User user) throws SQLException {
		if (user != null) {
			user.save();
			notifyListeners(user);
		}
		return user;
	}
	
	public void remove(String login) throws SQLException{
		User user = User.findByLogin(login);
		user.delete();
	}
	
	public List<User> allUsers() throws SQLException{
		return User.all();
	}
	
	public synchronized void addUserListener(UserListener l) {
		if(!userListeners.contains(l)) {
			userListeners.add(l);
		}
	}

	private void notifyListeners(User user) {
		UsersTriggerEvent<User> event = new UsersTriggerEvent<User>(user);
		for (UserListener listener : userListeners) {
			listener.useradd(event);
		}
	}

}
