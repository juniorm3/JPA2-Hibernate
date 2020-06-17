package com.algaworks.curso.jpa2.criteria;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algaworks.curso.jpa2.modelo.Acessorio;
import com.algaworks.curso.jpa2.modelo.Carro;

public class ExemploCascataCarroAcessorio {

	private static EntityManagerFactory factory;

	private EntityManager manager;

	@BeforeClass
	public static void init() {
		factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
	}

	@Before
	public void setUp() {
		this.manager = factory.createEntityManager();
	}

	@After
	public void tearDown() {
		this.manager.close();
	}
	
	@Test
	public void exemploCarroAcessorio() {
		Carro carro = new Carro();
		carro.setPlaca("BQD-8887");
		carro.setCor("Azul");
		
		List<Acessorio> acessorios = new ArrayList<>();
		Acessorio acessorio1 = new Acessorio();
		acessorio1.setDescricao("Tapete");
		
		Acessorio acessorio2 = new Acessorio();
		acessorio2.setDescricao("Antena externa");
		
		Acessorio acessorio3 = new Acessorio();
		acessorio3.setDescricao("Porta Copos");

		acessorios.add(acessorio1);
		acessorios.add(acessorio2);
		acessorios.add(acessorio3);
		
		carro.setAcessorios(acessorios);
		
		this.manager.getTransaction().begin();
		this.manager.persist(carro);
		this.manager.getTransaction().commit();
	}
}
