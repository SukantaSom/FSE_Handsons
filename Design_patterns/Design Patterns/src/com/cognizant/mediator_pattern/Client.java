package com.cognizant.mediator_pattern;

import java.util.ArrayList;

public class Client {

	public static void main(String[] args) {
		
		ChatMediator chatMediator=new ChatMediator(new ArrayList<IUser>());
		
		chatMediator.addUser(new BasicUser(chatMediator, "ss"));
		chatMediator.addUser(new BasicUser(chatMediator, "sougata"));
		chatMediator.addUser(new BasicUser(chatMediator, "dubey"));
		
		PremiumUser premiumUser=new PremiumUser(chatMediator, "sovon");
		premiumUser.sendMessage("hi");
		
	}

}
