package myObserver;

import java.util.List;

import Rental.Record;
import tools.Inventory;

/*
 * 3) Observer Design Pattern
 * Interface Observer
 * all an template for observers
 */
interface Observer {
	public void update(int day,int []daysEarning,List <Record> completedOrders,List <Record> activeOrder,Inventory inventory );
}
