package com.algaworks.curso.jpa2.consultas;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TemporalType;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaAluguelPorData {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.creaEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		Calendar inicioCalendar = Calendar.getInstance();
		inicioCalendar.set(2020, 7, 25, 7, 0); // 24 de Agosto de 2020 7:00 horas
		Date inicio = inicioCalendar.getTime();
		
		Calendar fimCalendar = Calendar.getInstance();
		fimCalendar.set(2020, 11, 30, 18, 0); // 25 de Agosto de 2020 18:00 horas
		Date fim = fimCalendar.getTime();
		
		String jpql = "select count(a) "
				+ "from Aluguel a "
				+ "where a.dataEntrega BETWEEN :inicio AND :fim";
		
		Long quantidadeDevolucoes = em.createQuery(jpql, Long.class)
				.setParameter("inicio", inicio, TemporalType.TIMESTAMP)
				.setParameter("fim", fim, TemporalType.TIMESTAMP)
				.getSingleResult();
		
		System.out.println("Quantidade de devoluções: " + quantidadeDevolucoes);
		
		em.close();
	}
}
