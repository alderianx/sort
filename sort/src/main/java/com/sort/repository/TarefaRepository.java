package com.sort.repository;

/**@author Alderian**/

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sort.model.Tarefa;

@Repository("tarefaRepository")
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

	@Query("SELECT t FROM Tarefa t Where DATE_PART('MONTH', fimTeste) = DATE_PART('MONTH', CURRENT_TIMESTAMP)")
	public List<Tarefa> tarefaByFimTeste();

	@Query("SELECT t FROM Tarefa t Where usuario.id = ?1")
	public List<Tarefa> tarefaByUsuario(Long id);

	@Query("SELECT age(fimTeste , inicioTeste) as tempo FROM Tarefa where id=?1")
	public List<Object> tarefaByTempo(Long id);

	@Query("SELECT ta.usuario.nome, Count(ta.id) AS total FROM Tarefa ta GROUP BY ta.usuario.nome ORDER BY total DESC")
	public List<Object> quantidadeTarefasByUsuario();

	@Query("UPDATE Tarefa tar SET tar.status.id = :tarefa WHERE tar.id = :id ")
	public Tarefa alteraStatusTarefaById(Long id, Tarefa tarefa);

}
