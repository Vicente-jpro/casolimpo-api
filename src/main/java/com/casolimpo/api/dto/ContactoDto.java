package com.casolimpo.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactoDto {
    private Integer id;
    private String telefone1;
    private String telefone2;
    private String email;
}
