package com.casolimpo.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casolimpo.api.exceptions.ProvinciaException;
import com.casolimpo.api.models.Provincia;
import com.casolimpo.api.repositories.ProvinciaRepository;

@Service
public class ProviciaService {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    public Provincia findbyId(Integer idProvincia) {
        return this.provinciaRepository
                .findById(idProvincia)
                .orElseThrow(() -> new ProvinciaException("Provincia não encontrada. "
                        + "ID invalido id:" + idProvincia));
    }
}
