package tools;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	
	List<Painting> paintings = new ArrayList<Painting> (5);
	List<Plumbing>  plumbings= new ArrayList<Plumbing> (5);
	List<Concrete>  concretes= new ArrayList<Concrete> (5);
	List<Woodwork>  woodworks= new ArrayList<Woodwork> (5);
	List<Yardwork>  yardworks= new ArrayList<Yardwork> (5);
	int []paintingsTaken = new int[5];
	int []plumbingsTaken = new int[5];
	int []concretesTaken = new int[5];
	int []woodworksTaken = new int[5];
	int []yardworksTaken = new int[5];

	public Inventory(List<Painting> paintings,List<Plumbing>  plumbings,List<Concrete>  concretes,List<Woodwork>  woodworks,List<Yardwork>  yardworks) {
		this.paintings = paintings;
		this.plumbings = plumbings;
		this.concretes = concretes;
		this.woodworks = woodworks;
		this.yardworks = yardworks;
		for(int i=0;i<5;i++) {
			paintingsTaken[i] = 1;
			plumbingsTaken[i] = 1;
			concretesTaken[i] = 1;
			woodworksTaken[i] = 1;
			yardworksTaken[i] = 1;
		}
	}
	
	public void getPaintingTool()
	{
		int count = 0;
		for (int i=0;i<5;i++)
		{
			if(paintingsTaken[i]==1) {
				count = count + 1;
				System.out.println(paintings.get(i).getName());
			}
			// System.out.println(painting.type);
		}
		System.out.println("Painting tool remaining: "+String.valueOf(count)+"/5");
	}
	
	public void getPlumbingTool()
	{
		int count = 0;
		for (int i=0;i<5;i++)
		{
			if(plumbingsTaken[i]==1) {
				count = count + 1;
				System.out.println(plumbings.get(i).getName());
			}
			// System.out.println(painting.type);
		}
		System.out.println("Plumbing tool remaining: "+String.valueOf(count)+"/5");
	}
	
	public void getConcreteTool()
	{
		
		int count = 0;
		for (int i=0;i<5;i++)
		{
			
			if(concretesTaken[i]==1) {
				count = count + 1;
				System.out.println(concretes.get(i).getName());
			}
			// System.out.println(painting.type);
		}
		System.out.println("Concrete tool remaining: "+String.valueOf(count)+"/5");
	}
	
	public void getWoodworkTool()
	{
		int count = 0;
		for (int i=0;i<5;i++)
		{
			if(woodworksTaken[i]==1) {
				count = count + 1;
				System.out.println(woodworks.get(i).getName());
			}
			// System.out.println(painting.type);
		}
		System.out.println("Woodwork tool remaining: "+String.valueOf(count)+"/5");
	}
	
	public void getYardworkTool()
	{
		int count = 0;
		for (int i=0;i<4;i++)
		{
			if(yardworksTaken[i]==1) {
				count = count + 1;
				System.out.println(yardworks.get(i).getName());
			}
			// System.out.println(painting.type);
		}
		System.out.println("Yardwork tool remaining: "+String.valueOf(count)+"/4");
	}
	
	public void display() {
		System.out.println("Concrete tools remaining:");
		this.getConcreteTool();
		System.out.println("Painting tools remaining:");
		this.getPaintingTool();
		System.out.println("Plumbing tools remaining:");
		this.getPlumbingTool();
		System.out.println("Woodwork tools remaining:");
		this.getWoodworkTool();
		System.out.println("Yardwork tools remaining:");
		this.getYardworkTool();
	}
	public void updateInventory(Tool t,String action) {
		String s = t.getName();
		if(s.contains("Painting")) {
			for (int i=0;i<5;i++)
			{
				if(s.contains(String.valueOf(i))) {
					if(action == "delete")
					{
						paintingsTaken[i]=0;
					}
					if(action == "add")
					{
						paintingsTaken[i]=1;
					}
				}
			}
		}
		if(s.contains("Concrete")) {
			for (int i=0;i<5;i++)
			{
				if(s.contains(String.valueOf(i))) {
					if(action == "delete")
					{
						concretesTaken[i]=0;
					}
					if(action == "add")
					{
						concretesTaken[i]=1;
					}
				}
			}
		}
		if(s.contains("Plumbing")) {
			for (int i=0;i<5;i++)
			{
				if(s.contains(String.valueOf(i))) {
					if(action == "delete")
					{
						plumbingsTaken[i]=0;
					}
					if(action == "add")
					{
						plumbingsTaken[i]=1;
					}
				}
			}
		}
		if(s.contains("Woodwork")) {
			for (int i=0;i<5;i++)
			{
				if(s.contains(String.valueOf(i))) {
					if(action == "delete")
					{
						woodworksTaken[i]=0;
					}
					if(action == "add")
					{
						woodworksTaken[i]=1;
					}
				}
			}
		}
		if(s.contains("Yardwork")) {
			for (int i=0;i<5;i++)
			{
				if(s.contains(String.valueOf(i))) {
					if(action == "delete")
					{
						yardworksTaken[i]=0;
					}
					if(action == "add")
					{
						yardworksTaken[i]=1;
					}
				}
			}
		}
		
	}
	
}
