package com.cdeworks.vendas.api.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdeworks.vendas.api.domain.entities.Pedido;
import com.cdeworks.vendas.api.resources.response.Response;
import com.cdeworks.vendas.api.services.PedidoService;

@RestController
@RequestMapping(value = "/api/pedidos")
public class PedidoResource {
	
	private static final Logger log = LoggerFactory.getLogger(PedidoResource.class);
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<Pedido>> find(@PathVariable Long id) {
		log.info("Buscando pedido por ID: {}", id);
		
		Response<Pedido> response = new Response<>();
		
		Pedido pedido = pedidoService.buscarPorId(id);

		response.setData(pedido);
		
		return ResponseEntity.ok(response);
	}

}
