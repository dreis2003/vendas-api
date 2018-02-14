package com.cdeworks.vendas.api.domain.builders;

import com.cdeworks.vendas.api.domain.entities.Cidade;
import com.cdeworks.vendas.api.domain.entities.Cliente;
import com.cdeworks.vendas.api.domain.entities.Endereco;

public class EnderecoBuilder {
	
	private Long id;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private Cliente cliente;
	private Cidade cidade;

	public EnderecoBuilder setId(Long id) {
		this.id = id;
		return this;
	}
	
	public EnderecoBuilder setLogradouro(String logradouro) {
		this.logradouro = logradouro;
		return this;
	}
	public EnderecoBuilder setNumero(String numero) {
		this.numero = numero;
		return this;
	}
	
	public EnderecoBuilder setComplemento(String complemento) {
		this.complemento = complemento;
		return this;
	}
	
	public EnderecoBuilder setBairro(String bairro) {
		this.bairro = bairro;
		return this;
	}
	
	public EnderecoBuilder setCep(String cep) {
		this.cep = cep;
		return this;
	}
	
	public EnderecoBuilder setCliente(Cliente cliente) {
		this.cliente = cliente;
		return this;
	}
	
	public EnderecoBuilder setCidade(Cidade cidade) {
		this.cidade = cidade;
		return this;
	}
	
	public Endereco build() {
		Endereco novoEndereco= new Endereco();
		novoEndereco.setId(id);
		novoEndereco.setLogradouro(logradouro);
		novoEndereco.setNumero(numero);
		novoEndereco.setComplemento(complemento);
		novoEndereco.setBairro(bairro);
		novoEndereco.setCep(cep);
		novoEndereco.setCliente(cliente);
		novoEndereco.setCidade(cidade);
		return novoEndereco;
	}
	
}
