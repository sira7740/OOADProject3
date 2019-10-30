package Customers;

/*
 * Casual Customer class
 * This extends Customer interface
 * Used to check for number of tools a customer type can take.
 */

public class CasualCustomer extends Customer {

	public CasualCustomer(String name) {

		this.name = name;
		this.CustomerType = "Casual Customer";

	}

}
