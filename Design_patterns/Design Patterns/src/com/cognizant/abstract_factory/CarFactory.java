package com.cognizant.abstract_factory;

public class CarFactory {

	public static Factory getFactory(String type)
	{
		if(type.equals("mercedes"))
		{
			return new MercedesFactory();
		}
		else
		{
			return new AudiFactory();
		}
	}
	
}
