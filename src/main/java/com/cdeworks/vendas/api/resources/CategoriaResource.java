package com.cdeworks.vendas.api.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/categorias")
public class CategoriaResource {
	
	
	@GetMapping
	public String listar() {
		return "REST está Funcionando!!!";
	}

}
