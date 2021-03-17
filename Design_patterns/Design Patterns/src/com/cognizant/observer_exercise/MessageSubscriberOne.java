package com.cognizant.observer_exercise;

public class MessageSubscriberOne implements Observer{

	@Override
	public void update(Message m) {
		
		System.out.println("MessageSubscriberOne :: " + m.getMessageContent());
		
	}

}
