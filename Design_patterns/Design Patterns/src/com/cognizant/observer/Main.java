package com.cognizant.observer;

public class Main {

	public static void main(String[] args) {
		
		MessageSubscriberOne s1 = new MessageSubscriberOne();
		MessageSubscriberTwo s2 = new MessageSubscriberTwo();
		MessageSubscriberThree s3 = new MessageSubscriberThree();
		
		Subject p=new MessagePublisher();
		
		p.attach(s1);
		p.attach(s2);
		
		//s1 and s2 will receive the update
		p.notifyUpdate(new Message("First Message"));
		
		p.detach(s1);
		p.attach(s3);
		
		//s2 and s3 will receive the update
		p.notifyUpdate(new Message("Second Message")); 

	}

}
