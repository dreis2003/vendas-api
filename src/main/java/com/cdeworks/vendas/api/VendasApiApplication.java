package com.cdeworks.vendas.api;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cdeworks.vendas.api.domain.entities.Categoria;
import com.cdeworks.vendas.api.domain.entities.Cidade;
import com.cdeworks.vendas.api.domain.entities.Cliente;
import com.cdeworks.vendas.api.domain.entities.Endereco;
import com.cdeworks.vendas.api.domain.entities.Estado;
import com.cdeworks.vendas.api.domain.entities.ItemPedido;
import com.cdeworks.vendas.api.domain.entities.Pagamento;
import com.cdeworks.vendas.api.domain.entities.PagamentoBoleto;
import com.cdeworks.vendas.api.domain.entities.PagamentoCartao;
import com.cdeworks.vendas.api.domain.entities.Pedido;
import com.cdeworks.vendas.api.domain.entities.Produto;
import com.cdeworks.vendas.api.domain.types.EstadoPagamento;
import com.cdeworks.vendas.api.domain.types.TipoCliente;
import com.cdeworks.vendas.api.repositories.CategoriaRepository;
import com.cdeworks.vendas.api.repositories.CidadeRepository;
import com.cdeworks.vendas.api.repositories.ClienteRepository;
import com.cdeworks.vendas.api.repositories.EnderecoRepository;
import com.cdeworks.vendas.api.repositories.EstadoRepository;
import com.cdeworks.vendas.api.repositories.ItemPedidoRepository;
import com.cdeworks.vendas.api.repositories.PagamentoRepository;
import com.cdeworks.vendas.api.repositories.PedidoRepository;
import com.cdeworks.vendas.api.repositories.ProdutoRepository;

@SpringBootApplication
public class VendasApiApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired 
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
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
		
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade cid1 = new Cidade(null, "Uberlandia", est1);
		Cidade cid2 = new Cidade(null, "São Paulo", est2);
		Cidade cid3 = new Cidade(null, "Campinas", est2);
		Cidade cid4 = new Cidade(null, "Guarulhos", est2);
		
		est1.getCidades().add(cid1);
		est2.getCidades().addAll(Arrays.asList(cid2, cid3, cid4));
		
		estadoRepository.save(Arrays.asList(est1, est2));
		cidadeRepository.save(Arrays.asList(cid1, cid2, cid3, cid4)); 
		
		Cliente cli = new Cliente(null,"Cristiana Cruz", "cris7677@gmail.com", "26310396889", TipoCliente.PF);
		cli.getTelefones().addAll(Arrays.asList("11976906262", "1124528151"));
		
		Endereco e1 = new Endereco(null, "Av. da Paz", "209", "Bloco 4 apto 124", "Vl São Judas Tadeu", "07061032", cli, cid4);
		Endereco e2 = new Endereco(null, "Rua Octavio Nunes da Silva", "164", "", "Vl Sion", "07021001", cli, cid4);
		cli.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.save(cli);
		enderecoRepository.save(Arrays.asList(e1, e2)); 
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli, e2);
		
		Pagamento pagto1 = new PagamentoCartao(null, EstadoPagamento.QUITADO, 
					ped1, 6);
		
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoBoleto(null, EstadoPagamento.PENDENTE, 
					ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.save(Arrays.asList(ped1, ped2));
		pagamentoRepository.save(Arrays.asList(pagto1, pagto2));
		
		
		ItemPedido ip1 = new ItemPedido(ped1, prod1, BigDecimal.ZERO, 1, BigDecimal.valueOf(2000.00));
		ItemPedido ip2 = new ItemPedido(ped1, prod3, BigDecimal.ZERO, 2, BigDecimal.valueOf(80.00));
		ItemPedido ip3 = new ItemPedido(ped2, prod2, BigDecimal.valueOf(100.00), 1, BigDecimal.valueOf(800.00));
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().add(ip3);
		
		prod1.getItens().addAll(Arrays.asList(ip1));
		prod2.getItens().addAll(Arrays.asList(ip3));
		prod3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.save(Arrays.asList(ip1, ip2, ip3));
		
		
	}
}
