package com.casolimpo.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProvinciaDto {
    private Integer id;
    private String nome;
}
