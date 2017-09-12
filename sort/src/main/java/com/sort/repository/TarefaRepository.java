package com.sort.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sort.model.Tarefa;

@Repository("tarefaRepository")
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
	
	
	@Query("SELECT t FROM Tarefa t Where DATE_PART('MONTH', fimTeste) = DATE_PART('MONTH', CURRENT_TIMESTAMP)")
	public List<Tarefa> tarefaByFimTeste();
	
}
