package com.sort.repository;

/**@author Alderian**/

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sort.model.Tarefa;

@Repository("tarefaRepository")
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
	/*
	 * SELECT t.*, (tar_data_fim_tarefa - tar_data_inicio_tarefa) as "tempo" FROM
	 * tb_Tarefa t Where DATE_PART('MONTH', tar_data_fim_tarefa) =
	 * DATE_PART('MONTH', CURRENT_TIMESTAMP)
	 */

	// @Query("SELECT t FROM Tarefa t Where DATE_PART('MONTH', fimTeste) =
	// DATE_PART('MONTH', CURRENT_TIMESTAMP)")
	@Query("SELECT t FROM Tarefa t Where DATE_PART('MONTH', fimTeste) = DATE_PART('MONTH', CURRENT_TIMESTAMP)")
	public List<Tarefa> tarefaByFimTeste();

	@Query("SELECT t FROM Tarefa t Where usuario.id = ?1")
	public List<Tarefa> tarefaByUsuario(Long id);

	@Query("SELECT age(fimTeste , inicioTeste) as tempo FROM Tarefa where id=?1")
	public List<Object> tarefaByTempo(Long id);

}
