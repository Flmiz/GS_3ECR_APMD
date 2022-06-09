package br.com.fiap.listeners;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.com.fiap.Consulta;

public class TabelaListener implements ListSelectionListener {

	Consulta view;
	
	public TabelaListener(Consulta view) {
		this.view = view;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting()) {
			view.setEndereco();
		}
	}

}
