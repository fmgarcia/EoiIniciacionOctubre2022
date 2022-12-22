package com.eoi.spring1.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eoi.spring1.entidades.Empleados;
import com.eoi.spring1.servicios.EmpleadosService;

@CrossOrigin(origins= {"*"})  // Configurar el CORS para que podamos acceder desde cualquier aplicación.
@RestController
@RequestMapping("/empleados")
public class EmpleadosController {
	
	@Autowired
	private EmpleadosService empleadosService;
	
	@GetMapping()  // responde en la ruta http://localhost:8080/empleados de tipo GET
	public List<Empleados> listar(){
		return empleadosService.findAll();
	}
	
	@GetMapping("/{id}")  // responde en la ruta para el empleado 1000 http://localhost:8080/empleados/1000
	public Empleados findById(@PathVariable int id){
		return empleadosService.findById(id);
	}
	
	@PostMapping   // responde en la ruta http://localhost:8080/empleados, pero de tipo POST y recibe los datos del empleado
	public Empleados save(@RequestBody Empleados empleado) {
		return empleadosService.save(empleado);		
	}
	
	@DeleteMapping("/{id}")  // responde en la ruta para el empleado 20000 http://localhost:8080/empleados/20000 de tipo DELETE
	public void delete(@PathVariable int id) {
		empleadosService.delete(id);
	}
	
	@PutMapping("/{id}")  // responde en la ruta para el empleado 1000 http://localhost:8080/empleados/1000 de tipo PUT
	public Empleados update(@PathVariable int id, @RequestBody Empleados empleado) {
		return empleadosService.update(id, empleado);
	}

}
