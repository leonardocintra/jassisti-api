package com.leaolabs.jassisti.repository;

import com.leaolabs.jassisti.model.Filme;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}