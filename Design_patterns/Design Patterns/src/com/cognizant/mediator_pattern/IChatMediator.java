package com.cognizant.mediator_pattern;

public interface IChatMediator {

	// adds user into list
	public void addUser(IUser user);
	
	// send message to users
	public void sendMessage(String msg,IUser user);
	
}
