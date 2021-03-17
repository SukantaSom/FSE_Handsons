package com.cognizant.abstract_factory;

public class Test {

	public static void main(String[] args) {
		
		Factory obj1=CarFactory.getFactory("mercedes");
		obj1.makeHeadlight();
		obj1.makeTire();

		
		Factory obj2=CarFactory.getFactory("audi");
		obj2.makeHeadlight();
		obj2.makeTire();
		
	}

}
