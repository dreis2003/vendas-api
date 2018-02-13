package com.cdeworks.vendas.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdeworks.vendas.api.domain.entities.Categoria;
import com.cdeworks.vendas.api.repositories.CategoriaRepository;
import com.cdeworks.vendas.api.services.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	private static final Logger log = LoggerFactory.getLogger(CategoriaServiceImpl.class);
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Optional<Categoria> buscarPorId(Long id) {
		log.info("Buscando categoria pelo ID: {}", id);
		return Optional.ofNullable(this. categoriaRepository.findOne(id));
	}
	
}
