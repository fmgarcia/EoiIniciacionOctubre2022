package com.eoi.proyecto.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eoi.proyecto.entidades.Family;
import com.eoi.proyecto.servicios.FamilyService;

@CrossOrigin(origins= {"*"})  // Configurar el CORS para que podamos acceder desde cualquier aplicación.
@RestController
@RequestMapping("/familias")
public class FamilyController {
	
	@Autowired
	private FamilyService familyService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Family> findAll(){
		return familyService.findAll();
	}
	
	@GetMapping("/{id}")
	public Family findById(@PathVariable int id){
		return familyService.findById(id);
	}
	
	@PostMapping   // responde en la ruta http://localhost:8080/familias, pero de tipo POST y recibe los datos del empleado
	@ResponseStatus(HttpStatus.CREATED)
	public Family save(@RequestBody Family family) {
		return familyService.save(family);		
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		familyService.delete(id);
	}
	
	@PutMapping("/{id}")  // responde en la ruta para el empleado 1000 http://localhost:8080/empleados/1000 de tipo PUT
	@ResponseStatus(HttpStatus.CREATED)
	public Family update(@PathVariable int id, @RequestBody Family family) {
		return familyService.update(id, family);
	}
	
	
}
