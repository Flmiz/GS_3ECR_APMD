package br.com.fiap.util;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class AppPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public AppPanel() {
		init();
	}

	private void init() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}

}
