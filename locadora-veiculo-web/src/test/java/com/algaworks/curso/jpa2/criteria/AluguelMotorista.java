package com.algaworks.curso.jpa2.criteria;

public class AluguelMotorista {

	private String nomeMotorista;
	private Integer totalAlguel;

	public AluguelMotorista(String nomeMotorista, Integer totalAlguel) {
		this.nomeMotorista = nomeMotorista;
		this.totalAlguel = totalAlguel;
	}

	public String getNomeMotorista() {
		return nomeMotorista;
	}

	public void setNomeMotorista(String nomeMotorista) {
		this.nomeMotorista = nomeMotorista;
	}

	public Integer getTotalAlguel() {
		return totalAlguel;
	}

	public void setTotalAlguel(Integer totalAlguel) {
		this.totalAlguel = totalAlguel;
	}

}
