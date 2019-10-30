package myObserver;

import java.util.ArrayList;
import java.util.List;

import Rental.Record;
import tools.Inventory;

/**
 * 3) Observer Design Pattern
 * class DisplayObserver
 * This class will maintain all updated variables and display when requested
 *  
 *
 */
public class DisplayObserver implements Observer {
	
	int day;
	int []daysEarning = new int[37];
	List <Record> completedOrders = new ArrayList<Record>();
	List <Record> activeOrder = new ArrayList<Record>();
	Inventory inventory;

	public DisplayObserver() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(int day, int []daysEarning, List<Record> completedOrders, List<Record> activeOrder,
			Inventory inventory) {
		this.day = day;
		this.daysEarning = daysEarning;
		this.completedOrders = completedOrders;
		this.activeOrder = activeOrder;
		this.inventory = inventory;
		this.display();
		
	}
	
public void display() {
		
		
		System.out.println("*********************** Active Order Placed by Customer ***************************");
		System.out.println();
		System.out.println("Total Active Orders: "+ String.valueOf(activeOrder.size()));
		System.out.println();
		for(int i=0;i<activeOrder.size();i++) {
			// System.out.println("order number :"+String.valueOf(i));
			System.out.println("Active Order "+(i+1)+": ");
			System.out.println("------------------------------------");
			activeOrder.get(i).print();
			System.out.println();
		}
		
		System.out.println("**************************** Completed Order by Day "+ String.valueOf(day)+" *****************************");
		System.out.println();
		System.out.println("Total Completed Orders: "+ String.valueOf(completedOrders.size()));
		System.out.println();
		for(int i=0;i<completedOrders.size();i++) {
			System.out.println("Completed Order "+(i+1)+": ");
			System.out.println("------------------------------------");
			completedOrders.get(i).print();
			System.out.println();
		}
		System.out.println("########################## Total Earning on Day "+ String.valueOf(day)+" : " +
				String.valueOf(daysEarning[day-1])+ "$ ###########################" );
		
		System.out.println();
		
		System.out.println("**************************** Inventories before Day "+ String.valueOf(day+1)
				+" ***************************** ");
		System.out.println();
		this.inventory.display();
		System.out.println();
	}

}
