package com.sort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sort.model.Fluxo;


@Repository("fluxoRepository")
public interface FluxoRepository extends JpaRepository<Fluxo, Long> {
	Fluxo findByNome(String nome);
}
