package com.cdeworks.vendas.api.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdeworks.vendas.api.domain.entities.Categoria;

@RestController
@RequestMapping(value = "/api/categorias")
public class CategoriaResource {
	
	
	@GetMapping
	public List<Categoria> listar() {
		Categoria cat1 = new Categoria(1L, "Informática");
		Categoria cat2 = new Categoria(2L, "Escritorio");
		
		List<Categoria> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);
		return lista;
	}

}
