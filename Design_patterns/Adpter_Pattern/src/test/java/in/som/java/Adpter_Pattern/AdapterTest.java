package in.som.java.Adpter_Pattern;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AdapterTest {

	Movable bugattiVeyron = new BugattiVeyron();
	MovableAdapter bugattiVeyronAdapter = new MovableAdapterImpl(bugattiVeyron);

	@Test
	public void whenConvertingMPHToKMPH_thenSuccessfullyConverted() {
		assertEquals(bugattiVeyronAdapter.getSpeed(), 431.30312, 0.00001);
	}

	@Test
	public void whenConvertingUSDToEURO_thenSuccessfullyConverted() {
		assertEquals(bugattiVeyronAdapter.getPrice(), 2100.00, 0.00001);
	}
}

