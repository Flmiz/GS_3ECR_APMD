package br.com.fiap;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import br.com.fiap.listeners.CadastroButtonListener;
import br.com.fiap.util.AppButtonGroup;
import br.com.fiap.util.AppCheckBox;
import br.com.fiap.util.AppComboBox;
import br.com.fiap.util.AppLabel;
import br.com.fiap.util.AppTextField;
import br.com.fiap.util.OptionType;
import br.com.fiap.util.StarRater;
import br.com.fiap.util.StarRater.StarListener;

public class Cadastro extends JPanel {

	private static final long serialVersionUID = 1L;

	private int width, height;
	
	private AppTextField nome;
	private AppTextField endereco;
	private AppTextField bairro;
	private AppTextField cidade;
	private AppComboBox<String> estado;
	private List<AppCheckBox> checkBoxOptions;
	private AppTextField precoWatt;
	private StarRater avaliacao;
	
	private JButton button;
	
	private String[] estados = {
			"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", 
			"MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", 
			"RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
	
	public AppTextField getNome() {
		return nome;
	}

	public AppTextField getEndereco() {
		return endereco;
	}

	public AppTextField getBairro() {
		return bairro;
	}

	public AppTextField getCidade() {
		return cidade;
	}

	public AppComboBox<String> getEstado() {
		return estado;
	}

	public List<AppCheckBox> getCheckBoxOptions() {
		return checkBoxOptions;
	}

	public AppTextField getPrecoWatt() {
		return precoWatt;
	}
	
	public JButton getButton() {
		return button;
	}
	
	public StarRater getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(StarRater avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Cadastro(int width, int height, CadastroButtonListener listener) {
		this.width = width;
		this.height = height;

		nome = new AppTextField(width/2 + 10, 25);
		endereco = new AppTextField(width/4, 25);
		bairro = new AppTextField(width/4, 25);
		cidade = new AppTextField(width/4, 25);
		estado = new AppComboBox<String>(estados, width/4, 25);
		estado.setAlignmentX(0);
		precoWatt = new AppTextField(width/4, 25);
		avaliacao = new StarRater(5);
		
		button = new JButton("Cadastrar");
		button.addActionListener(listener);
		
		init();
	}
	
	public void init() {
		this.setPreferredSize(new Dimension(width, height));
		
		JPanel textField = new JPanel(new FlowLayout(FlowLayout.LEFT));
		textField.setPreferredSize(new Dimension(width/2 + 50, height));
		
		JPanel checkField = new JPanel(new FlowLayout(FlowLayout.LEFT));
		checkField.setPreferredSize(new Dimension(width/2 - 90, height));

		textField.add(createFirstRow());
		textField.add(createSecondRow());
		textField.add(createThirdRow());
		textField.add(button);
		
		checkField.add(createCheckBox());
		checkField.add(createWattField());
		
		this.add(textField);
		this.add(checkField);
	}

	private JPanel createFirstRow() {
		JPanel firstRow = new JPanel();
		
		firstRow.setLayout(new BoxLayout(firstRow, BoxLayout.Y_AXIS));
		firstRow.add(new AppLabel("Nome:"));
		firstRow.add(nome);
		
		return firstRow;
	}
	
	private JPanel createSecondRow() {
		JPanel secondRow = new JPanel(new FlowLayout(FlowLayout.LEFT));

		JPanel firstPanel = new JPanel();
		JPanel secondPanel = new JPanel();
		firstPanel.setLayout(new BoxLayout(firstPanel, BoxLayout.Y_AXIS));
		secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.Y_AXIS));

		firstPanel.add(new AppLabel("Endereço:"));
		firstPanel.add(endereco);
		secondPanel.add(new AppLabel("Bairro:"));
		secondPanel.add(bairro);

		secondRow.add(firstPanel);
		secondRow.add(secondPanel);
		
		return secondRow;
	}
	
	private JPanel createThirdRow() {
		JPanel thirdRow = new JPanel(new FlowLayout(FlowLayout.LEFT));

		JPanel firstPanel = new JPanel();
		JPanel secondPanel = new JPanel();
		firstPanel.setLayout(new BoxLayout(firstPanel, BoxLayout.Y_AXIS));
		secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.Y_AXIS));
		
		firstPanel.add(new AppLabel("Cidade:"));
		firstPanel.add(cidade);
		secondPanel.add(new AppLabel("Estado:"));
		secondPanel.add(estado);

		
		thirdRow.add(firstPanel);
		thirdRow.add(secondPanel);
		
		return thirdRow;
	}
	
	private JPanel createCheckBox() {
		JPanel checkBox = new JPanel(new FlowLayout(FlowLayout.LEFT));
		checkBox.setLayout(new BoxLayout(checkBox, BoxLayout.Y_AXIS));
				
		List<String> sites = new ArrayList<>();
		
		sites.add("tipo1");
		sites.add("tipo2");
		sites.add("CSS2");
		sites.add("CHAdeMO");
		
		AppButtonGroup options = new AppButtonGroup(sites, OptionType.CHECK_BOX);
		checkBoxOptions = options.GetCheckBoxOptions();
		
		checkBox.add(new AppLabel("Plugues disponíveis:"));
		checkBox.add(options);
		
		return checkBox;
	}
	
	private JPanel createWattField() {
		JPanel wattField = new JPanel();
		wattField.setLayout(new BoxLayout(wattField, BoxLayout.Y_AXIS));
		wattField.setAlignmentX(0);	

		wattField.add(new AppLabel("Preço do Watt:"));
		wattField.add(precoWatt);
		wattField.add(new AppLabel("Avaliação:"));
		wattField.add(avaliacao);
		
		return wattField;
	}
	
}
