package com.cdeworks.vendas.api.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdeworks.vendas.api.domain.entities.Pedido;
import com.cdeworks.vendas.api.exceptions.CDEWorksNotFoundException;
import com.cdeworks.vendas.api.repositories.PedidoRepository;
import com.cdeworks.vendas.api.services.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{

	private static final Logger log = LoggerFactory.getLogger(PedidoServiceImpl.class);
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public Pedido buscarPorId(Long id) {
		log.info("Buscando pedido pelo ID: {}", id);
		Pedido pedido = this. pedidoRepository.findOne(id);
		if (pedido == null) {
			log.warn("Pedido nao encontrado com o ID: {}, Tipo: " + Pedido.class.getName(), id);
			throw new CDEWorksNotFoundException("Pedido nao encontrada com o ID: " + id
												+ ", Tipo: " + Pedido.class.getName());
		}
		return pedido;
	}

}
