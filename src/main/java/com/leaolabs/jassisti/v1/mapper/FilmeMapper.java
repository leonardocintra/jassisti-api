package com.leaolabs.jassisti.v1.mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.leaolabs.jassisti.model.Filme;
import com.leaolabs.jassisti.v1.dtos.FilmeDto;

@Component
public class FilmeMapper {

	public FilmeDto serialize(final Filme filme) {
		if (Optional.ofNullable(filme).isEmpty()) {
			return new FilmeDto();
		}

		return FilmeDto.builder().id(filme.getId()).titulo(filme.getTitulo()).movieTmdId(filme.getMovieTmdId())
				.dataLancamento(filme.getDataLancamento()).sinopse(filme.getSinopse())
				.imagemPoster(filme.getImagemPoster()).build();
	}

	public List<FilmeDto> serialize(final List<Filme> filmes) {
		return Optional.ofNullable(filmes)
				.map(filmeList -> filmes.stream().map(this::serialize).collect(Collectors.toList())).orElse(null);
	}

	public Filme deserialize(final FilmeDto filmeDto) {
		if (Optional.ofNullable(filmeDto).isEmpty()) {
			return new Filme();
		}

		return Filme.builder().id(filmeDto.getId()).titulo(filmeDto.getTitulo()).movieTmdId(filmeDto.getMovieTmdId())
				.dataLancamento(filmeDto.getDataLancamento()).sinopse(filmeDto.getSinopse())
				.imagemPoster(filmeDto.getImagemPoster()).build();
	}

	public List<Filme> deserialize(final List<FilmeDto> filmesDto) {
		return Optional.ofNullable(filmesDto)
				.map(filme -> filme.stream().map(this::deserialize).collect(Collectors.toList())).orElse(null);
	}

}