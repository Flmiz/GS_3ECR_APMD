package br.com.fiap.util;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

public class AppComboBox<E> extends JComboBox<E> {

	private static final long serialVersionUID = 1L;
	
	public AppComboBox(E[] values) {
		super(values);
		init();
	}
	
	public AppComboBox(E[] values, int width, int height) {
		super(values);
		init(width, height);
	}
	
	private void init() {
		this.setPreferredSize(new Dimension(170, 30));
		this.setBackground(Color.white);
		this.setForeground(new Color(50, 50, 50));
		this.setBorder(new LineBorder(new Color(26, 108, 163)));
	}
	
	private void init(int width, int height) {
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.white);
		this.setForeground(new Color(50, 50, 50));
		this.setBorder(new LineBorder(new Color(26, 108, 163)));
	}
	
}
