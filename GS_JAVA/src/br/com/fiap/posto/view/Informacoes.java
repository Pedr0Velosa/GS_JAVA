package br.com.fiap.posto.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Informacoes extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JCheckBox tipo1 = new JCheckBox("tipo 1");
	private JCheckBox tipo2 = new JCheckBox("tipo 2");
	private JCheckBox CSS2 = new JCheckBox("CSS2");
	private JCheckBox CHAdeMO = new JCheckBox("CHAdeMO");
	private StarRater star = new StarRater();
	
	private Input preco = new Input();
	
	public Informacoes() {
				
		JPanel tipos = new JPanel();
		tipos.setBorder(new CompoundBorder(new TitledBorder("Tipos de abastecimento"), new EmptyBorder(12, 0, 0, 0)));
			JPanel tiposBotoes = new JPanel();
				tiposBotoes.setLayout(new GridLayout(2, 2));

				tiposBotoes.add(tipo1);
				tiposBotoes.add(tipo2);
				tiposBotoes.add(CSS2);
				tiposBotoes.add(CHAdeMO);
			JPanel precoBox = new JPanel();
				precoBox.setLayout(new BoxLayout(precoBox, BoxLayout.Y_AXIS));
				precoBox.add(new Label("Preço kW/h( Usar . )"));
				precoBox.add(preco);
			
			JPanel avalicaoBox = new JPanel();
				avalicaoBox.setLayout(new BoxLayout(avalicaoBox, BoxLayout.Y_AXIS));
				avalicaoBox.add(new Label("Avaliação"));
				avalicaoBox.add(star);
				
			tipos.setLayout(new BorderLayout());
			tipos.setMaximumSize(new Dimension(1000, 310));
			tipos.add(tiposBotoes, BorderLayout.PAGE_START);
			tipos.add(avalicaoBox);
			tipos.add(precoBox, BorderLayout.PAGE_END);
			
		this.setLayout(new BorderLayout());

		this.add(tipos);
	}

	public String getTipo1() {
		if(tipo1.isSelected()) {
			return "OK";
		}
		return "X";
	}

	public String getTipo2() {
		if(tipo2.isSelected()) {
			return "OK";
		}
		return "X";
	}

	public String getCSS2() {
		if(CSS2.isSelected()) {
			return "OK";
		}
		return "X";
	}

	public String getCHAdeMO() {
		if(CHAdeMO.isSelected()) {
			return "OK";
		}
		return "X";
	}

	public Input getPreco() {
		return preco;
	}
	public void setPreco() {
		this.preco.setText("");
	}
	
	public int getAvaliacao() {
		return star.getSelection();
	}
}











