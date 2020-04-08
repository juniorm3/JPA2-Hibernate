package com.algaworks.curso.jpa2.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Fabricante {


	@Id
	@TableGenerator(name = "fabricante_generator", table = "GERADOR_CODIGO", pkColumnName = "ENTIDADE",
	valueColumnName = "ALOCACAO", allocationSize = 5)
	@GeneratedValue(generator = "fabricante_generator", strategy = GenerationType.TABLE)
	private Long codigo;
	
	private String nome;

	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
