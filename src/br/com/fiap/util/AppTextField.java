package br.com.fiap.util;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class AppTextField extends JTextField {

	private static final long serialVersionUID = 1L;
	
	public AppTextField() {
		init();
	}
	
	public AppTextField(int width,int height) {
		init(width, height);
	}
	
	private void init() {
		this.setPreferredSize(new Dimension(170, 30));
		this.setBackground(Color.white);
		this.setForeground(new Color(50, 50, 50));
		this.setBorder(new LineBorder(new Color(26, 108, 163)));
	}
	
	private void init(int width,int height) {
		this.setPreferredSize(new Dimension(width, height));
		this.setForeground(new Color(50, 50, 50));
		this.setBorder(new LineBorder(new Color(26, 108, 163)));
	}
	
}
