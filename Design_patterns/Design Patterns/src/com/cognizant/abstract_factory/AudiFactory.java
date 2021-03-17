package com.cognizant.abstract_factory;

public class AudiFactory extends Factory{

	@Override
	public Headlight makeHeadlight() {
		return new AudiHeadlight();
	}

	@Override
	public Tire makeTire() {
		return new AudiTire();
	}


}
