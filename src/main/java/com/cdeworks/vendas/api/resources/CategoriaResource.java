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
import com.cdeworks.vendas.api.resources.response.Response;
import com.cdeworks.vendas.api.services.CategoriaService;

@RestController
@RequestMapping(value = "/api/categorias")
public class CategoriaResource {
	
	private static final Logger log = LoggerFactory.getLogger(CategoriaResource.class);
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<Categoria>> find(@PathVariable Long id) {
		log.info("Buscando categoria por ID: {}", id);
		
		Response<Categoria> response = new Response<>();
		
		Categoria categoria = categoriaService.buscarPorId(id);

		response.setData(categoria);
		
		return ResponseEntity.ok(response);
	}

}
