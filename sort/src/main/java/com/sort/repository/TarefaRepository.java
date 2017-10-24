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

	// select us.usu_nome as nome, count(ta.tar_id) as total from tb_usuario us
	// inner join tb_tarefa ta on (us.usu_id =ta.usu_id )
	// group by us.usu_nome order by total desc
//
//	@Query("SELECT ta.usuario.nome, count(ta.id) AS total FROM Tarefa ta INNER JOIN Usuario us ON"
//			+ " (us.id =: ta.id) GROUP BY ta.usuario.nome ORDER BY total DESC")
	
	@Query("SELECT ta.usuario.nome, Count(ta.id) AS total FROM Tarefa ta GROUP BY ta.usuario.nome ORDER  BY total DESC")
	public List<Object> quantidadeTarefasByUsuario();
	
}
