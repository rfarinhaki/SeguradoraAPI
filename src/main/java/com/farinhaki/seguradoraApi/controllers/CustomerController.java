package com.farinhaki.seguradoraApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farinhaki.seguradoraApi.models.Cliente;
import com.farinhaki.seguradoraApi.repository.IClienteRepo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@Validated
@RequestMapping(value="/api")
@Api(value="Seguradora API REST")
@CrossOrigin(origins="*")
public class CustomerController {

	private static Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	IClienteRepo customerRepository;
	
	@GetMapping("/clientes")
	@ApiOperation(value="Consulta todos os clientes")
	public List<Cliente> getCustomers(){
		logger.info("GET ALL");
		return customerRepository.findAll();
	}
	
	@GetMapping("/cliente/{id}")
	@ApiOperation(value="Consulta cliente por id")
	public Cliente getSingleCustomer(@PathVariable(value="id") long id){
		return customerRepository.findById(id);
	}
	
	@GetMapping("/clientepornome/{name}")
	@ApiOperation(value="Consulta cliente por nome")
	public Cliente getSingleCustomer(@PathVariable(value="nome") String nome) {
		return customerRepository.findByNome(nome);
	}
	
	@GetMapping("clienteporcpf/{cpf}")
	@ApiOperation(value="Consulta cliente por CPF")
	public Cliente getClientePorCPF(@PathVariable(value="cpf") String cpf) {
		return customerRepository.findBycpf(cpf);
	}
	
	@PostMapping("/cliente")
	@ApiOperation(value="Insere Cliente")
	public Cliente insertCustomer(@Valid @RequestBody Cliente cliente) {
		//logger.info(cliente.toString());
		return customerRepository.save(cliente);
	}
	
	@DeleteMapping("/cliente")
	@ApiOperation(value="Deletar Cliente")
	public void deleteCustomer(@RequestBody Cliente cliente) {
		customerRepository.delete(cliente);
	}
	
	@PutMapping("/cliente")
	@ApiOperation(value="Atualiza Cliente")
	public Cliente updateCustomer(@RequestBody Cliente cliente) {
		return customerRepository.save(cliente);
	}
}
