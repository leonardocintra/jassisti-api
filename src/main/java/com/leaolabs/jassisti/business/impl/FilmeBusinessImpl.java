package com.leaolabs.jassisti.business.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leaolabs.jassisti.business.FilmeBusiness;
import com.leaolabs.jassisti.commons.exception.EntityNotFoundException;
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
	public Optional<Filme> create(final Filme filme) {
		return Optional.of(this.filmeRepository.save(filme));
	}

	@Override
	public List<Filme> findAll() {
		return this.filmeRepository.findAll();
	}

	@Override
	public Optional<Filme> findById(final Long id) {
		return this.filmeRepository.findById(id);
	}
}