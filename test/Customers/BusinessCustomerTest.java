package Customers;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BusinessCustomerTest {
	BusinessCustomer bc;

	@Before
	public void setUp() throws Exception {
		bc = new BusinessCustomer("my name");
		System.out.println("setting up");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearing down");
	}

	@Test
	public final void testGetName() {
		assertEquals("my name",bc.getName());
	}

	@Test
	public final void testGetCustomerType() {
		assertEquals("Buisness Customer", bc.CustomerType);
	}

}
