package com.casolimpo.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casolimpo.api.models.Contacto;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Integer> {

}
