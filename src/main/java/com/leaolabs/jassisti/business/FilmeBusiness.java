package com.leaolabs.jassisti.business;

import java.util.List;
import java.util.Optional;

import com.leaolabs.jassisti.model.Filme;

public interface FilmeBusiness {

	List<Filme> findAll();

	Optional<Filme> create(Filme filme);

}