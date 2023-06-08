package com.casolimpo.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MunicipioDto {
    private Integer id;
    private String nome;
    private ProvinciaDto provincia;

}
