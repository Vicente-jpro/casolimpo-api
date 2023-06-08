package com.casolimpo.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnderecoDto {
    private Integer id;
    private String morada;
    private MunicipioDto municipioDto;
}
