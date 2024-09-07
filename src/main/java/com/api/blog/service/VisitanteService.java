package com.api.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.blog.model.Autor;
import com.api.blog.model.Blog;
import com.api.blog.model.Visitante;
import com.api.blog.repository.VisitanteRepository;

@Service
public class VisitanteService {

	@Autowired
	private VisitanteRepository visitanteRepository;
	
	public List<Visitante>getAllVisitante()
	{
		return (List<Visitante>) visitanteRepository.findAll();
	}	
	
	public  Visitante crearVisitante(Visitante visitante)
	{
		return visitanteRepository.save(visitante);
	}
	
	public Visitante updateVisitante(Visitante visitante)
	{
		return visitanteRepository.save(visitante);
	}
	
	public void deleteVisitante(Long id)
	{
		visitanteRepository.deleteById(id);
	}
	public Optional<Visitante> getById(Long id)
	{
	   return visitanteRepository.findById(id);
	}
}
