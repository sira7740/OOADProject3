package tools;

/*
 * Class Woodwork
 * implements tool
 * which has a per object cost of 8 and can only have 5 instances
 */

public class Woodwork implements Tool{

	static final int price = 8;
	
	static int count = 5;
	public String type = "Woodwork";
	public String name;
	
	private Woodwork(String name){
		this.name=name;
	}
	
	public static Tool getInstance(String name) {
		
		if(count >0) {
			count--;
			return new Woodwork(name);
		}
		else {
			return null;
		}
		
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public int getPrice() {
		
		return price;
	}
	
	@Override
	public String getAddOn() {
		return "";
	}
}
