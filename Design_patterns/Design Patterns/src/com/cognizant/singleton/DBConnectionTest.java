package com.cognizant.singleton;

public class DBConnectionTest {

	public static void main(String[] args) {
		
		DBConnection connection = DBConnection.getInstance();
		System.out.println(connection);
		connection = DBConnection.getInstance();
		System.out.println(connection); // no new instance is created
		// gives error as constructor is private
		//DBConnection obj=new DBConnectionTest();
		
	}

}
