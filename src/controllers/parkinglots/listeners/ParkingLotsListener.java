package controllers.parkinglots.listeners;

import java.util.EventListener;

import model.User;

public interface ParkingLotsListener extends EventListener {	
	void useradd(ParkingLotsTriggerEvent<User> event);
}
