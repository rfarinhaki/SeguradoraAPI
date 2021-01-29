package com.farinhaki.seguradoraApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farinhaki.seguradoraApi.models.Apolice;


public interface IApoliceRepo extends JpaRepository<Apolice, Long>{
	public Apolice findById(long id);
	
	public Apolice findByNumero(int numero);
	
	public List<Apolice> findByPlaca(String placa);
	
	
}
