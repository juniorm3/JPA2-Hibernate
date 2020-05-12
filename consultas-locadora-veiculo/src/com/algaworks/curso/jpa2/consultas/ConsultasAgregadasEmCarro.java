package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.info.AluguelCarroInfo;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultasAgregadasEmCarro {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.creaEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		String jpql = "select c, count(a), max(a.valorTotal), min(a.valorTotal), avg(a.valorTotal), sum(a.valorTotal) " 
				+ "from Carro c JOIN c.alugueis a "
				+ "group by c "
				+ "having count(a) > 1";

		
//		List<Object[]> resultados = em.createQuery(jpql).getResultList();
//		for (Object[] obj : resultados) {
//			System.out.println("Modelo: " + ((Carro) obj[0]).getModelo().getDescricao());
//			System.out.println("Quantidade de alugueis: " + obj[1]);
//			System.out.println("Valor máximo: " + obj[2]);
//			System.out.println("Valor minimo: " + obj[3]);
//			System.out.println("Valor médio: " + obj[4]);
//			System.out.println("Soma dos alugueis: " + obj[5]);
//			System.out.println("");
//		}

		String jpql2 = "select NEW com.algaworks.curso.jpa2.info.AluguelCarroInfo(c, count(a), max(a.valorTotal), min(a.valorTotal), avg(a.valorTotal), sum(a.valorTotal)) "
				+ "from Carro c JOIN c.alugueis a "
				+ "group by c "
				+ "having count(a) > 1";
		
		List<AluguelCarroInfo> resultados2 = em.createQuery(jpql2, AluguelCarroInfo.class).getResultList();
		for (AluguelCarroInfo aci : resultados2) {
			System.out.println("Modelo: " + aci.getCarro().getModelo().getDescricao());
			System.out.println("Quantidade de alugueis: " + aci.getTotalAlugueis());
			System.out.println("Valor máximo: " + aci.getValorMaximo());
			System.out.println("Valor minimo: " + aci.getValorMinimo());
			System.out.println("Valor médio: " + aci.getValorMedio());
			System.out.println("Soma dos alugueis: " + aci.getSomaTotal());
			System.out.println("");
		}


		em.close();
	}

}
