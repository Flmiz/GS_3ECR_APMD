package br.com.fiap.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.JOptionPane;
import br.com.fiap.Window;
import br.com.fiap.dao.PostoDao;
import br.com.fiap.model.Plugue;
import br.com.fiap.model.Posto;
import br.com.fiap.util.AppCheckBox;

public class CadastroButtonListener implements ActionListener {

	private Window view;
	private PostoDao dao = new PostoDao();
	
	public CadastroButtonListener(Window view) {		
		this.view = view;
	}
	
	private boolean isDataValid() {
		boolean isValid = true;
		
		String camposInvalidos = "";
		
		camposInvalidos = view.getCadastro().getNome().getText().length() <= 0 ? camposInvalidos.concat("nome, ") : camposInvalidos;
		camposInvalidos = view.getCadastro().getEndereco().getText().length() <= 0 ? camposInvalidos.concat("endereço, ") : camposInvalidos;
		camposInvalidos = view.getCadastro().getBairro().getText().length() <= 0 ? camposInvalidos.concat("bairro, ") : camposInvalidos;
		camposInvalidos = view.getCadastro().getCidade().getText().length() <= 0 ? camposInvalidos.concat("cidade, ") : camposInvalidos;
		camposInvalidos = !view.getCadastro().getPrecoWatt().getText().replace(".", "").matches("[0-9]+") ? camposInvalidos.concat("preço do watt, ") : camposInvalidos;

		boolean hasValue = false;
		
		List<AppCheckBox> checkBoxOptions = view.getCadastro().getCheckBoxOptions();
		for (AppCheckBox appCheckBox : checkBoxOptions) {
			if (appCheckBox.isSelected()) {	
				hasValue = true;
				break;
			}
		}
		
		camposInvalidos = !hasValue ? camposInvalidos.concat("tipos de plugue, ") : camposInvalidos;
		
		if (camposInvalidos.length() > 0) {
			isValid = false;
			camposInvalidos = camposInvalidos.substring(0, camposInvalidos.length() - 2);
			JOptionPane.showMessageDialog(null, "Dados inválidos nos seguintes campos: " + camposInvalidos);
		}
		
		return isValid;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (!isDataValid()) return;
		
		Posto posto = new Posto();
		posto.setNome(view.getCadastro().getNome().getText());
		posto.setRua(view.getCadastro().getEndereco().getText());
		posto.setCidade(view.getCadastro().getCidade().getText());
		posto.setBairro(view.getCadastro().getBairro().getText());
		posto.setEstado(view.getCadastro().getEstado().getSelectedItem().toString());
		posto.setPrecoWatt(new BigDecimal(view.getCadastro().getPrecoWatt().getText()));
		posto.setAvaliacao((long) view.getCadastro().getAvaliacao().getSelection());

		dao.insertPosto(posto);
		
		List<AppCheckBox> checkBoxOptions = view.getCadastro().getCheckBoxOptions();
		for (int i = 0; i < checkBoxOptions.size(); i++) {
			if (checkBoxOptions.get(i).isSelected()) {		
				Plugue plugue = new Plugue();
				plugue.setId(Long.parseLong(posto.getId().toString() + i, 10));
				plugue.setPlugue(checkBoxOptions.get(i).getText());
				dao.insertPlugue(plugue);
			}
		}
		
		view.getConsulta().carregarDados();
		JOptionPane.showMessageDialog(null, "Posto cadastrado com sucesso.");
	}

}
