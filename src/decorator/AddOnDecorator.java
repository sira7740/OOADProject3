package decorator;

import tools.Tool;

/* 
 * 1) decorator design pattern
 * 
 * This is a decorator which we used to add accessory to the tools
 * 
 * */

public class AddOnDecorator implements Tool {

	 public Tool tool;
	 public int price;
	 public String addOn;
	
	
	public AddOnDecorator(Tool tool,int price,String addOn) {
		
		this.tool = tool;
		this.price = price;
		this.addOn = addOn;
	}
	
	public int getPrice() {
		
		return price+tool.getPrice();
		
	}

	@Override
	public void increaseCount() {
			
	}
	
	public String getName() {
		return this.tool.getName();
	}

	@Override
	public String getAddOn() {
		return this.addOn;
	}

	
	
	
}
