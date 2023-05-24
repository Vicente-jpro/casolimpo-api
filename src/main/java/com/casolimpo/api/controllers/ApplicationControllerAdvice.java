package com.casolimpo.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.casolimpo.api.exceptions.ColaboradorException;
import com.casolimpo.api.exceptions.DadosInvalidoException;
import com.casolimpo.api.exceptions.FuncionarioException;
import com.casolimpo.api.exceptions.ProjectoNotFoundException;
import com.casolimpo.api.utils.ApiErrors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

	private String mensagemErro;

	@ResponseBody
	@ExceptionHandler(DadosInvalidoException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors dadosInvalidoExceptionHandle2(DadosInvalidoException ex) {
		this.mensagemErro = ex.getMessage();
		return new ApiErrors(mensagemErro);
	}

	@ResponseBody
	@ExceptionHandler(ColaboradorException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors colaboradorExceptionHandle(ColaboradorException ex) {
		this.mensagemErro = ex.getMessage();
		return new ApiErrors(mensagemErro);
	}

	@ResponseBody
	@ExceptionHandler(FuncionarioException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiErrors funcionarioExceptionHandle(FuncionarioException ex) {
		this.mensagemErro = ex.getMessage();
		return new ApiErrors(mensagemErro);
	}

	@ResponseBody
	@ExceptionHandler(ProjectoNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiErrors projectoNotFoundExceptionHandle(ProjectoNotFoundException ex) {
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
