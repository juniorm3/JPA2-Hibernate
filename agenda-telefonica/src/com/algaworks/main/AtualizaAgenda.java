package com.algaworks.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.modelo.Agenda;

public class AtualizaAgenda {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("agenda");
		EntityManager em = emf.createEntityManager();
		
		Agenda agenda = em.find(Agenda.class,4L);
		
		if(agenda != null) {
			agenda.setNome("Desenvolvedor SW");
			
			em.getTransaction().begin();
			em.getTransaction().commit();
			
			System.out.println("Agenda atualizada com sucesso!");			
		} else {
			System.out.println("Agenda não encontrada!");
		}
	}

}
