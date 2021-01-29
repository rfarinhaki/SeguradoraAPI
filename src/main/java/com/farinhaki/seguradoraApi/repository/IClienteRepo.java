package com.farinhaki.seguradoraApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farinhaki.seguradoraApi.models.Cliente;

public interface IClienteRepo extends JpaRepository<Cliente, Long>{
	public Cliente findById(long id);
	
	public Cliente findByNome(String nome);
	
	public Cliente findBycpf(String cpf);
	
}

