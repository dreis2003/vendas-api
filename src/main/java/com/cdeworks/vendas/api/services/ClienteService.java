package com.cdeworks.vendas.api.services;

import com.cdeworks.vendas.api.domain.entities.Cliente;

public interface ClienteService {
	
	Cliente buscarPorId(Long id);

}
