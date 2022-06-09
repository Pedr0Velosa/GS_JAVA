package br.com.fiap.posto.view;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Endereco extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Input nomeDoPosto = new Input();
	private Input rua = new Input();
	private Input bairro = new Input();
	private Input cidade = new Input();
	private Input estado = new Input();

	public Endereco() {

		JPanel nome = new JPanel();
		nome.setBorder(new CompoundBorder(new TitledBorder("Nome do estabelecimento"), new EmptyBorder(12, 0, 0, 0)));
		nome.setLayout(new BoxLayout(nome, BoxLayout.Y_AXIS));
		nome.setMaximumSize(new Dimension(1000, 60));
		nome.add(nomeDoPosto);

		JPanel endereco = new JPanel();
		endereco.setBorder(new CompoundBorder(new TitledBorder("Endereço"), new EmptyBorder(12, 0, 0, 0)));
		endereco.setLayout(new BoxLayout(endereco, BoxLayout.Y_AXIS));
		endereco.setMaximumSize(new Dimension(1000, 240));
		endereco.add(new Label("Rua"));
		endereco.add(rua);
		endereco.add(new Label("Bairro"));
		endereco.add(bairro);
		endereco.add(new Label("Cidade"));
		endereco.add(cidade);
		endereco.add(new Label("Estado"));
		endereco.add(estado);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(nome);
		this.add(endereco);
	}

	public Input getNomeDoPosto() {
		return nomeDoPosto;
	}

	public Input getRua() {
		return rua;
	}

	public Input getBairro() {
		return bairro;
	}

	public Input getCidade() {
		return cidade;
	}

	public Input getEstado() {
		return estado;
	}

	public void setNomeDoPosto() {
		this.nomeDoPosto.setText("");
	}

	public void setRua() {
		this.rua.setText("");
	}

	public void setBairro() {
		this.bairro.setText("");
	}

	public void setCidade() {
		this.cidade.setText("");
	}

	public void setEstado() {
		this.estado.setText("");
	}

}
