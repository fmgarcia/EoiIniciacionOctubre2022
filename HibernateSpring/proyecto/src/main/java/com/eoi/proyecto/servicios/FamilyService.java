package com.eoi.proyecto.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eoi.proyecto.entidades.Family;
import com.eoi.proyecto.repositorios.FamilyRepository;


@Service
public class FamilyService {
	
	@Autowired
	private FamilyRepository familyRepository;

	public FamilyService(FamilyRepository familyRepository) {
		super();
		this.familyRepository = familyRepository;
	}
	
	public List<Family> findAll(){
		return (List<Family>) familyRepository.findAll();
	}
	
	public Family findById(int id) {
		return familyRepository.findById(id).orElse(null);
	}
	
	public Family save(Family family) {
		return familyRepository.save(family);
	}
	
	public void delete(int id) {
		familyRepository.deleteById(id);
	}
	
	public Family update(int id, Family family) {
		family.setId(id);
		return familyRepository.save(family);		
	}

}
