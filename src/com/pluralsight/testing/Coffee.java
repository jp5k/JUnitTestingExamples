package com.pluralsight.testing;
/**
 * 
 * An individual coffee that has been served
 *
 */
public class Coffee {
	
	private final CoffeeType type;
	private final int beans;
	private final int milk;
	
	public Coffee(CoffeeType coffeeType, int beans, int milk){
		this.type = coffeeType;
		this.beans = beans;
		this.milk = milk;
		
	}

	/**
	 * @return the type
	 */
	public CoffeeType getType() {
		return type;
	}

	/**
	 * @return the beans
	 */
	public int getBeans() {
		return beans;
	}

	/**
	 * @return the milk
	 */
	public int getMilk() {
		return milk;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Coffee [type=" + type + ", beans=" + beans + ", milk=" + milk
				+ "]";
	}
	
	
	

}
