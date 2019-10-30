package addons;

import decorator.AddOnDecorator;
import tools.Tool;

/*
 * This is a AccessoryKit which addson to the tools if user choosed to add
 */

public class AccessoryKit extends AddOnDecorator{

	static final int price = 18;
	static final String addOnName = "AccessoryKit";
	
	public AccessoryKit(Tool tool) {
		super(tool, price,addOnName);
	}
}
