package br.com.fiap.user;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.com.fiap.listeners.LogInButtonListener;
import br.com.fiap.model.InfoAdmin;
import br.com.fiap.util.AppLabel;
import br.com.fiap.util.AppTextField;

public class LogIn extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private int width, height;
	
	private AppTextField user;
	private AppTextField password;
	private JButton logInButton;
	private JPanel page;
	
	public LogIn(int width, int height, JPanel page) {
		this.page = page;
		this.width = width;
		this.height = height;
		
		init();
	}
	
	private void init() {
		user = new AppTextField(width/3, 25);
		password = new AppTextField(width/3, 25);
		
		logInButton = new JButton("Entrar");
		
		LogInButtonListener listener = new LogInButtonListener(this);
		logInButton.addActionListener(listener);

		this.add(createUserField());	
	}

	private JPanel createUserField() {
		JPanel field = new JPanel();
		JPanel fieldSet = new JPanel();
		field.setPreferredSize(new Dimension(width / 3, height));
		fieldSet.setPreferredSize(new Dimension(width / 2, height));

		field.add(new AppLabel("User:"));
		field.add(user);
		field.add(new AppLabel("Password:"));
		field.add(password);
		field.add(logInButton);
		
		fieldSet.add(new AppLabel("User = admin, Password = admin"));
		fieldSet.add(field);
		
		return fieldSet;
	}
	
	public void validateAceess() {
		System.out.println();
		if (user.getText().compareTo(InfoAdmin.user) == 0
				&& password.getText().compareTo(InfoAdmin.password) == 0) {
			this.removeAll();
			this.add(page);
			return;
		}
		
		JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválidos");
	}
}
