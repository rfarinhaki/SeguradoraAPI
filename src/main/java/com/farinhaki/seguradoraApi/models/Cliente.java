package com.farinhaki.seguradoraApi.models;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.validation.annotation.Validated;

@Entity
@Table(name="Cliente", uniqueConstraints= {@UniqueConstraint(columnNames= {"cpf"})})
@Validated
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotEmpty
	@Basic(optional = false)
	private String nome;
	
	
	@CPF //cpf validator from hibernate
	@Basic(optional = false)
    @Column(name="cpf")
	private String cpf;
	
	@Basic(optional = false)
	@Column(name="cidade")
	private String cidade;
	
	@Basic(optional = false)
	@Column(name="uf")
	private String uf;
	
	
	public long  getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", cidade=" + cidade + ", uf=" + uf
				+  "]";
	}
	


}
