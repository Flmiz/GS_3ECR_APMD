package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Plugue;
import br.com.fiap.model.Posto;

public class PostoDao {

	EntityManagerFactory postoFactory = Persistence.createEntityManagerFactory("posto");
	EntityManager postoManager = postoFactory.createEntityManager();
	
	EntityManagerFactory plugueFactory = Persistence.createEntityManagerFactory("plugue");
	EntityManager plugueManager = plugueFactory.createEntityManager();
	
	public void insertPosto(Posto posto) {
		postoManager.getTransaction().begin();
		postoManager.persist(posto);
		postoManager.getTransaction().commit();
	}
	
	public void insertPlugue(Plugue plugue) {
		plugueManager.getTransaction().begin();
		plugueManager.persist(plugue);
		plugueManager.getTransaction().commit();
	}
	
	public List<Posto> listAllPostos() {
		String jpql = "SELECT p FROM Posto p";
		TypedQuery<Posto> query = postoManager.createQuery(jpql , Posto.class);
		
		return query.getResultList();
	}
	
	public List<Plugue> listAllPlugues() {
		String jpql = "SELECT p FROM Plugue p";
		TypedQuery<Plugue> query = plugueManager.createQuery(jpql , Plugue.class);
		
		return query.getResultList();
	}
	
	public void delete(Posto posto) {
		postoManager.getTransaction().begin();
		postoManager.remove(posto);
		postoManager.getTransaction().commit();
	}
	
}
