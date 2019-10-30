package tools;

/*
 * Class Concrete
 * implements tool
 * which has a per object cost of 6 and can only have 5 instances
 */


public class Concrete implements Tool{

	static final  int price = 6;
	public String name;
	static int count = 5;
	public String type = "Concrete";
	private  Concrete(String name){
		this.name = name;
	}
	
	public static Tool getInstance(String name) {
		
		if(count > 0) {
			count = count-1;
			return new Concrete(name);
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
