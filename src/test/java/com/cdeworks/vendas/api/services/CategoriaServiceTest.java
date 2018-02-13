package com.cdeworks.vendas.api.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.cdeworks.vendas.api.domain.entities.Categoria;
import com.cdeworks.vendas.api.repositories.CategoriaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CategoriaServiceTest {

	@MockBean
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	private static final Long ID = 1L;
	
	@Before
	public void setUp() throws Exception {
		BDDMockito.given(this.categoriaRepository.findOne(Mockito.anyLong())).willReturn(new Categoria());
		BDDMockito.given(this.categoriaRepository.save(Mockito.any(Categoria.class))).willReturn(new Categoria());
	}
	
	@Test
	public void testBuscarPorId() {
		Categoria categoria = this.categoriaService.buscarPorId(ID);
		
		assertNotNull(categoria);
	}
	
}
