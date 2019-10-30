package factory;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Customers.Customer;

public class CustomerFactoryTest {

	Customer c;
	
	@Before
	public void setUp() throws Exception {
		c = CustomerFactory.getCustomerWithId(4);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetCustomerName() {
		assertEquals("Regular_customer_4", c.getName());
	}

	@Test
	public final void testGetCustomerWithId() {
		assertEquals(null, CustomerFactory.getCustomerWithId(0));
	}

}
