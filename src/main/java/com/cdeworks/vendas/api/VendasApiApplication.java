package com.cdeworks.vendas.api;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cdeworks.vendas.api.domain.entities.Categoria;
import com.cdeworks.vendas.api.domain.entities.Produto;
import com.cdeworks.vendas.api.repositories.CategoriaRepository;
import com.cdeworks.vendas.api.repositories.ProdutoRepository;

@SpringBootApplication
public class VendasApiApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(VendasApiApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		Produto prod1 = new Produto(null, "Computador", BigDecimal.valueOf(2000.00));
		Produto prod2 = new Produto(null, "Impressora", BigDecimal.valueOf(800.00));
		Produto prod3 = new Produto(null, "Mouse", BigDecimal.valueOf(80.00));
		
		cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProdutos().addAll(Arrays.asList( prod2));
		
		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		prod3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.save(Arrays.asList(cat1, cat2));
		produtoRepository.save(Arrays.asList(prod1, prod2, prod3));
		
	}
}
