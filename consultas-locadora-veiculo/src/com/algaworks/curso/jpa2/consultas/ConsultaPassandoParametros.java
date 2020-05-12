package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaPassandoParametros {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.creaEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		String modelo = "Chevrolet";
		
//		String jpql = "select mc.descricao from ModeloCarro mc "
//				+ "where mc.fabricante.nome = ?1";
//		
//		List<String> modelos = em.createQuery(jpql, String.class)
//				.setParameter(1, modelo)
//				.getResultList();
		
		String jpql = "select mc.descricao from ModeloCarro mc "
				+ "where mc.fabricante.nome = :modelo";
		
		List<String> modelos = em.createQuery(jpql, String.class)
				.setParameter("modelo", modelo)
				.getResultList();
		
		for (String m : modelos) {
			System.out.println(modelo);
		}
		
		em.close();
	}

}
