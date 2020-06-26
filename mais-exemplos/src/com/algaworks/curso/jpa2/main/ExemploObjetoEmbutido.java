package com.algaworks.curso.jpa2.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.modelo.Proprietario;
import com.algaworks.curso.jpa2.modelo.Veiculo;
import com.algaworks.curso.jpa2.modelo.VeiculoId;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ExemploObjetoEmbutido {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		Veiculo veiculo = new Veiculo();
		veiculo.setCodigo(new VeiculoId("AAA-1111", "Rio de Janeiro"));
		veiculo.setFabricante("Volks");
		veiculo.setModelo("Gol");

		Proprietario proprietario = new Proprietario();
		proprietario.setNome("João da Silva");
		proprietario.setTelefone("111111");
		proprietario.setEmail("joao@silva.com");
		veiculo.setProprietario(proprietario);

		em.getTransaction().begin();

		em.persist(veiculo);

		em.getTransaction().commit();

		em.close();
	}

}
