package Customers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CasualCustomerTest {
	CasualCustomer cc;

	@Before
	public void setUp() throws Exception {
		cc = new CasualCustomer("casual customer");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetName() {
		assertEquals("casual customer", cc.getName());
	}

	@Test
	public final void testGetCustomerType() {
		assertEquals("Casual Customer", cc.getCustomerType());
	}

}
