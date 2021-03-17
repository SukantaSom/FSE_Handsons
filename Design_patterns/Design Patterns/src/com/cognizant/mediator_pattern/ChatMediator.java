package com.cognizant.mediator_pattern;

import java.util.ArrayList;
import java.util.List;

public class ChatMediator implements IChatMediator{

	public List<IUser> users=new ArrayList<IUser>();

	public ChatMediator(List<IUser> users) {
		super();
		this.users = users;
	}

	@Override
	public void addUser(IUser user) {
		
		users.add(user);
		
	}

	@Override
	public void sendMessage(String msg,IUser user) {
		
		for(IUser u:users)
		{
			if(u!=user)
			{
				u.receiveMessage(msg);
			}
		}
		
	}

}
