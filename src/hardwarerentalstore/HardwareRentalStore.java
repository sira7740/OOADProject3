package hardwarerentalstore;

import java.util.ArrayList;
import java.util.List;

import Customers.Customer;
import Rental.Record;
import addons.AccessoryKit;
import addons.ExtensionCord;
import addons.ProtectiveGearPack;
import factory.CustomerFactory;
import factory.ToolFactory;
import myObserver.DisplayObserver;
import myObserver.StoreDetails;
import tools.Concrete;
import tools.Inventory;
import tools.Painting;
import tools.Plumbing;
import tools.Tool;
import tools.Woodwork;
import tools.Yardwork;

public class HardwareRentalStore {

	public static void main(String[] args) {
		List<Painting> paintings = new ArrayList<Painting> (5);
		List<Plumbing>  plumbings= new ArrayList<Plumbing> (5);
		List<Concrete>  concretes= new ArrayList<Concrete> (5);
		List<Woodwork>  woodworks= new ArrayList<Woodwork> (5);
		List<Yardwork>  yardworks= new ArrayList<Yardwork> (5);
		List<Tool> toolList = new ArrayList<Tool>();
		int []earnings = new int[36];
		int price = 0;

		//creating inventory
		for(int i =0;i<5;i++) {
			paintings.add((Painting)ToolFactory.getTool("Painting", "Painting tool "+String.valueOf(i)));
			woodworks.add((Woodwork)ToolFactory.getTool("Woodwork", "Woodwork tool "+String.valueOf(i)));
			plumbings.add((Plumbing)ToolFactory.getTool("Plumbing", "Plumbing tool "+String.valueOf(i)));
			concretes.add((Concrete)ToolFactory.getTool("Concrete", "Concrete tool "+String.valueOf(i)));
		}
		for (int i=0;i<4;i++) {
			yardworks.add((Yardwork)ToolFactory.getTool("Yardwork", "Yardwork tool "+String.valueOf(i)));
		}
		
		Inventory toolsInventory = new Inventory(paintings,plumbings,concretes,woodworks,yardworks);
		 
		//display Observer and registering it
		DisplayObserver displayStoreDetails = new DisplayObserver();
		StoreDetails details = new StoreDetails(toolsInventory);
		details.registerObserver(displayStoreDetails);
		
		
		// Day 1 Starts
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");

		// System.out.println("Stats after end of Day "+ String.valueOf(details.getDay())+
		// 		" OR before Day "+ String.valueOf(details.getDay()+1)+ ":");
		System.out.println();
		//customer comes in
		Customer temp = CustomerFactory.getCustomerWithId(6);
		//tool chosen
		Painting day1_c1_t1 = paintings.get(0);
		details.getInventory().updateInventory(day1_c1_t1,"delete");
		Painting day1_c1_t2 = paintings.get(3);
		details.getInventory().updateInventory(day1_c1_t2,"delete");
		//Options Chosen
		Tool day1_c1_option = new AccessoryKit(day1_c1_t1);
		//Add chosen tools to customer tool list
		toolList = new ArrayList<Tool>();
		toolList.add(day1_c1_option);
		toolList.add(day1_c1_t2);
		//Make a Record of Customer Data
		Record rec_d1_c1 = new Record(temp,toolList,2,2);  // Need to change record with list of tools
		price = price + rec_d1_c1.getPrice();
		//Add Data into Active Records
		details.updateActiveRecords(rec_d1_c1);
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged(); // Change Day
		
		
		// Day 2 Starts
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		//Customer Comes In
		temp = CustomerFactory.getCustomerWithId(5);
		//Tool Chosen
		Painting day2_c1_t1 = paintings.get(1);
		details.getInventory().updateInventory(day2_c1_t1,"delete");
		//Options Chosen
		Tool day2_c1_option = new ExtensionCord(day2_c1_t1);
		//Add chosen tools to customer tool list
		List<Tool> toolList2 = new ArrayList<Tool>();
		toolList2.add(day2_c1_option);
		// Make a Record of Customer Data
		Record rec_d2_c1 = new Record(temp,toolList2,2,2);
		price = price + rec_d2_c1.getPrice();
		// Add customer data into Active Records
		details.updateActiveRecords(rec_d2_c1);
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged(); // Change Day
		
		// Day 3 Starts
		
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		temp = CustomerFactory.getCustomerWithId(1);
		//Tool Chosen
		Painting day3_c1_t1 = paintings.get(4);
		details.getInventory().updateInventory(day3_c1_t1,"delete");
		//Tool Options Chosen
		Tool day3_c1_o1 = new ProtectiveGearPack(day3_c1_t1);
		//Toollist directory
		List<Tool> toolList3 = new ArrayList<Tool>();
		toolList3.add(day3_c1_o1);
		
		// Make a record of Active orders
		Record rec_d3_c1 = new Record(temp,toolList3,2,2);
		price = price + rec_d3_c1.getPrice();
		details.updateActiveRecords(rec_d3_c1);
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		// System.out.println("check"+details.getDay());
		details.dayChanged();
		
		// Day 4 Starts
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		//Choose Customer
		temp = CustomerFactory.getCustomerWithId(10);
		//Tool Chosen
		Plumbing day4_c1_t1 = plumbings.get(4);
		Yardwork day4_c1_t2 = yardworks.get(1);
		Concrete day4_c1_t3 = concretes.get(2);
		details.getInventory().updateInventory(day4_c1_t1,"delete");
		details.getInventory().updateInventory(day4_c1_t2,"delete");
		details.getInventory().updateInventory(day4_c1_t3,"delete");
		//Tool Options Chosen
		Tool day4_c1_o1 = new ProtectiveGearPack(day4_c1_t1);
		Tool day4_c1_o2 = new ExtensionCord(day4_c1_t2);
		//Toollist directory
		List<Tool> toolList4 = new ArrayList<Tool>();
		toolList4.add(day4_c1_o1);
		toolList4.add(day4_c1_o2);
		toolList4.add(day4_c1_t3);
				
		// Make a record of Active orders
		Record rec_d4_c1 = new Record(temp,toolList4,7,7);
		price = price + rec_d4_c1.getPrice();
		details.updateActiveRecords(rec_d4_c1);
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		// System.out.println("check"+details.getDay());
		details.dayChanged();
		
		//Day 5 Starts
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		//Choose Customer
		temp = CustomerFactory.getCustomerWithId(1);
		//Tool Chosen
		Woodwork day5_c1_t1 = woodworks.get(4);
		Yardwork day5_c1_t2 = yardworks.get(3);
		details.getInventory().updateInventory(day5_c1_t1,"delete");
		details.getInventory().updateInventory(day5_c1_t2,"delete");
		//Toollist directory
		List<Tool> toolList5 = new ArrayList<Tool>();
		toolList5.add(day5_c1_t1);
		toolList5.add(day5_c1_t2);
		// Make a record of Active orders
		Record rec_d5_c1 = new Record(temp,toolList5,3,3);
		price = price + rec_d5_c1.getPrice();
		details.updateActiveRecords(rec_d5_c1);
		
		// Choose customer 2
		temp = CustomerFactory.getCustomerWithId(7);
		//Tool chosen for customer 2
		Concrete day5_c2_t1 = concretes.get(3);
		Plumbing day5_c2_t2 = plumbings.get(0);
		details.getInventory().updateInventory(day5_c2_t1,"delete");
		details.getInventory().updateInventory(day5_c2_t2,"delete");
		////Tool Options Chosen
		Tool day5_c2_o1 = new ProtectiveGearPack(day5_c2_t1);
		List<Tool> toolList5_c2 = new ArrayList<Tool>();
		toolList5_c2.add(day5_c2_o1);
		toolList5_c2.add(day5_c2_t2);
		// Make a record of Active orders
		Record rec_d5_c2 = new Record(temp,toolList5_c2,2,2);
		price = price + rec_d5_c2.getPrice();
		details.updateActiveRecords(rec_d5_c2);
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged();
		
		//Day 6 Starts
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		//No customer comes on Day 6
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged();
		
		//Day 7 starts
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		//Choose Business Customer
		temp = CustomerFactory.getCustomerWithId(9);
		//Tool Chosen
		Plumbing day7_c1_t1 = plumbings.get(0);
		Yardwork day7_c1_t2 = yardworks.get(2);
		Concrete day7_c1_t3 = concretes.get(1);
		details.getInventory().updateInventory(day7_c1_t1,"delete");
		details.getInventory().updateInventory(day7_c1_t2,"delete");
		details.getInventory().updateInventory(day7_c1_t3,"delete");
		//Tool Options Chosen
		Tool day7_c1_o1 = new ProtectiveGearPack(day7_c1_t1);
		Tool day7_c1_o2 = new ExtensionCord(day7_c1_t2);
		//Toollist directory
		List<Tool> toolList7 = new ArrayList<Tool>();
		toolList7.add(day7_c1_o1);
		toolList7.add(day7_c1_o2);
		toolList7.add(day7_c1_t3);
		
		// Make a record of Active orders
		Record rec_d7_c1 = new Record(temp,toolList7,7,7);
		price = price + rec_d7_c1.getPrice();
		details.updateActiveRecords(rec_d7_c1);
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		// System.out.println("check"+details.getDay());
		details.dayChanged();
		
		//Day 8 Starts
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		//Casual Customer comes In
		temp = CustomerFactory.getCustomerWithId(8);
		//Tool Chosen
		Painting day8_c1_t1 = paintings.get(1);
		Concrete day8_c1_t2 = concretes.get(4);
		details.getInventory().updateInventory(day8_c1_t1,"delete");
		details.getInventory().updateInventory(day8_c1_t2,"delete");
		//Options Chosen
		Tool day8_c1_option = new ExtensionCord(day8_c1_t1);
		//Add chosen tools to customer tool list
		List<Tool> toolList8 = new ArrayList<Tool>();
		toolList8.add(day8_c1_option);
		toolList8.add(day8_c1_t2);
		// Make a Record of Customer Data
		Record rec_d8_c1 = new Record(temp,toolList8,2,2);
		price = price + rec_d8_c1.getPrice();
		// Add customer data into Active Records
		details.updateActiveRecords(rec_d8_c1);
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged(); // Change Day
		
		//Day 9 Starts
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		//Regular Customer comes In
		temp = CustomerFactory.getCustomerWithId(8);
		//Tool Chosen
		Woodwork day9_c1_t1 = woodworks.get(1);
		Woodwork day9_c1_t2 = woodworks.get(4);
		details.getInventory().updateInventory(day9_c1_t1,"delete");
		details.getInventory().updateInventory(day9_c1_t2,"delete");
		//Options Chosen
		Tool day9_c1_option = new AccessoryKit(day9_c1_t1);
		//Add chosen tools to customer tool list
		List<Tool> toolList9 = new ArrayList<Tool>();
		toolList9.add(day9_c1_option);
		toolList9.add(day9_c1_t2);
		// Make a Record of Customer Data
		Record rec_d9_c1 = new Record(temp,toolList9,2,2);
		price = price + rec_d9_c1.getPrice();
		// Add customer data into Active Records
		details.updateActiveRecords(rec_d9_c1);
		//Regular customer comes in
		temp = CustomerFactory.getCustomerWithId(7);
		//Tool Chosen
		Yardwork day9_c2_t1 = yardworks.get(0);
		Yardwork day9_c2_t2 = yardworks.get(3);
		details.getInventory().updateInventory(day9_c2_t1,"delete");
		details.getInventory().updateInventory(day9_c2_t2,"delete");
		//Add chosen tools to customer tool list
		List<Tool> toolList9_c2 = new ArrayList<Tool>();
		toolList9_c2.add(day9_c2_t1);
		toolList9_c2.add(day9_c2_t2);
		// Make a Record of Customer Data
		Record rec_d9_c2 = new Record(temp,toolList9_c2,2,2);
		price = price + rec_d9_c2.getPrice();
		// Add customer data into Active Records
		details.updateActiveRecords(rec_d9_c2);
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged(); // Change Day
		
		//Day 10 Starts
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		//No customer comes on Day 10
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged();
		
		//Day 11 Starts
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		temp = CustomerFactory.getCustomerWithId(5);
		//Tool Chosen
		Painting day11_c1_t1 = paintings.get(0);
		details.getInventory().updateInventory(day11_c1_t1,"delete");
		//Tool Options Chosen
		Tool day11_c1_o1 = new ProtectiveGearPack(day11_c1_t1);
		//Toollist directory
		List<Tool> toolList11 = new ArrayList<Tool>();
		toolList11.add(day11_c1_o1);
		
		// Make a record of Active orders
		Record rec_d11_c1 = new Record(temp,toolList11,2,2);
		price = price + rec_d11_c1.getPrice();
		details.updateActiveRecords(rec_d11_c1);
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged();
		
		//Day 12 Starts
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		temp = CustomerFactory.getCustomerWithId(4);
		//Tool Chosen
		Painting day12_c1_t1 = paintings.get(4);
		details.getInventory().updateInventory(day12_c1_t1,"delete");
		//Tool Options Chosen
		Tool day12_c1_o1 = new ExtensionCord(day12_c1_t1);
		//Toollist directory
		List<Tool> toolList12 = new ArrayList<Tool>();
		toolList12.add(day12_c1_o1);
		
		// Make a record of Active orders
		Record rec_d12_c1 = new Record(temp,toolList12,5,5);
		price = price + rec_d12_c1.getPrice();
		details.updateActiveRecords(rec_d12_c1);
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged();
		
		// Day 13
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		temp = CustomerFactory.getCustomerWithId(1);
		//Tool Chosen
		Painting day13_c1_t1 = paintings.get(2);
		details.getInventory().updateInventory(day13_c1_t1,"delete");
		//Tool Options Chosen
		Tool day13_c1_o1 = new ExtensionCord(day13_c1_t1);
		//Toollist directory
		List<Tool> toolList13 = new ArrayList<Tool>();
		toolList13.add(day13_c1_o1);
		
		// Make a record of Active orders
		Record rec_d13_c1 = new Record(temp,toolList13,5,5);
		price = price + rec_d13_c1.getPrice();
		details.updateActiveRecords(rec_d13_c1);
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged();
		
		//Day 14 Starts
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		//Choose Business Customer
		temp = CustomerFactory.getCustomerWithId(9);
		//Tool Chosen
		Plumbing day14_c1_t1 = plumbings.get(0);
		Yardwork day14_c1_t2 = yardworks.get(2);
		Concrete day14_c1_t3 = concretes.get(1);
		details.getInventory().updateInventory(day14_c1_t1,"delete");
		details.getInventory().updateInventory(day14_c1_t2,"delete");
		details.getInventory().updateInventory(day14_c1_t3,"delete");
		//Tool Options Chosen
		Tool day14_c1_o1 = new ProtectiveGearPack(day14_c1_t1);
		Tool day14_c1_o2 = new ExtensionCord(day14_c1_t2);
		//Toollist directory
		List<Tool> toolList14 = new ArrayList<Tool>();
		toolList14.add(day14_c1_o1);
		toolList14.add(day14_c1_o2);
		toolList14.add(day14_c1_t3);
		
		// Make a record of Active orders
		Record rec_d14_c1 = new Record(temp,toolList14,7,7);
		price = price + rec_d14_c1.getPrice();
		details.updateActiveRecords(rec_d14_c1);
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged();
		
		//Day 15 Starts
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		//Choose Business Customer
		temp = CustomerFactory.getCustomerWithId(10);
		//Tool Chosen
		Plumbing day15_c1_t1 = plumbings.get(1);
		Yardwork day15_c1_t2 = yardworks.get(0);
		Concrete day15_c1_t3 = concretes.get(0);
		details.getInventory().updateInventory(day15_c1_t1,"delete");
		details.getInventory().updateInventory(day15_c1_t2,"delete");
		details.getInventory().updateInventory(day15_c1_t3,"delete");
		//Tool Options Chosen
		Tool day15_c1_o1 = new AccessoryKit(day15_c1_t1);
		Tool day15_c1_o2 = new ExtensionCord(day15_c1_t2);
		//Toollist directory
		List<Tool> toolList15 = new ArrayList<Tool>();
		toolList15.add(day15_c1_o1);
		toolList15.add(day15_c1_o2);
		toolList15.add(day15_c1_t3);
		// Make a record of Active orders
		Record rec_d15_c1 = new Record(temp,toolList15,7,7);
		price = price + rec_d15_c1.getPrice();
		details.updateActiveRecords(rec_d15_c1);
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged();
		
		//Day 16 Starts
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		//Choose Business Customer
		temp = CustomerFactory.getCustomerWithId(11);
		//Tool Chosen
		Woodwork day16_c1_t1 = woodworks.get(1);
		Yardwork day16_c1_t2 = yardworks.get(3);
		Concrete day16_c1_t3 = concretes.get(4);
		details.getInventory().updateInventory(day16_c1_t1,"delete");
		details.getInventory().updateInventory(day16_c1_t2,"delete");
		details.getInventory().updateInventory(day16_c1_t3,"delete");
		//Tool Options Chosen
		Tool day16_c1_o1 = new AccessoryKit(day16_c1_t1);
		Tool day16_c1_o2 = new ProtectiveGearPack(day16_c1_t2);
		//Toollist directory
		List<Tool> toolList16 = new ArrayList<Tool>();
		toolList16.add(day16_c1_o1);
		toolList16.add(day16_c1_o2);
		toolList16.add(day16_c1_t3);
		// Make a record of Active orders
		Record rec_d16_c1 = new Record(temp,toolList16,7,7);
		price = price + rec_d16_c1.getPrice();
		details.updateActiveRecords(rec_d16_c1);
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged();
		
		// Day 17 Starts
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		//Choose Customer
		temp = CustomerFactory.getCustomerWithId(3);
		//Tool Chosen
		Woodwork day17_c1_t1 = woodworks.get(4);
		Painting day17_c1_t2 = paintings.get(3);
		details.getInventory().updateInventory(day17_c1_t1,""
				+ "delete");
		details.getInventory().updateInventory(day17_c1_t2,"delete");
		//Toollist directory
		List<Tool> toolList17 = new ArrayList<Tool>();
		toolList17.add(day17_c1_t1);
		toolList17.add(day17_c1_t2);
		// Make a record of Active orders
		Record rec_d17_c1 = new Record(temp,toolList17,5,5);
		price = price + rec_d17_c1.getPrice();
		details.updateActiveRecords(rec_d17_c1);
				
		// Choose customer 2
		temp = CustomerFactory.getCustomerWithId(7);
		//Tool chosen for customer 2
		Concrete day17_c2_t1 = concretes.get(3);
		Plumbing day17_c2_t2 = plumbings.get(4);
		details.getInventory().updateInventory(day17_c2_t1,"delete");
		details.getInventory().updateInventory(day17_c2_t2,"delete");
		//Tool Options Chosen
		Tool day17_c2_o1 = new ProtectiveGearPack(day17_c2_t1);
		List<Tool> toolList17_c2 = new ArrayList<Tool>();
		toolList17_c2.add(day17_c2_o1);
		toolList17_c2.add(day17_c2_t2);
		// Make a record of Active orders
		Record rec_d17_c2 = new Record(temp,toolList17_c2,5,5);
		price = price + rec_d17_c2.getPrice();
		details.updateActiveRecords(rec_d17_c2);
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged();
		
		//Day 18 Starts
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		//No customer comes on Day 18
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged();
		
		//Day 19 Start
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		temp = CustomerFactory.getCustomerWithId(2);
		//Tool Chosen
		Painting day19_c1_t1 = paintings.get(4);
		details.getInventory().updateInventory(day19_c1_t1,"delete");
		//Tool Options Chosen
		Tool day19_c1_o1 = new ProtectiveGearPack(day19_c1_t1);
		//Toollist directory
		List<Tool> toolList19 = new ArrayList<Tool>();
		toolList19.add(day19_c1_o1);
		
		// Make a record of Active orders
		Record rec_d19_c1 = new Record(temp,toolList19,4,4);
		price = price + rec_d19_c1.getPrice();
		details.updateActiveRecords(rec_d19_c1);
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		// System.out.println("check"+details.getDay());
		details.dayChanged();
		
		//Day 20 Start
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		//Customer Comes In
		temp = CustomerFactory.getCustomerWithId(5);
		//Tool Chosen
		Woodwork day20_c1_t1 = woodworks.get(2);
		details.getInventory().updateInventory(day20_c1_t1,"delete");
		//Options Chosen
		Tool day20_c1_option = new ExtensionCord(day20_c1_t1);
		//Add chosen tools to customer tool list
		List<Tool> toolList20 = new ArrayList<Tool>();
		toolList20.add(day20_c1_option);
		// Make a Record of Customer Data
		Record rec_d20_c1 = new Record(temp,toolList20,2,2);
		price = price + rec_d20_c1.getPrice();
		// Add customer data into Active Records
		details.updateActiveRecords(rec_d20_c1);
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged(); // Change Day
		
		//Day 21 Start
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		//Choose Business Customer
		temp = CustomerFactory.getCustomerWithId(10);
		//Tool Chosen
		Plumbing day21_c1_t1 = plumbings.get(0);
		Yardwork day21_c1_t2 = yardworks.get(1);
		Concrete day21_c1_t3 = concretes.get(1);
		details.getInventory().updateInventory(day21_c1_t1,"delete");
		details.getInventory().updateInventory(day21_c1_t2,"delete");
		details.getInventory().updateInventory(day21_c1_t3,"delete");
		//Tool Options Chosen
		Tool day21_c1_o1 = new ProtectiveGearPack(day21_c1_t1);
		Tool day21_c1_o2 = new ExtensionCord(day21_c1_t2);
		//Toollist directory
		List<Tool> toolList21 = new ArrayList<Tool>();
		toolList21.add(day21_c1_o1);
		toolList21.add(day21_c1_o2);
		toolList21.add(day21_c1_t3);
		// Make a record of Active orders
		Record rec_d21_c1 = new Record(temp,toolList21,7,7);
		price = price + rec_d21_c1.getPrice();
		details.updateActiveRecords(rec_d21_c1);
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged();
		
		// Day 22 Start
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		//No customer comes on Day 22
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged();
		
		//Day 23 Start
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		//Choose Business Customer
		temp = CustomerFactory.getCustomerWithId(9);
		//Tool Chosen
		Painting day23_c1_t1 = paintings.get(0);
		Woodwork day23_c1_t2 = woodworks.get(1);
		Concrete day23_c1_t3 = concretes.get(1);
		details.getInventory().updateInventory(day23_c1_t1,"delete");
		details.getInventory().updateInventory(day23_c1_t2,"delete");
		details.getInventory().updateInventory(day23_c1_t3,"delete");
		//Tool Options Chosen
		Tool day23_c1_o1 = new ProtectiveGearPack(day23_c1_t1);
		Tool day23_c1_o2 = new AccessoryKit(day23_c1_t2);
		//Toollist directory
		List<Tool> toolList23 = new ArrayList<Tool>();
		toolList23.add(day23_c1_o1);
		toolList23.add(day23_c1_o2);
		toolList23.add(day23_c1_t3);
		// Make a record of Active orders
		Record rec_d23_c1 = new Record(temp,toolList23,7,7);
		price = price + rec_d23_c1.getPrice();
		details.updateActiveRecords(rec_d23_c1);
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged();
		
		//Day 24 Start
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		temp = CustomerFactory.getCustomerWithId(3);
		//Tool Chosen
		Painting day24_c1_t1 = paintings.get(4);
		details.getInventory().updateInventory(day24_c1_t1,"delete");
		//Tool Options Chosen
		Tool day24_c1_o1 = new ProtectiveGearPack(day24_c1_t1);
		//Toollist directory
		List<Tool> toolList24 = new ArrayList<Tool>();
		toolList24.add(day24_c1_o1);
		
		// Make a record of Active orders
		Record rec_d24_c1 = new Record(temp,toolList24,5,5);
		price = price + rec_d24_c1.getPrice();
		details.updateActiveRecords(rec_d24_c1);
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged();
		
		// Day 25 Start
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		//No customer comes on Day 25
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged();
		
		//Day 26 Start
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		//Choose Customer
		temp = CustomerFactory.getCustomerWithId(4);
		//Tool Chosen
		Woodwork day26_c1_t1 = woodworks.get(4);
		Painting day26_c1_t2 = paintings.get(3);
		details.getInventory().updateInventory(day26_c1_t1,"delete");
		details.getInventory().updateInventory(day26_c1_t2,"delete");
		//Toollist directory
		List<Tool> toolList26 = new ArrayList<Tool>();
		toolList26.add(day26_c1_t1);
		toolList26.add(day26_c1_t2);
		// Make a record of Active orders
		Record rec_d26_c1 = new Record(temp,toolList26,5,5);
		price = price + rec_d26_c1.getPrice();
		details.updateActiveRecords(rec_d26_c1);
						
		// Choose Business customer 2
		temp = CustomerFactory.getCustomerWithId(11);
		//Tool chosen for customer 2
		Concrete day26_c2_t1 = concretes.get(3);
		Plumbing day26_c2_t2 = plumbings.get(4);
		Yardwork day26_c2_t3 = yardworks.get(0);
		details.getInventory().updateInventory(day26_c2_t1,"delete");
		details.getInventory().updateInventory(day26_c2_t2,"delete");
		details.getInventory().updateInventory(day26_c2_t3,"delete");
		//Tool Options Chosen
		Tool day26_c2_o1 = new ProtectiveGearPack(day26_c2_t1);
		List<Tool> toolList26_c2 = new ArrayList<Tool>();
		toolList26_c2.add(day26_c2_o1);
		toolList26_c2.add(day26_c2_t2);
		toolList26_c2.add(day26_c2_t3);
		// Make a record of Active orders
		Record rec_d26_c2 = new Record(temp,toolList26_c2,7,7);
		price = price + rec_d26_c2.getPrice();
		details.updateActiveRecords(rec_d26_c2);
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged();
		
		//Day 27 Start
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		temp = CustomerFactory.getCustomerWithId(2);
		//Tool Chosen
		Painting day27_c1_t1 = paintings.get(1);
		details.getInventory().updateInventory(day27_c1_t1,"delete");
		//Tool Options Chosen
		Tool day27_c1_o1 = new ProtectiveGearPack(day27_c1_t1);
		//Toollist directory
		List<Tool> toolList27 = new ArrayList<Tool>();
		toolList27.add(day27_c1_o1);
		
		// Make a record of Active orders
		Record rec_d27_c1 = new Record(temp,toolList27,4,4);
		price = price + rec_d27_c1.getPrice();
		details.updateActiveRecords(rec_d27_c1);
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged();
		
		// Day 28 Start
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		temp = CustomerFactory.getCustomerWithId(7);
		//Tool Chosen
		Plumbing day28_c1_t1 = plumbings.get(1);
		details.getInventory().updateInventory(day28_c1_t1,"delete");
		//Tool Options Chosen
		Tool day28_c1_o1 = new ProtectiveGearPack(day28_c1_t1);
		//Toollist directory
		List<Tool> toolList28 = new ArrayList<Tool>();
		toolList28.add(day28_c1_o1);
		// Make a record of Active orders
		Record rec_d28_c1 = new Record(temp,toolList28,2,2);
		price = price + rec_d28_c1.getPrice();
		details.updateActiveRecords(rec_d28_c1);
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged();
		
		// Day 29 Start
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		temp = CustomerFactory.getCustomerWithId(1);
		//Tool Chosen
		Painting day29_c1_t1 = paintings.get(3);
		details.getInventory().updateInventory(day29_c1_t1,"delete");
		//Tool Options Chosen
		Tool day29_c1_o1 = new ProtectiveGearPack(day29_c1_t1);
		//Toollist directory
		List<Tool> toolList29 = new ArrayList<Tool>();
		toolList29.add(day29_c1_o1);
		// Make a record of Active orders
		Record rec_d29_c1 = new Record(temp,toolList29,2,2);
		price = price + rec_d29_c1.getPrice();
		details.updateActiveRecords(rec_d29_c1);
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged();
		
		//Day 30 Start
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		temp = CustomerFactory.getCustomerWithId(1);
		//Tool Chosen
		Painting day30_c1_t1 = paintings.get(0);
		details.getInventory().updateInventory(day30_c1_t1,"delete");
		//Tool Options Chosen
		Tool day30_c1_o1 = new ProtectiveGearPack(day29_c1_t1);
		//Toollist directory
		List<Tool> toolList30 = new ArrayList<Tool>();
		toolList29.add(day30_c1_o1);
		// Make a record of Active orders
		Record rec_d30_c1 = new Record(temp,toolList30,2,2);
		price = price + rec_d30_c1.getPrice();
		details.updateActiveRecords(rec_d30_c1);
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged();
		
		//Day31 Start
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		temp = CustomerFactory.getCustomerWithId(10);
		//Tool Chosen
		Tool day31_c1_t1 = paintings.get(2);
		details.getInventory().updateInventory(day31_c1_t1,"delete");
		Yardwork day31_c1_t2 = yardworks.get(3);
		details.getInventory().updateInventory(day31_c1_t2,"delete");
		Woodwork day31_c1_t3 = woodworks.get(2);
		details.getInventory().updateInventory(day31_c1_t3,"delete");
		//Tool Options Chosen
		day31_c1_t1 = new ProtectiveGearPack(day31_c1_t1);
		//Toollist directory
		List<Tool> toolList31 = new ArrayList<Tool>();
		toolList31.add(day31_c1_t1);
		toolList31.add(day31_c1_t2);
		toolList31.add(day31_c1_t3);
		
		// Make a record of Active orders
		Record rec_d31_c1 = new Record(temp,toolList31,7,7);
		price = price + rec_d24_c1.getPrice();
		details.updateActiveRecords(rec_d31_c1);
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged();
		
		//Day 32 Start
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		//No customer comes on Day 32
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged();
		
		//Day 33 Start
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		temp = CustomerFactory.getCustomerWithId(6);
		//Tool Chosen
		Painting day33_c1_t1 = paintings.get(3);
		details.getInventory().updateInventory(day33_c1_t1,"delete");
		//Tool Options Chosen
		Tool day33_c1_o1 = new ProtectiveGearPack(day33_c1_t1);
		//Toollist directory
		List<Tool> toolList33 = new ArrayList<Tool>();
		toolList33.add(day33_c1_o1);
		
		// Make a record of Active orders
		Record rec_d33_c1 = new Record(temp,toolList33,4,4);
		price = price + rec_d33_c1.getPrice();
		details.updateActiveRecords(rec_d33_c1);
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged();
		
		//Day 34 Start
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		//No customer comes on Day 34
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged();
		
		//Day 35 Start
		System.out.println("################################# Day "+ String.valueOf(details.getDay())+
				" Renting ###################################");
		System.out.println();
		price = 0;
		//Choose Business Customer
		temp = CustomerFactory.getCustomerWithId(11);
		//Tool Chosen
		Woodwork day35_c1_t1 = woodworks.get(1);
		Yardwork day35_c1_t2 = yardworks.get(3);
		Concrete day35_c1_t3 = concretes.get(4);
		details.getInventory().updateInventory(day35_c1_t1,"delete");
		details.getInventory().updateInventory(day35_c1_t2,"delete");
		details.getInventory().updateInventory(day35_c1_t3,"delete");
		//Tool Options Chosen
		Tool day35_c1_o1 = new AccessoryKit(day35_c1_t1);
		Tool day35_c1_o2 = new ProtectiveGearPack(day35_c1_t2);
		//Toollist directory
		List<Tool> toolList35 = new ArrayList<Tool>();
		toolList16.add(day35_c1_o1);
		toolList16.add(day35_c1_o2);
		toolList16.add(day35_c1_t3);
		// Make a record of Active orders
		Record rec_d35_c1 = new Record(temp,toolList35,7,7);
		price = price + rec_d35_c1.getPrice();
		details.updateActiveRecords(rec_d35_c1);
		earnings[details.getDay()] = price;
		details.updateDaysEarning(earnings[details.getDay()]);
		details.dayChanged();
		//expiring all active orders as question says we need to consider orders on last day also
		details.expireAllActiveOrders();
		
		
		//Printing total spend based by each type of customers
		
		int []customerTypeOrder = new int[3];
		int []earningsPerCustomer = new int[3];
		for(int i=0;i<3;i++) {
			customerTypeOrder[i]=0;
		}
		String type;
		int j=0;
		for(Record r : details.getCompletedOrders()) {
			type = r.customer.getCustomerType();
			j=j+1;
			if(type=="Casual Customer") {
				customerTypeOrder[0]=customerTypeOrder[0]+1;
				earningsPerCustomer[0] = earningsPerCustomer[0] +r.getPrice();
			}
			else if(type=="Regular Customer") {
				customerTypeOrder[1]=customerTypeOrder[1]+1;
				earningsPerCustomer[1] = earningsPerCustomer[1]+ r.getPrice();
			}
			else if(type=="Buisness Customer") {
				customerTypeOrder[2]=customerTypeOrder[2]+1;
				earningsPerCustomer[2] = earningsPerCustomer[2] + r.getPrice();
			}
			else {
				System.out.println(r.customer.getCustomerType());
			}
		}
		System.out.println("################################# Completed Orders "+
				" ###################################");
		System.out.println("################################# Total "+ details.getCompletedOrders().size() +
				" ###################################");
		System.out.println("################################# Casual Customer  "+ customerTypeOrder[0] +
				" ###################################");
		System.out.println("################################# Regular Customer  "+ customerTypeOrder[1] +
				" ###################################");
		System.out.println("################################# Buisness Customer  "+ customerTypeOrder[2] +
				" ###################################");
		
		int totalEarnings = earningsPerCustomer[0] + earningsPerCustomer[1] +earningsPerCustomer[2];
		System.out.println("################################# Total Earnings of store  "+ totalEarnings +
				" ###################################");
		System.out.println("################################# Earnings from Casual Customer  "+ earningsPerCustomer[0] +
				" ###################################");
		System.out.println("################################# Earnings from Regular Customer  "+ earningsPerCustomer[1] +
				" ###################################");
		System.out.println("################################# Earnings from Buisness Customer  "+ earningsPerCustomer[2] +
				" ###################################");

	}

}