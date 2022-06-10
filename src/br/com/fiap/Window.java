package br.com.fiap;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import br.com.fiap.listeners.CadastroButtonListener;
import br.com.fiap.user.LogIn;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private Cadastro cadastro;
	private Consulta consulta;

	private int width, height;
	
	public Cadastro getCadastro() {
		return cadastro;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public Window(String title, int width, int height) {
		
		this.width = width;
		this.height = height;
		
		init();
		
		this.setTitle(title);
		this.setSize(width, height);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);	
	}

	private void init() {
		CadastroButtonListener listener = new CadastroButtonListener(this);
		
		cadastro = new Cadastro(width, height, listener);
		consulta = new Consulta(width, height);
		
		JTabbedPane tabs = new JTabbedPane();	
		tabs.add("Cadastro", new LogIn(width, height, cadastro));
		tabs.add("Consulta", consulta);
		
		this.add(tabs);
	}
}
