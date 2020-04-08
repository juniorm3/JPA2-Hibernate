package com.algaworks.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.modelo.Agenda;

public class ConsultarAgenda {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("agenda");
		EntityManager em = emf.createEntityManager();
		
		Agenda agenda = em.find(Agenda.class, 3L);
		
		System.out.println("Nome: " + agenda.getNome());
		System.out.println("Telefone: " + agenda.getTelefone());
		System.out.println("Data Registro: " + agenda.getDataRegistro());

	}

}
