package com.sort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sort.model.TarefaTipo;


@Repository("tarefaTipoRepository")
public interface TarefaTipoRepository extends JpaRepository<TarefaTipo, Long> {
	TarefaTipo findByNome(String nome);
}
