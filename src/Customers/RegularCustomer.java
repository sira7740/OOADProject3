package Customers;

/*
 * Regular Customer class
 * This extends Customer interface
 * Used to check for number of tools a customer type can take.
 */
public class RegularCustomer extends Customer {

	public RegularCustomer(String name) {

		this.name = name;
		this.CustomerType = "Regular Customer";
	}

}
