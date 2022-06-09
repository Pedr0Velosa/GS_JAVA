package br.com.fiap.posto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.fiap.posto.model.Posto;

public class PostoDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("posto");
	
	EntityManager manager = factory.createEntityManager();
	
	public void inserir(Posto posto) {

		manager.getTransaction().begin();
		manager.persist(posto);
		manager.getTransaction().commit();
		
	}
	
	public List<Posto> ordemDes(){
		
		
		String jpql = "SELECT p FROM Posto p order by p.estado desc";
		TypedQuery<Posto> query = manager.createQuery(jpql, Posto.class);
		return query.getResultList();
	} 
	
	public List<Posto> ordemAsc(){
		
		String jpql = "SELECT p FROM Posto p order by p.estado asc";
		TypedQuery<Posto> query = manager.createQuery(jpql, Posto.class);
		return query.getResultList();
	} 
	
	public List<Posto> listarTodos(){
		
		String jpql = "SELECT p FROM Posto p";
		TypedQuery<Posto> query = manager.createQuery(jpql, Posto.class);
		
		return query.getResultList();
	}
}
