package com.sort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sort.model.Tarefa;

@Repository("tarefaRepository")
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
	
}
