package controllers.parkinglots.listeners;

import java.util.EventObject;

public class ParkingLotsTriggerEvent<T> extends EventObject {

	private static final long serialVersionUID = 1L;

	public ParkingLotsTriggerEvent(Object source) {
		super(source);
	}
	
	@SuppressWarnings("unchecked")
	public T getSource(){
		return ((T) super.getSource());
	}
}