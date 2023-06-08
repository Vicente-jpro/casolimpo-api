package com.casolimpo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        @ResponseStatus(HttpStatus.FOUND)
        public List<Endereco> getColaboradoresByProjectoIdProjecto(
                        @PathVariable("id_projecto") Integer idProjecto) {
                log.info("ColaboradorController - Buscar colaboradores com seu projecto. id_projecto: " + idProjecto);
                return this.colaboradorService.getColaboradoresByProjectoIdProjecto(idProjecto);
        }

        @GetMapping("/pesquisa")
        @ApiOperation("Buscar colaboradores pelo ano de admição.")
        @ApiResponses({
                        @ApiResponse(code = 302, message = "Colaboradoes encontrados"),
                        @ApiResponse(code = 204, message = "Colaboradores não encontrados.")
        })
        @ResponseStatus(HttpStatus.FOUND)
        public Page<ColaboradorDto> getColaboradoresByFuncionarioAnoAdimicao(
                        @RequestParam(value = "ano", defaultValue = "2023", required = false) Integer ano,
                        @PageableDefault(page = 0, size = 4, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
                log.info("ColaboradorController - Buscar colaboradores por ano: " + ano);

                List<Colaborador> listaColaboradores = this.colaboradorService
                                .getColaboradoresByFuncionarioAnoAdimicao(ano);
                List<ColaboradorDto> listaColaboradoresDto = this.colaboradorConverter
                                .paraColaboradorDto(listaColaboradores);
                Page<ColaboradorDto> listaPaginada = this.paginacaoColaborador
                                .getPaginacao(listaColaboradoresDto, pageable);
                return listaPaginada;

        }

        @DeleteMapping("/{id_projecto}")
        @ApiOperation("Eliminar colaboradores por projecto.")
        @ApiResponse(code = 204, message = "Colaboradores eliminados com sucesso.")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void eliminarColaboradoresByProjecto(@PathVariable("id_projecto") Integer idProjecto) {
                log.info("ColaboradorController - Eliminar colaboradores com seu projecto. id_projecto: " + idProjecto);
                this.colaboradorService.eliminarColaboradoresByProjecto(idProjecto);
        }

        @PatchMapping("/{id_colaborador}")
        @ApiOperation("Atualizar colaborador com seu projecto.")
        @ApiResponse(code = 201, message = "Colaboradores eliminados com sucesso.")
        @ResponseStatus(HttpStatus.CREATED)
        public List<ColaboradorDto> atualizar(@RequestBody ColaboradorDto colaboradorDto,
                        @PathVariable("id_colaborador") Integer idColaborador) {
                log.info("ColaboradorController - Atualizar colaborador com seu projecto. idColaborador: "
                                + idColaborador);
                return this.colaboradorService.atualizar(colaboradorDto, idColaborador);
        }

}
