package com.casolimpo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casolimpo.api.exceptions.MunicipioException;
import com.casolimpo.api.models.Municipio;
import com.casolimpo.api.models.Provincia;
import com.casolimpo.api.repositories.MunicipioRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class MunicipioService {

    @Autowired
    private MunicipioRepository municipioRepository;

    @Autowired
    private ProvinciaService provinciaService;

    public Municipio findbyId(Integer idMunicipio) {
        log.info("Buscando municipio com id: " + idMunicipio);

        return this.municipioRepository
                .findById(idMunicipio)
                .orElseThrow(() -> new MunicipioException("Municipio não encontrada. "
                        + "ID invalido id: " + idMunicipio));
    }

    public List<Municipio> findbyProvincia(Integer idProvincia) {
        log.info("Buscando municipos por provincia com id: " + idProvincia);
        Provincia provincia = this.provinciaService.findbyId(idProvincia);
        return this.municipioRepository.findbyProvincia(provincia);
    }
}
