package com.leaolabs.jassisti.v1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.leaolabs.jassisti.business.FilmeBusiness;
import com.leaolabs.jassisti.commons.controller.BaseController;
import com.leaolabs.jassisti.commons.controller.ResponseMeta;
import com.leaolabs.jassisti.commons.exception.EntityNotFoundException;
import com.leaolabs.jassisti.model.Filme;
import com.leaolabs.jassisti.v1.dtos.FilmeDto;
import com.leaolabs.jassisti.v1.mapper.FilmeMapper;

@RestController
@RequestMapping("/v1/jassisti/filmes")
public class FilmeController extends BaseController {

	@Value("${spring.datasource.url}")
	private static String applicationVersion;

	private final FilmeBusiness filmeBusiness;
	private final FilmeMapper filmeMapper;

	@Autowired
	public FilmeController(final FilmeBusiness filmeBusiness, final FilmeMapper filmeMapper) {
		super(Filme.class);
		this.filmeBusiness = filmeBusiness;
		this.filmeMapper = filmeMapper;
	}

	@GetMapping(value = "")
	@ResponseBody
	public ResponseEntity<ResponseMeta> getAll() {
		List<Filme> filmes = this.filmeBusiness.findAll();

		return super.buildResponse(HttpStatus.OK, Optional.of(this.filmeMapper.serialize(filmes)));
	}

	@GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ResponseMeta> getById(@PathVariable final Long id) {
		final Optional<Filme> filme = this.filmeBusiness.findById(id);
		
		return super.buildResponse(HttpStatus.OK, Optional.of(this.filmeMapper.serialize(filme
				.orElseThrow(() -> new EntityNotFoundException("Filme")))));
	}

	@ResponseBody
	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseMeta> post(@RequestBody final FilmeDto filmeDto) {
		Optional<Filme> optionalFilme = this.filmeBusiness.create(this.filmeMapper.deserialize(filmeDto));

		return super.buildResponse(HttpStatus.CREATED, Optional
				.of(this.filmeMapper.serialize(optionalFilme.orElseThrow(() -> new EntityNotFoundException("Filme")))));
	}
}