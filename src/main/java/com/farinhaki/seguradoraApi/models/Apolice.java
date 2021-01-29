package com.farinhaki.seguradoraApi.models;

import java.time.LocalDate;
import java.time.Period;
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
	
	private boolean valida;
	
	private int vencimento;
	
	@Basic(optional = false)
	@Column(name="vigencia_inicio", columnDefinition = "DATE")
	private LocalDate vigenciaInicio;
	
	@Basic(optional = false)
	@Column(name="vigencia_fim", columnDefinition = "DATE")
	private LocalDate vigenciaFim;
	
	
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
	public LocalDate getVigenciaInicio() {
		return vigenciaInicio;
	}

	public void setVigenciaInicio(LocalDate vigenciaInicio) {
		this.vigenciaInicio = vigenciaInicio;
	}

	public LocalDate getVigenciaFim() {
		return vigenciaFim;
	}

	public void setVigenciaFim(LocalDate vigenciaFim) {
		this.vigenciaFim = vigenciaFim;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}
	
	
/***
 * Verifica se a apolice continua dentro do periodo de validade
 * @return
 */
	public boolean isValida() {
		LocalDate today = LocalDate.now();
		
		if (today.isAfter(vigenciaInicio) && today.isBefore(vigenciaFim))
			return true;
		else
			return false;
	}

	public void setValida(boolean valida) {
		this.valida = valida;
	}

	/***
	 * Verifica quanto tempo falta para o vencimento da apolice
	 * @return numero de dias para o vencimento da apolice
	 */
	public int getVencimento() {
		LocalDate today = LocalDate.now();
		
		if(isValida()) 
			 return  Period.between(today, vigenciaFim).getDays();
		else
			return 0;	
	}

	public void setVencimento(int vencimento) {
		this.vencimento = vencimento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Apolice [id=" + id + ", numero=" + numero + ", placa=" + placa + ", vigenciaInicio=" + vigenciaInicio
				+ ", vigenciaFim=" + vigenciaFim + ", valor=" + valor + "]";
	}

	
}
