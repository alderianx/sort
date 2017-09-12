package com.sort.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.sort.model.UsuarioTipo;



@Repository("usuarioTipoRepository")
public interface UsuarioTipoRepository extends JpaRepository<UsuarioTipo, Integer> {
	UsuarioTipo findByNome(String nome);	

}
