package com.sort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sort.model.Modulo;




@Repository("moduloRepository")
public interface ModuloRepository extends JpaRepository<Modulo, Long> {
	Modulo findByNome(String nome);
}
