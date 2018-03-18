package com.algaworks.missao.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Missao {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	@NotNull(message = "Date de vencimento é obrigatória")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date data;
	private String hora;
	private int qtdeMilitares;
	private String veiculo;
	private String intinerario;
	
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
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public int getQtdeMilitares() {
		return qtdeMilitares;
	}
	public void setQtdeMilitares(int qtdeMilitares) {
		this.qtdeMilitares = qtdeMilitares;
	}
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	public String getIntinerario() {
		return intinerario;
	}
	public void setIntinerario(String intinerario) {
		this.intinerario = intinerario;
	}
		
}
