package com.pluralsight.testing;

import org.junit.Assert;
import org.junit.Test;

public class CafeTest {

	
	// Declare any constants at the top of the class
	private static final int ESPRESSO_BEANS = CoffeeType.Espresso.getRequiredBeans();
	private static final int NO_MILK = 0; 
	private static final int NO_BEANS = 0; 

	// can brew espresso
	@Test
	public void canBrewEspresso() {

		// GIVEN
		Cafe cafe = cafeWithBeans();

		// WHEN
		Coffee coffee = cafe.brew(CoffeeType.Espresso);

		// THEN
		// Can provide a message if it goes wrong
		Assert.assertEquals("Wrong coffee type", CoffeeType.Espresso,
				coffee.getType());
		Assert.assertEquals("Wrong amount of milk", NO_MILK, coffee.getMilk());
		Assert.assertEquals("Wrong number of beans", ESPRESSO_BEANS, coffee.getBeans());

	}

	@Test
	public void brewingEspressoConsumesBeans() {
		// GIVEN
		Cafe cafe = cafeWithBeans();

		// WHEN
		Coffee coffee = cafe.brew(CoffeeType.Espresso);

		// THEN
		Assert.assertEquals(NO_BEANS, cafe.getBeansInStock());
	}

	// This is how to test an exception being thrown
	// THEN (i.e. the exception is the THEN)
	@Test(expected = IllegalStateException.class)
	public void lattesRequiresMilk() {
		// GIVEN
		Cafe cafe = cafeWithBeans();
		
		// WHEN
		Coffee coffee = cafe.brew(CoffeeType.Latte);

		Assert.assertEquals("Wrong coffee type", CoffeeType.Latte,
				coffee.getType());

	}
	
	private Cafe cafeWithBeans(){
		Cafe cafe = new Cafe();
		cafe.restockBeans(ESPRESSO_BEANS);
		return cafe;		
	}

}
