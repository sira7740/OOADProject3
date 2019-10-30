package Customers;

/*
 * Business Customer class
 * This extends Customer interface
 * Used to check for number of tools a customer type can take.
 */

public class BusinessCustomer extends Customer {

	public BusinessCustomer(String name) {
		
		this.name=name;
		this.CustomerType = "Buisness Customer";
	}
	
	
	
}
