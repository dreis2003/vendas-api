package com.cdeworks.vendas.api.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdeworks.vendas.api.domain.entities.Categoria;
import com.cdeworks.vendas.api.exceptions.CDEWorksNotFoundException;
import com.cdeworks.vendas.api.repositories.CategoriaRepository;
import com.cdeworks.vendas.api.services.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	private static final Logger log = LoggerFactory.getLogger(CategoriaServiceImpl.class);
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscarPorId(Long id) {
		log.info("Buscando categoria pelo ID: {}", id);
		Categoria categoria = this. categoriaRepository.findOne(id);
		if (categoria == null) {
			log.warn("Categoria nao encontrada com o ID: {}, Tipo: " + Categoria.class.getName(), id);
			throw new CDEWorksNotFoundException("Categoria nao encontrada com o ID: " + id
												+ ", Tipo: " + Categoria.class.getName());
		}
		return categoria;
	}

	@Override
	public Categoria salvar(Categoria categoria) {
		categoria.setId(null);
		return categoriaRepository.save(categoria);
	}
	
}
