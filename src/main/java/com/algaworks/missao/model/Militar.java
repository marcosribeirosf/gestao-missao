package com.algaworks.missao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Militar {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String nivel;
	@ManyToOne
	@JoinColumn(name = "id_missao")
	private Missao missao;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public Missao getMissao() {
		return missao;
	}
	public void setMissao(Missao missao) {
		this.missao = missao;
	}
	

}
