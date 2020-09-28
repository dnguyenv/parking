package util;

import javax.swing.ImageIcon;

public class Util {
	private static final String ICONS_PATH = "/view/icons/"; 

	public static ImageIcon getIcon(Class<?> dclass, String icon){
		return new ImageIcon(dclass.getResource(ICONS_PATH + icon + ".gif"));
	}
}
