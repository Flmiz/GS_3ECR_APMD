package br.com.fiap.util;

import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class AppPadding {
	
	public static Border padding(int x1, int y1, int x2, int y2) {
		return new EmptyBorder(x1, y1, x2, y2);
	}

}
