package com.cdeworks.vendas.api.services;

import com.cdeworks.vendas.api.domain.entities.Pedido;

public interface PedidoService {

	Pedido buscarPorId(Long id);
}
