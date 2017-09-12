package com.sort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sort.model.Usuario;



@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByLogin(String login);
	
}
