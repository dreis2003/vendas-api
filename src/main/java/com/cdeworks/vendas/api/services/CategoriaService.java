package com.cdeworks.vendas.api.services;

import java.util.Optional;

import com.cdeworks.vendas.api.domain.entities.Categoria;

public interface CategoriaService {
	
	Optional<Categoria> buscarPorId(Long id);

}
