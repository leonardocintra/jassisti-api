package com.leaolabs.jassisti.business;

import java.util.Optional;

import com.leaolabs.jassisti.model.Filme;

public interface FilmeBusiness {

	Optional<Filme> create(Filme filme);
}