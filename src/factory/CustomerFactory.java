package factory;


import java.util.ArrayList;
import java.util.List;

import Customers.BusinessCustomer;
import Customers.CasualCustomer;
import Customers.Customer;
import Customers.RegularCustomer;


/*
 * 2) factory design pattern
 * 
 * Here we are using factory design pattern to get customers
 * Limiting customer instance creation to 12
 * Assigning customers to the ids as it will be easy to access
 * 
 * 
 */


public class CustomerFactory {
	static List<Customer> customers = new ArrayList<Customer> (12);
	
	
public static Customer getCustomerWithId(int id) {
	
	for(int i=0;i<5;i++) {
		customers.add(new RegularCustomer("Regular_customer_"+String.valueOf(i)));
	}
	
	for(int i=5;i<9;i++) {
		customers.add(new CasualCustomer("Casual_customer_"+String.valueOf(i)));
	}
	
	for(int i=9;i<12;i++) {
		customers.add(new BusinessCustomer("Business_customer_"+String.valueOf(i)));
	}


		if(id>0 && id<12) {
			return customers.get(id);
		}
		return null;
		
	}
	
}
