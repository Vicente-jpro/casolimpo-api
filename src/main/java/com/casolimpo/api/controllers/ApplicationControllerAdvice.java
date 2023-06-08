package com.casolimpo.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.casolimpo.api.exceptions.ContactoException;
import com.casolimpo.api.exceptions.DadosInvalidoException;
import com.casolimpo.api.exceptions.EnderecoException;
import com.casolimpo.api.exceptions.MunicipioException;
import com.casolimpo.api.exceptions.ProvinciaException;
import com.casolimpo.api.utils.ApiErrors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

	private String mensagemErro;

	@ResponseBody
	@ExceptionHandler(DadosInvalidoException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors dadosInvalidoExceptionHandle(DadosInvalidoException ex) {
		this.mensagemErro = ex.getMessage();
		return new ApiErrors(mensagemErro);
	}

	@ResponseBody
	@ExceptionHandler(EnderecoException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors enderecoExceptionHandle2(EnderecoException ex) {
		this.mensagemErro = ex.getMessage();
		return new ApiErrors(mensagemErro);
	}

	@ResponseBody
	@ExceptionHandler(ContactoException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors contactoExceptionHandle2(ContactoException ex) {
		this.mensagemErro = ex.getMessage();
		return new ApiErrors(mensagemErro);
	}

	@ResponseBody
	@ExceptionHandler(MunicipioException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors municipioExceptionHandle(MunicipioException ex) {
		this.mensagemErro = ex.getMessage();
		return new ApiErrors(mensagemErro);
	}

	@ResponseBody
	@ExceptionHandler(ProvinciaException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors provinciaExceptionHandle(ProvinciaException ex) {
		this.mensagemErro = ex.getMessage();
		return new ApiErrors(mensagemErro);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors validateFieldsHandle(MethodArgumentNotValidException ex) {
		List<String> erros = ex.getBindingResult()
				.getAllErrors()
				.stream()
				.map(erro -> erro.getDefaultMessage()).collect(Collectors.toList());

		return new ApiErrors(erros);
	}
}
