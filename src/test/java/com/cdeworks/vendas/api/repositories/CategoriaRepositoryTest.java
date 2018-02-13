package com.cdeworks.vendas.api.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.cdeworks.vendas.api.domain.entities.Categoria;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CategoriaRepositoryTest {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Before
	public void setUp() throws Exception {
		Categoria categoria = new Categoria(null,"Informática");
		this.categoriaRepository.save(categoria);
	}
	
	@After
	public final void tearDown() {
		this.categoriaRepository.deleteAll();
	}
	
	@Test
	public void testBuscarPorId() {
		Categoria categoria = this.categoriaRepository.findOne(1L);
		
		assertEquals("Informática", categoria.getNome());
	}

}
