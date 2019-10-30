package tools;

/*
 * Class Plumbing
 * implements tool
 * which has a per object cost of 7 and can only have 5 instances
 */

public class Plumbing implements Tool{

	static final int price = 7;
	
	static int count = 5;
	public String type = "Plumbing";
	public String name;
	
	private Plumbing(String name){
		this.name=name;
	}
	
	public static Tool getInstance(String name) {
		
		if(count > 0) {
			count--;
			return new Plumbing(name);
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
		// TODO Auto-generated method stub
		return "";
	}
}
