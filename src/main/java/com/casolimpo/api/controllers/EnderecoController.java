package com.casolimpo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.casolimpo.api.converters.EnderecoConverter;
import com.casolimpo.api.dto.EnderecoDto;
import com.casolimpo.api.models.Endereco;
import com.casolimpo.api.services.EnderecoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/enderecos")
@Api("API de enderecos.")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private EnderecoConverter enderecoConverter;

	@PostMapping
	@ApiOperation("Salvar endereco.")
	@ApiResponses({
			@ApiResponse(code = 201, message = "Endereco salvo com sucesso."),
			@ApiResponse(code = 404, message = "Erro ao salvar Endereco")
	})
	@ResponseStatus(HttpStatus.CREATED)
	public EnderecoDto salvar(@RequestBody EnderecoDto enderecoDto) {
		log.info("EnderecoController - Salvar endereco.");
		Endereco endereco = this.enderecoService.salvar(enderecoDto);
		EnderecoDto dto = this.enderecoConverter.paraEnderecoDto(endereco);
		return dto;
	}

	@GetMapping("/{id_endereco}")
	@ApiOperation("Buscar endereco com os seus projectos.")
	@ApiResponses({
			@ApiResponse(code = 302, message = "Endereco encontrados"),
			@ApiResponse(code = 204, message = "Endereco não encontrados.")
	})
	@ResponseStatus(HttpStatus.OK)
	public EnderecoDto buscarEndereco(
			@PathVariable("id_endereco") Integer idEndereco) {
		log.info("EnderecoController - Buscar endereco. id_endereco: " + idEndereco);
		Endereco endereco = this.enderecoService.findById(idEndereco);
		EnderecoDto dto = this.enderecoConverter.paraEnderecoDto(endereco);
		return dto;
	}

	@DeleteMapping("/{id_endereco}")
	@ApiOperation("Eliminar endereco.")
	@ApiResponse(code = 204, message = "Eliminado eliminados com sucesso.")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable("id_endereco") Integer idEndereco) {
		log.info("ColaboradorController - Eliminar endereco. idEndereco: " + idEndereco);
		this.enderecoService.eliminar(idEndereco);
	}

}
