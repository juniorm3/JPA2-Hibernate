package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaFabricantes {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.creaEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		
		List<String> nomesDosfabricantes = em.createQuery("select f.nome from Fabricante f", String.class)
				.getResultList();
		
		for (String nome : nomesDosfabricantes) {
			System.out.println("Nome " + nome);
		}
		
		em.close();
	}
}
