package com.cognizant.observer_exercise;

public class Client {

	public static void main(String[] args) {
		
		// storing reference in MessagePublisher object not in Subject reference because 
		//  state interface doesn't have setState() method
		MessagePublisher subject=new MessagePublisher();
		
		MessageSubscriberOne s1 = new MessageSubscriberOne();
		MessageSubscriberTwo s2 = new MessageSubscriberTwo();
		MessageSubscriberThree s3 = new MessageSubscriberThree();
		
		// all the observers will be notified on state change
		subject.attach(s1);
		subject.attach(s2);
		subject.attach(s3);
		// changing state by setting State object value
		subject.setState(new State(1));
		
		// again changing state by setting State object value
		subject.setState(new State(0));

	}

}
