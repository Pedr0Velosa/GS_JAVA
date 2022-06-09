package br.com.fiap.posto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import br.com.fiap.posto.dao.PostoDao;
import br.com.fiap.posto.model.Posto;
import br.com.fiap.posto.view.Endereco;
import br.com.fiap.posto.view.Informacoes;
import br.com.fiap.posto.view.Janela;

public class BotaoListener implements ActionListener{

	private Janela view;
	private Endereco endereco;
	private Informacoes informacoes;
	private PostoDao dao = new PostoDao();
	
	public BotaoListener(Janela view, Endereco endereco, Informacoes informacoes) {
		this.view = view;
		this.endereco = endereco;
		this.informacoes = informacoes;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.paramString().contains("Crescente")){
			dao.ordemAsc();
			view.ordernarAsc();
		}else if(e.paramString().contains("Decrescente")){
			dao.ordemDes();
			view.ordernarDes();
		}else if(e.paramString().contains("Salvar")){
		
			Posto posto = new Posto();
			
			posto.setNome(endereco.getNomeDoPosto().getText());
			
			posto.setRua(endereco.getRua().getText());
			posto.setBairro(endereco.getBairro().getText());
			posto.setCidade(endereco.getCidade().getText());
			posto.setEstado(endereco.getEstado().getText());
			
			posto.setAvaliacao(informacoes.getAvaliacao());
			posto.setTipo1(informacoes.getTipo1());
			posto.setTipo2(informacoes.getTipo2());
			posto.setCss2(informacoes.getCSS2());
			posto.setChademo(informacoes.getCHAdeMO());
			
			posto.setPreco(new BigDecimal(informacoes.getPreco().getText()));
					
			dao.inserir(posto);
						
			view.carregarDados();
		}else if(e.paramString().contains("Cancelar")) {
			endereco.setNomeDoPosto();
			endereco.setRua();
			endereco.setBairro();
			endereco.setCidade();
			endereco.setEstado();
			informacoes.setPreco();
		}
	}

}
