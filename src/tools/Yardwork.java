package tools;


/*
 * Class Yardwork
 * implements tool
 * which has a per object cost of 8 and can only have 4 instances
 */
public class Yardwork implements Tool{

	static final int price = 8;
	
	static int count = 4;
	public String type = "Yardwork";
	public String name;
	
	private Yardwork(String name){
		this.name=name;
	}
	
	public static Tool getInstance(String name) {
		
		if(count >0) {
			count--;
			return new Yardwork(name);
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
