package com.casolimpo.api.converters;

import org.springframework.stereotype.Component;

import com.casolimpo.api.dto.ProvinciaDto;
import com.casolimpo.api.models.Provincia;

@Component
public class ProvinciaConverter {

    public Provincia paraProvincia(ProvinciaDto provinciaDto) {
        Provincia provincia = new Provincia();
        provincia.setId(provinciaDto.getId());
        provincia.setNome(provinciaDto.getNome());
        return provincia;

    }

    public ProvinciaDto paraProvinciaDto(ProvinciaDto provinciaDto) {
        return ProvinciaDto
                .builder()
                .id(provinciaDto.getId())
                .nome(provinciaDto.getNome())
                .build();
    }

    public ProvinciaDto paraProvincia(Provincia provincia) {
        return ProvinciaDto
                .builder()
                .id(provincia.getId())
                .nome(provincia.getNome())
                .build();
    }
}
