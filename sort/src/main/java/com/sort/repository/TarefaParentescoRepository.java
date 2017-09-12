package com.sort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sort.model.TarefaParentesco;
@Repository("tarefaParentescoRepository")
public interface TarefaParentescoRepository extends JpaRepository<TarefaParentesco, Long> {

}
