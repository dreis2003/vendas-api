package com.cdeworks.vendas.api.domain.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.cdeworks.vendas.api.domain.types.EstadoPagamento;

@Entity
@Table(name = "pagamento_cartao")
public class PagamentoCartao extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDeParcelas;

	public PagamentoCartao() {
	}
	public PagamentoCartao(Long id, EstadoPagamento estado, 
						   Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}
	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}
	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
