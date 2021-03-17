package com.cognizant.observer_exercise;

import java.util.ArrayList;
import java.util.List;

public class MessagePublisher implements Subject {

	private List<Observer> observers = new ArrayList<>();
	
	public State state;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		
		this.state = state;
		notifyUpdate(new Message("State Shanged"));
	}

	/**
	 *  adds user to notification service
	 */
	@Override
	public void attach(Observer o) {

		observers.add(o);

	}

	/**
	 *  removes user from notofication service
	 */
	@Override
	public void detach(Observer o) {

		observers.remove(o);

	}

	/**
	 *   notifies all the intended users from list
	 */
	@Override
	public void notifyUpdate(Message m) {

		for (Observer o : observers) {
			o.update(m);
		}

	}

}
