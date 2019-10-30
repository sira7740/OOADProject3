package tools;


/*
 * Class Painting
 * implements tool
 * which has a per object cost of 5 and can only have 5 instances
 */

public class Painting implements Tool{

	public static final int price = 5;
	public String name;
	public static int count = 5;
	public String type = "Painting";
	
	private Painting(String name){
		this.name=name;
	}
	
	public static Tool getInstance(String name) {
		
		if(count >= 1) {
			count--;
			return new Painting(name);
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
