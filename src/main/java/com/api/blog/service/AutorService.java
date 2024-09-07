package com.api.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.blog.model.Autor;
import com.api.blog.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private  AutorRepository autorRepository;
	
	public List<Autor>getAllAutor()
	{
		return (List<Autor>) autorRepository.findAll();
	}
	
	
	public  Autor crearAutor(Autor autor)
	{
		return autorRepository.save(autor);
	}
	
	public Autor updateAutor(Autor autor)
	{
		return autorRepository.save(autor);
	}
	
	public void deleteAutor(Long id)
	{
		autorRepository.deleteById(id);
	}
	
	public Optional<Autor> getById(Long id)
	{
	   return autorRepository.findById(id);
	}
}
