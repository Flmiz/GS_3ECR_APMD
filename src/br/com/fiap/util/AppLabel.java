package br.com.fiap.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class AppLabel extends JLabel {

	private static final long serialVersionUID = 1L;
	
	private int fontSize = 14;

	public AppLabel(String text) {
		super(text);
		init();
	}
	
	public AppLabel(String text, int fontSize) {
		super(text);
		this.fontSize = fontSize;
		init();
	}
	
	private void init() {
		this.setHorizontalAlignment(JLabel.LEFT);
		this.setForeground(Color.black);
		this.setFont(new Font(null, Font.BOLD, this.fontSize));
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
	}
	
}
