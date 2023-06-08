package com.casolimpo.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casolimpo.api.models.Municipio;
import com.casolimpo.api.models.Provincia;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Integer> {

    List<Municipio> findbyProvincia(Provincia provincia);
}
