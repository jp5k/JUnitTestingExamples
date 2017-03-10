package com.pluralsight.testing;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CafeTest {

	// Declare any constants at the top of the class
	private static final int ESPRESSO_BEANS = CoffeeType.Espresso
			.getRequiredBeans();
	private static final int NO_MILK = 0;
	private static final int NO_BEANS = 0;

	private Cafe cafe;

	// Can have @BeforeClass and @AfterClass tests

	// A cafeTest object is actually created before the execution of each test
	// So we could in fact use a constuctor instead of a @Before method.
	// However, have no concept of @After in Java, so @Before and @After remain
	// consistent
	@Before
	public void before() {
		cafe = new Cafe();
	}

	@After
	public void after() {
		// Use this for teardown after each method call
	}

	// can brew espresso
	@Test
	public void canBrewEspresso() {

		// GIVEN
		withBeans();

		// WHEN
		Coffee coffee = cafe.brew(CoffeeType.Espresso);

		// THEN
		// Can provide a message if it goes wrong
		// Use Hamcrest matchers for this, very useful for composite tests
		// One Assert expression to match on "beans" property, and has right
		// amount of Espresso beans.
		Assert.assertThat(coffee,
				Matchers.hasProperty("beans", Matchers.equalTo(ESPRESSO_BEANS)));

		Assert.assertEquals("Wrong coffee type", CoffeeType.Espresso,
				coffee.getType());
		Assert.assertEquals("Wrong amount of milk", NO_MILK, coffee.getMilk());
		// This is now redundant, becuase of hamcrest matcher above.
		// Assert.assertEquals("Wrong number of beans", ESPRESSO_BEANS,
		// coffee.getBeans());

	}

	@Test
	public void brewingEspressoConsumesBeans() {
		// GIVEN
		withBeans();

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
		withBeans();

		// WHEN
		Coffee coffee = cafe.brew(CoffeeType.Latte);

		Assert.assertEquals("Wrong coffee type", CoffeeType.Latte,
				coffee.getType());

	}

	private void withBeans() {
		cafe.restockBeans(ESPRESSO_BEANS);

	}

}
