package decorator;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import factory.ToolFactory;
import tools.Tool;

public class AddOnDecoratorTest {
	AddOnDecorator ad;

	@Before
	public void setUp() throws Exception {
		Tool painting = ToolFactory.getTool("painting", "painting tool 1");
		ad = new AddOnDecorator(painting, 4, "AccessoryKit");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetPrice() {
		assertEquals(9,ad.getPrice());
		
	}

	@Test
	public final void testGetName() {
		assertEquals(ad.getName(), "painting tool 1");
	}

	@Test
	public final void testGetAddOn() {
		assertEquals(ad.getAddOn(), "AccessoryKit");
	}

}
