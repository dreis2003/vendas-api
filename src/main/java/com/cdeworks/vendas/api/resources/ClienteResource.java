package com.cdeworks.vendas.api.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdeworks.vendas.api.domain.entities.Categoria;
import com.cdeworks.vendas.api.domain.entities.Cliente;
import com.cdeworks.vendas.api.resources.response.Response;
import com.cdeworks.vendas.api.services.ClienteService;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteResource {
	
	private static final Logger log = LoggerFactory.getLogger(ClienteResource.class);
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<Cliente>> find(@PathVariable Long id) {
		log.info("Buscando categoria por ID: {}", id);
		
		Response<Cliente> response = new Response<>();
		
		Cliente cliente = clienteService.buscarPorId(id);

		response.setData(cliente);
		
		return ResponseEntity.ok(response);
	}

}
