package br.com.fiap.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.fiap.Consulta;

public class MapaButtonController implements ActionListener {

	Consulta view;
	
	public MapaButtonController(Consulta view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		view.gerarMapa();
	}

}
