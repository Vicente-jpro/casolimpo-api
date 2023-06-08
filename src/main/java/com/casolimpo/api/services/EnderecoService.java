package com.casolimpo.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casolimpo.api.dto.EnderecoDto;
import com.casolimpo.api.models.Endereco;
import com.casolimpo.api.models.Municipio;
import com.casolimpo.api.models.Provincia;
import com.casolimpo.api.repositories.EnderecoRepository;
import com.casolimpo.api.repositories.MunicipioRepository;

@Service
public class EnderecoService {

    @Autowired
    private MunicipioService municipioService;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco salvar(EnderecoDto enderecoDto) {
        Municipio municipio = municipioService.findbyId(enderecoDto.getMunicipioDto().getId());
        Endereco endereco = new Endereco();
        endereco.setMorada(enderecoDto.getMorada());
        endereco.setMunicipio(municipio);

        return this.enderecoRepository.save(endereco);
    }
}
