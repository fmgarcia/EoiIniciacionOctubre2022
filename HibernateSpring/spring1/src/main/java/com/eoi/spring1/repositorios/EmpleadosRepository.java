package com.eoi.spring1.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eoi.spring1.entidades.Empleados;

@Repository
public interface EmpleadosRepository extends CrudRepository<Empleados,Integer> {

}
