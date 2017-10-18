package com.sort.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sort.model.Tarefa;

@Repository("tarefaRepository")
public interface TarefaRepository extends JpaRepository<Tarefa, Long>, JpaSpecificationExecutor<Tarefa> {

	@Query("SELECT t FROM Tarefa t Where DATE_PART('MONTH', fimTeste) = DATE_PART('MONTH', CURRENT_TIMESTAMP)")
	public List<Tarefa> tarefaByFimTeste();

	@Query("SELECT t FROM Tarefa t Where usuario.id = ?1")
	public List<Tarefa> tarefaByUsuario(Long id);

	@Query(" SELECT (fimTeste - inicioTeste) as tempo FROM Tarefa t Where t.id = ?1")
	public Double tarefaByTempo(Long id);

}
