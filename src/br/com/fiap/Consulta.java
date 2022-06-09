package br.com.fiap;

import java.awt.Dimension;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import java.util.Vector;
import br.com.fiap.dao.PostoDao;
import br.com.fiap.listeners.ConsultaButtonListener;
import br.com.fiap.listeners.MapaButtonController;
import br.com.fiap.listeners.TabelaListener;
import br.com.fiap.model.Plugue;
import br.com.fiap.model.Posto;

public class Consulta extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private int width, height;
		
	private List<Vector<String>> lista = new ArrayList<Vector<String>>();
	private String endereco;
	
	private String[] colunas = {
			"nome", "rua", "bairro", "cidade",
			"estado", "plugue", "preço/Watt", "Avaliação"};
	private DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
	public JTable tabela = new JTable(tableModel) {
        private static final long serialVersionUID = 1L;

        public boolean isCellEditable(int row, int column) {                
                return false;               
        };
    };

	public Consulta(int width, int height) {
		this.width = width;
		this.height = height;
		
		init();
	}

	private void init() {	
		JButton button = new JButton("Ordenar por estado");
		JButton mapaButton = new JButton("Gerar mapa (Selecione um posto)");

		ConsultaButtonListener buttonListener = new ConsultaButtonListener(this);
		button.addActionListener(buttonListener);
		
		TabelaListener tabelaListener = new TabelaListener(this);
		tabela.getSelectionModel().addListSelectionListener(tabelaListener);
		
		MapaButtonController mapaButtonListener = new MapaButtonController(this);
		mapaButton.addActionListener(mapaButtonListener);
		
		carregarDados();
		
		this.add(button);
		this.add(mapaButton);
		
		JScrollPane scroll = new JScrollPane(tabela,   ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(width - 20, height / 2 + 50));
	    
		this.add(scroll);
	}
	
	public void carregarDados() {	
		lista.clear();
		tableModel.setRowCount(0);
		List<Posto> listaPosto = new PostoDao().listAllPostos();
		List<Plugue> listaPlugue = new PostoDao().listAllPlugues();
		
		for (Posto posto : listaPosto) {
			String plugues = "";
			for (Plugue plugue : listaPlugue) {
				String plugueId = plugue.getId().toString();
				plugueId = plugueId.substring(0, plugueId.length() - 1);
				if (Integer.parseInt(plugueId) == posto.getId()) {
					plugues += plugue.getPlugue() + ", ";			
				}
			}
			plugues = plugues.substring(0, plugues.length() - 2);
			Vector<String> data = (Vector<String>) posto.getData();
			data.set(5, plugues);
			lista.add(data);
		}
		
		lista.forEach(posto -> {
			tableModel.addRow(posto);
		});
	}
	
	public void ordenarEstado() {
		tableModel.setRowCount(0);
		
		for (int i = 0; i < lista.size() - 1; i++) {
			for (int j = i + 1; j < lista.size(); j++) {
				if (lista.get(i).get(4).compareTo(lista.get(j).get(4)) > 0) {
					Vector<String> temp = lista.get(i);
					lista.set(i, lista.get(j));
					lista.set(j, temp);
				}
			}
		}
		
		lista.forEach(posto -> {
			tableModel.addRow(posto);
		});				
	}
	
	 public void setEndereco() {
		int row = tabela.getSelectedRow();
		
		if (row == -1) return;
		
		endereco = tabela.getModel().getValueAt(row, 1).toString();
		endereco = endereco.concat("," + tabela.getModel().getValueAt(row, 4).toString());
		endereco = endereco.replace(' ', '_');
	}
	
	public void gerarMapa() {
		try {
			int width = 600;
			int height = 500;
			
			String url = "https://maps.googleapis.com/maps/api/staticmap?zoom=15&size=" + width + "x" + height + "&markers=color:red|"+ endereco + "&key=AIzaSyAtQSFh1xVy-Gu6QJmaDYt2NkHkgAfrWF0";
			JLabel map = new JLabel(new ImageIcon(ImageIO.read(new URL(url))));
			
			JFrame frame = new JFrame();
			frame.setTitle(endereco);
			frame.setSize(width, height);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);	
			
			frame.add(map);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
