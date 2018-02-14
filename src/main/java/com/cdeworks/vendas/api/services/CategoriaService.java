package com.cdeworks.vendas.api.services;

import com.cdeworks.vendas.api.domain.entities.Categoria;

public interface CategoriaService {
	
	/**
	 * Busca uma categoria pelo id
	 * @param id
	 * @return Categoria
	 */
	Categoria buscarPorId(Long id);
	
	/**
	 * Insere uma nova Categoria
	 * @param categoria
	 * @return Categoria
	 */
	Categoria salvar(Categoria categoria);

}
