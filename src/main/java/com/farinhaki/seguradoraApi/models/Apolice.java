package com.farinhaki.seguradoraApi.models;

import java.time.LocalDateTime;
import java.util.Random;

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

import org.springframework.validation.annotation.Validated;

@Entity
@Table(name="Apolice", uniqueConstraints= {@UniqueConstraint(columnNames= {"numero"})})
@Validated
public class Apolice {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private int id;
	
	@Column(name="numero")
	private int numero;
	
	@Column(name="placa")
	@Basic(optional=false)
	private String placa;
	
	@Basic(optional = false)
	@Column(name="vigencia_inicio", columnDefinition = "TIMESTAMP")
	private LocalDateTime vigenciaInicio;
	
	@Basic(optional = false)
	@Column(name="vigencia_fim", columnDefinition = "TIMESTAMP")
	private LocalDateTime vigenciaFim;
	
	@Basic(optional = false)
	@Column(name="valor")
	private Float valor;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
	private Cliente cliente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero() {
		Random rand  = new Random();
		this.numero = rand.nextInt(Integer.MAX_VALUE); 
	}

	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String p) {
		this.placa = p;
	}
	public LocalDateTime getVigenciaInicio() {
		return vigenciaInicio;
	}

	public void setVigenciaInicio(LocalDateTime vigenciaInicio) {
		this.vigenciaInicio = vigenciaInicio;
	}

	public LocalDateTime getVigenciaFim() {
		return vigenciaFim;
	}

	public void setVigenciaFim(LocalDateTime vigenciaFim) {
		this.vigenciaFim = vigenciaFim;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Apolice [id=" + id + ", numero=" + numero + ", placa=" + placa + ", vigenciaInicio=" + vigenciaInicio
				+ ", vigenciaFim=" + vigenciaFim + ", valor=" + valor + "]";
	}

	
}
