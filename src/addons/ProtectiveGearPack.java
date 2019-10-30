package addons;

import decorator.AddOnDecorator;
import tools.Tool;


/*
 * This is a ProtectiveGearPack which adds on to the tools if user chooses to add
 */

public class ProtectiveGearPack extends AddOnDecorator{

	static final int price = 25;
	static final String addOnName = "ProtectiveGearPack";
	
	public ProtectiveGearPack(Tool tool) {
		super(tool, price,addOnName);
	}

	
}
