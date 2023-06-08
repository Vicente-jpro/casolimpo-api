package com.casolimpo.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casolimpo.api.models.Provincia;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Integer> {

}
