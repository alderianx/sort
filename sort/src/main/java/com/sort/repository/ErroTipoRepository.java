package com.sort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sort.model.ErroTipo;



@Repository("erroTipoRepository")
public interface ErroTipoRepository extends JpaRepository<ErroTipo, Long> {
	ErroTipo findByNome(String nome);
}
