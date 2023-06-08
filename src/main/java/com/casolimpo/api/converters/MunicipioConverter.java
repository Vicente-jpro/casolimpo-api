package com.casolimpo.api.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.casolimpo.api.dto.MunicipioDto;
import com.casolimpo.api.models.Municipio;

@Component
public class MunicipioConverter {

    @Autowired
    private ProvinciaConverter provinciaConverter;

    public Municipio paraMunicipio(MunicipioDto municipioDto) {
        Municipio municipio = new Municipio();
        municipio.setId(municipioDto.getId());
        municipio.setNome(municipioDto.getNome());
        municipio.setProvincia(provinciaConverter.paraProvincia(municipioDto.getProvincia()));

        return municipio;
    }

    public MunicipioDto paraMunicipiu(Municipio municipio) {
        return MunicipioDto
                .builder()
                .build();
    }

}
