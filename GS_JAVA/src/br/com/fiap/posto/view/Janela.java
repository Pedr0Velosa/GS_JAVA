package br.com.fiap.posto.view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.fiap.posto.controller.BotaoListener;
import br.com.fiap.posto.dao.PostoDao;
import br.com.fiap.posto.model.Posto;

public class Janela extends JFrame{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Endereco endereco = new Endereco();
	Informacoes informacoes = new Informacoes();
	
	String[] colunas = {"id", "Nome", "Rua", 
			"Bairro", "Cidade", "Estado",
			"Tipo 1", "Tipo 2", "CSS2", "CHAdeMO",
			"Preço", "Avaliação"
			}; 
	DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
	JTable tabela = new JTable(tableModel);
	
	
	public Janela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Postos de abastecimento");
		setSize(950, 408);
		setResizable(false);
	}
	
	public void init() {
	JTabbedPane abas = new JTabbedPane();	
		JPanel cadastro = new JPanel();		
				
		abas.add("Cadastro", cadastro);
		
		cadastro.setLayout(new BorderLayout());
		
		
	    JLabel img = new JLabel(new ImageIcon(((new ImageIcon("./img/imagemPosto.jpg")).getImage()).getScaledInstance(250, 278, java.awt.Image.SCALE_SMOOTH)));

		JPanel botoes = new JPanel();
			JButton salvar = new JButton("Salvar");
			JButton cancelar = new JButton("Cancelar");
			botoes.add(salvar);
			botoes.add(cancelar);
		
		BotaoListener listener = new BotaoListener(this, endereco, informacoes);
		salvar.addActionListener(listener);
		cancelar.addActionListener(listener);	

		cadastro.add(img, BorderLayout.LINE_START);
		cadastro.add(endereco, BorderLayout.CENTER);
		cadastro.add(informacoes, BorderLayout.LINE_END);
		cadastro.add(botoes, BorderLayout.PAGE_END);
		
		
		tabela.setDefaultEditor(Object.class, null);

		JPanel lista = new JPanel();
		JPanel ordem = new JPanel();
		JButton ordenarASC = new JButton("Ordem Crescente");
		JButton ordenarDES = new JButton("Ordem Decrescente");
			ordem.add(ordenarASC);
			ordem.add(ordenarDES);
				ordenarASC.addActionListener(listener);
				ordenarDES.addActionListener(listener);
			
		lista.setLayout(new BorderLayout());
		lista.add(new JScrollPane(tabela), BorderLayout.CENTER);
		lista.add(ordem, BorderLayout.PAGE_END);
		
		abas.add(lista, "Lista");
		
		setVisible(true);
		
		add(abas);
	}
	
	public void ordernarDes() {
		tableModel.setRowCount(0);
		List<Posto> lista = new PostoDao().ordemDes();
		lista.forEach(posto -> tableModel.addRow(posto.getData()));
	}
	
	
	public void ordernarAsc() {
		tableModel.setRowCount(0);
		List<Posto> lista = new PostoDao().ordemAsc();
		lista.forEach(posto -> tableModel.addRow(posto.getData()));
	}
	
	public void carregarDados() {
		tableModel.setRowCount(0);
		List<Posto> lista = new PostoDao().listarTodos();
		lista.forEach(posto -> tableModel.addRow(posto.getData()));
	}
}









