package com.casolimpo.api.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.casolimpo.api.dto.EnderecoDto;
import com.casolimpo.api.models.Endereco;

@Component
public class EnderecoConverter {

    @Autowired
    private MunicipioConverter municipioConverter;

    public Endereco paraEndereco(EnderecoDto enderecoDto) {
        Endereco endereco = new Endereco();
        endereco.setId(enderecoDto.getId());
        endereco.setMorada(enderecoDto.getMorada());
        endereco.setMunicipio(municipioConverter.paraMunicipio(enderecoDto.getMunicipioDto()));
        return endereco;
    }

    public EnderecoDto paraEnderecoDto(Endereco endereco) {
        return EnderecoDto
                .builder()
                .id(endereco.getId())
                .morada(endereco.getMorada())
                .build();
    }
}
