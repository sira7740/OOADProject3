package Customers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegularCustomerTest {

	RegularCustomer rc;
	@Before
	public void setUp() throws Exception {
		rc = new RegularCustomer("regular name");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetName() {
		assertEquals("regular name", rc.getName());
	}

	@Test
	public final void testGetCustomerType() {
		assertEquals("Regular Customer", rc.getCustomerType());
	}

}
