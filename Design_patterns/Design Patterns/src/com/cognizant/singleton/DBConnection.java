package com.cognizant.singleton;

public class DBConnection {

	private static DBConnection dbConnection;
	
	// can't create constructor
	private DBConnection()
	{
		
	}
	
	/**
	 * 
	 * @return Database connection
	 */
	public static DBConnection getInstance()
	{
		if(dbConnection==null)
		{
			dbConnection = new DBConnection();
		}
		
		return dbConnection;
	}
	
}
