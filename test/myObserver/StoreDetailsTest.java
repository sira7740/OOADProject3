package myObserver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import factory.ToolFactory;
import tools.Concrete;
import tools.Inventory;
import tools.Painting;
import tools.Plumbing;
import tools.Woodwork;
import tools.Yardwork;

public class StoreDetailsTest {
	StoreDetails subject;
	Inventory inventory;
	List<Painting> paintings = new ArrayList<Painting> (5);
	List<Plumbing>  plumbings= new ArrayList<Plumbing> (5);
	List<Concrete>  concretes= new ArrayList<Concrete> (5);
	List<Woodwork>  woodworks= new ArrayList<Woodwork> (5);
	List<Yardwork>  yardworks= new ArrayList<Yardwork> (5);

	@Before
	public void setUp() throws Exception {
		for(int i =0;i<5;i++) {
			paintings.add((Painting)ToolFactory.getTool("Painting", "Painting tool "+String.valueOf(i)));
			woodworks.add((Woodwork)ToolFactory.getTool("Woodwork", "Woodwork tool "+String.valueOf(i)));
			plumbings.add((Plumbing)ToolFactory.getTool("Plumbing", "Plumbing tool "+String.valueOf(i)));
			concretes.add((Concrete)ToolFactory.getTool("Concrete", "Concrete tool "+String.valueOf(i)));
		}
		for (int i=0;i<4;i++) {
			yardworks.add((Yardwork)ToolFactory.getTool("Yardwork", "Yardwork tool "+String.valueOf(i)));
		}
		Inventory inventory = new Inventory(paintings, plumbings, concretes, woodworks, yardworks);
		subject = new StoreDetails(inventory);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testSetInventory() {
		subject.setInventory(inventory);
		assertEquals(inventory, subject.getInventory());
	}

	@Test
	public final void testUpdateTools() {
		Painting tool_day1 = paintings.get(0);
		subject.getInventory().updateInventory(tool_day1, "delete");
		subject.updateTools(inventory);
		assertNull((subject.getInventory()));
	}

	@Test
	public final void testGetDay() {
		assertEquals(1, subject.getDay());
	}

}
