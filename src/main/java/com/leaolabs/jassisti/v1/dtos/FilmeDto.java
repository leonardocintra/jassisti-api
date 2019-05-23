package com.leaolabs.jassisti.v1.dtos;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class FilmeDto implements Serializable {

	private static final long serialVersionUID = -1648130419885819386L;
	
	@NotBlank
	private Long id;

	@NotBlank
	private String titulo;
	
	@NotBlank
	private Long movieTmdId;
	
	@NotBlank
	private String sinopse;

	@NotBlank
	private String imagemPoster;
	
	@NotBlank
	private Date dataLancamento;
}