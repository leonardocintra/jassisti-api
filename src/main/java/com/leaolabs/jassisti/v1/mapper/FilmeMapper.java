package com.leaolabs.jassisti.v1.mapper;

import java.util.Optional;

import com.leaolabs.jassisti.model.Filme;
import com.leaolabs.jassisti.v1.dtos.FilmeDto;

import org.springframework.stereotype.Component;

@Component
public class FilmeMapper {
	public FilmeDto serialize(final Filme filme) {
		if (Optional.ofNullable(filme).isEmpty()) {
			return new FilmeDto();
		}

		return FilmeDto.builder().titulo(filme.getTitulo()).movieTmdId(filme.getMovieTmdId())
				.dataLancamento(filme.getDataLancamento()).sinopse(filme.getSinopse())
				.imagemPoster(filme.getImagemPoster()).build();
	}

	public Filme deserialize(final FilmeDto filmeDto) {
		if (Optional.ofNullable(filmeDto).isEmpty()) {
			return new Filme();
		}

		return Filme.builder().titulo(filmeDto.getTitulo()).movieTmdId(filmeDto.getMovieTmdId())
				.dataLancamento(filmeDto.getDataLancamento()).sinopse(filmeDto.getSinopse())
				.imagemPoster(filmeDto.getImagemPoster()).build();
	}
}