package addons;

import decorator.AddOnDecorator;
import tools.Tool;


/*
 * This is a ExtensionCord which adds on to the tools if user chooses to add
 */

public class ExtensionCord extends AddOnDecorator{

	static final int price = 16;
	static final String addOnName = "ExtensionCord";
	
	public ExtensionCord(Tool tool) {
		super(tool, price,addOnName);
	}

	
}
