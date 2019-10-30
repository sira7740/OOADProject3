package factory;

import tools.Concrete;
import tools.Painting;
import tools.Plumbing;
import tools.Tool;
import tools.Woodwork;
import tools.Yardwork;


/*
 * 2) factory design pattern
 * 
 * Here we are using factory design pattern to get tools
 * Tool factory will get you any king of tool if type is specified. 
 */
public class ToolFactory {

	public static Tool getTool(String type,String name) {
		
		if(type.equalsIgnoreCase("Concrete")) return Concrete.getInstance(name);
		if(type.equalsIgnoreCase("Painting")) return Painting.getInstance(name);
		if(type.equalsIgnoreCase("Plumbing")) return Plumbing.getInstance(name);
		
		if(type.equalsIgnoreCase("Woodwork")) return Woodwork.getInstance(name);
		if(type.equalsIgnoreCase("Yardwork")) return Yardwork.getInstance(name);
		
		else 
			
		return null;	
	}
	
}
