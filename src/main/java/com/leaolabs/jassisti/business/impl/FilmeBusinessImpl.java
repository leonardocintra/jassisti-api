package com.leaolabs.jassisti.business.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leaolabs.jassisti.business.FilmeBusiness;
import com.leaolabs.jassisti.model.Filme;
import com.leaolabs.jassisti.repository.FilmeRepository;

@Service
public class FilmeBusinessImpl implements FilmeBusiness {

	private final FilmeRepository filmeRepository;

	@Autowired
	public FilmeBusinessImpl(final FilmeRepository filmeRepository) {
		this.filmeRepository = filmeRepository;
	}

	@Override
	public Optional<Filme> create(Filme filme) {
		return Optional.of(filmeRepository.save(filme));
	}

	@Override
	public List<Filme> findAll() {
		return filmeRepository.findAll();
	}
}