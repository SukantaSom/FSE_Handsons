package com.cognizant.observer_exercise;

public class MessageSubscriberTwo implements Observer {

	@Override
	public void update(Message m) {

		System.out.println("MessageSubscriberTwo :: " + m.getMessageContent());

	}

}
