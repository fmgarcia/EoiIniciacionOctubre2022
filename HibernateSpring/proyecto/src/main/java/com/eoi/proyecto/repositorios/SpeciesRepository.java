package com.eoi.proyecto.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eoi.proyecto.entidades.Species;

@Repository
public interface SpeciesRepository extends CrudRepository<Species,Integer> {

}
