package com.eoi.proyecto.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eoi.proyecto.entidades.Family;

@Repository
public interface FamilyRepository extends CrudRepository<Family,Integer> {

}
