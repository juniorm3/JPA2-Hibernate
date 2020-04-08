package com.algaworks.main;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.modelo.Agenda;

public class InserirAgenda {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("agenda");
		EntityManager em = emf.createEntityManager();
		
		Agenda agenda = new Agenda();
		agenda.setNome("Analista");
		agenda.setTelefone("2222-3333");
		agenda.setDataRegistro(new Date());
		
		em.getTransaction().begin();
		
		em.persist(agenda);
		
		em.getTransaction().commit();
		
		System.out.println("Agenda inserida com sucesso!");
		
	}

}
