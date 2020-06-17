package com.algaworks.curso.jpa2.criteria;

import javax.persistence.CascadeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelo.Categoria;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;

public class ExemploCascata {

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
	public void exemploEntidadeTransiente() {
		Carro carro = new Carro();
		carro.setCor("Preto");
		carro.setPlaca("AAA-1111");

		ModeloCarro modelo = new ModeloCarro();
		modelo.setCategoria(Categoria.ESPORTIVO);
		modelo.setDescricao("Ferrari");
		carro.setModelo(modelo);

		this.manager.getTransaction().begin();
		this.manager.persist(carro);
		this.manager.getTransaction().commit();
	}

	@Test
	public void exclusaoEmCascata() {
		Carro carro = this.manager.find(Carro.class, 2L);

		// @OneToMany(mappedBy="carro", cascade = CascadeType.REMOVE) no atributo aluguel
		
		this.manager.getTransaction().begin();
		this.manager.remove(carro);
		this.manager.getTransaction().commit();
	}

	@Test
	public void exclusaoDeObjetosOrfaos() {
		Carro carro = this.manager.find(Carro.class, 2L);
		// @OneToMany(mappedBy="carro", cascade = CascadeType.PERSIST, orphanRemoval = true)
		this.manager.getTransaction().begin();
		
		carro.getAlugueis().remove(3);
		
		this.manager.getTransaction().commit();
	}

}
