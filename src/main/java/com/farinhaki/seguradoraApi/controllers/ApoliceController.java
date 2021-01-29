package com.farinhaki.seguradoraApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farinhaki.seguradoraApi.models.Apolice;
import com.farinhaki.seguradoraApi.repository.IApoliceRepo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Validated
@RequestMapping(value="/api")
@Api(value="Seguradora API REST")
public class ApoliceController {

	@Autowired
	IApoliceRepo apoliceRepository;

	@GetMapping("/apolices")
	@ApiOperation(value="Consulta todas as apolices")
	public List<Apolice> getApolices(){
		//logger.info("GET ALL");
		return apoliceRepository.findAll();
	}
	
	@GetMapping("/apolice/{numero}")
	@ApiOperation(value="Consulta apolice por numero")
	public Apolice getApolice(@PathVariable(value="numero") int numero) {
		return apoliceRepository.findByNumero(numero);
	}
	
	@GetMapping("/apolicesporplaca/{placa}")
	@ApiOperation(value="Consulta apolices relacionadas a uma placa")
	public List<Apolice> getApolicesPorPlaca(@PathVariable(value="placa") String placa){
		return apoliceRepository.findByPlaca(placa);
	}
	
	@PostMapping("/apolice")
	@ApiOperation(value="Insere Apolice")
	public @Valid Apolice insertCustomer(@Valid @RequestBody Apolice apolice) {
		return apoliceRepository.save(apolice);
	}
	
	@DeleteMapping("/apolice")
	@ApiOperation(value="Deletar Apolice")
	public void deleteCustomer(@RequestBody Apolice apolice) {
		apoliceRepository.delete(apolice);
	}
	
	@PutMapping("/apolice")
	@ApiOperation(value="Atualiza Apolice")
	public Apolice updateCustomer(@RequestBody Apolice apolice) {
		return apoliceRepository.save(apolice);
	}
	
}
