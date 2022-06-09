package br.com.fiap.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.fiap.user.LogIn;

public class LogInButtonListener implements ActionListener {

	private LogIn view;
	
	public LogInButtonListener(LogIn view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		view.validateAceess();
	}

}
