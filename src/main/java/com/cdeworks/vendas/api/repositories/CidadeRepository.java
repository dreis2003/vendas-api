package com.cdeworks.vendas.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdeworks.vendas.api.domain.entities.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
