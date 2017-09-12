package com.sort.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sort.model.Modulo;
import com.sort.repository.ModuloRepository;


@Service("moduloService")
public class ModuloServiceImpl implements ModuloService {

	@Autowired
	private ModuloRepository moduloRepository;

	@Override
	public Modulo findByNome(String nome) {	

		return moduloRepository.findByNome(nome);
	}

}
