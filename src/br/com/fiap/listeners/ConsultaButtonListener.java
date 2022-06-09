package br.com.fiap.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.fiap.Consulta;

public class ConsultaButtonListener implements ActionListener {

	Consulta view;
	
	public ConsultaButtonListener(Consulta view) {
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent e) {
		view.ordenarEstado();
	}

}
