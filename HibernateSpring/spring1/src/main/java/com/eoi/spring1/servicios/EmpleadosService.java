package com.eoi.spring1.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eoi.spring1.entidades.Empleados;
import com.eoi.spring1.repositorios.EmpleadosRepository;

@Service
public class EmpleadosService {
	
	@Autowired  // Spring nos "inyecta" el objeto (no lo creamos nosotros)
	private EmpleadosRepository empleadosRepository;

	public EmpleadosService(EmpleadosRepository empleadosRepository) {
		this.empleadosRepository = empleadosRepository;
	}
	
	public List<Empleados> findAll(){  // Servicio que me permite mostrar TODOS los elementos de la tabla
		return (List<Empleados>) empleadosRepository.findAll();
	}
	
	public Empleados findById(int id) {  // Servicio que me permite mostra el empleado que me pasen por parámetro
		return empleadosRepository.findById(id).orElse(null);
	}
	
	public Empleados save(Empleados empleado) {  // Servicio que inserta un empleado en la base de datos
		return empleadosRepository.save(empleado);
	}
	
	public void delete(int id) {
		empleadosRepository.deleteById(id);
	}
	
	public Empleados update(int id, Empleados empleado) {
		empleado.setNum(id);
		return empleadosRepository.save(empleado);		
	}

}
