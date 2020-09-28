package controllers.users.listeners;

import java.util.EventObject;

public class UsersTriggerEvent<T> extends EventObject {

	private static final long serialVersionUID = 1L;

	public UsersTriggerEvent(Object source) {
		super(source);
	}
	
	@SuppressWarnings("unchecked")
	public T getSource(){
		return ((T) super.getSource());
	}
}