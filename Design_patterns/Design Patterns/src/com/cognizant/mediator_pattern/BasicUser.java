package com.cognizant.mediator_pattern;

public class BasicUser implements IUser {

	public ChatMediator chatMediator;
	public String name;
	
	public BasicUser(ChatMediator chatMediator, String name) {
		super();
		this.chatMediator = chatMediator;
		this.name = name;
	}

	/**
	 *  receives the message from another user
	 */
	@Override
	public void receiveMessage(String msg) {
		
		System.out.println(this.name+" received message: "+msg);
		
	}

	@Override
	public void sendMessage(String msg) {
		
		System.out.println(this.name+" sending message: "+msg);
		chatMediator.sendMessage(msg, this);
		
	}


}
