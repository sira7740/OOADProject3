package factory;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tools.Tool;

public class ToolFactoryTest {

	Tool t;

	@Before
	public void setUp() throws Exception {
		t = ToolFactory.getTool("Painting", "painting tool 1");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetTool() {
		assertEquals("painting tool 1", t.getName());
	}

}
