package com.sort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sort.model.TarefaStatus;



@Repository("statusRepository")
public interface StatusRepository extends JpaRepository<TarefaStatus, Long> {
	
	TarefaStatus findByNome(String nome);

}
