package com.cdeworks.vendas.api.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdeworks.vendas.api.domain.entities.Categoria;
import com.cdeworks.vendas.api.domain.entities.Cliente;
import com.cdeworks.vendas.api.exceptions.CDEWorksNotFoundException;
import com.cdeworks.vendas.api.repositories.ClienteRepository;
import com.cdeworks.vendas.api.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Cliente buscarPorId(Long id) {
		log.info("Buscando cliente pelo ID: {}", id);
		Cliente cliente = this. clienteRepository.findOne(id);
		if (cliente == null) {
			log.warn("Cliente nao encontrado com o ID: {}, Tipo: " + Cliente.class.getName(), id);
			throw new CDEWorksNotFoundException("Cliente nao encontrada com o ID: " + id
												+ ", Tipo: " + Cliente.class.getName());
		}
		return cliente;
	}

}
