package com.api.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.blog.model.Autor;
import com.api.blog.model.Blog;
import com.api.blog.model.Comentario;
import com.api.blog.repository.ComentarioRepository;

@Service
public class ComentarioService {
	
	@Autowired
	private ComentarioRepository comentarioRepository;

	public List<Comentario>getAllComentario(){
		return (List<Comentario>) comentarioRepository.findAll();
	}
	
	
	public  Comentario crearComentario(Comentario comentario) {
		return comentarioRepository.save(comentario);
	}
	
	public Comentario updateComentario(Comentario comentario) {
		return comentarioRepository.save(comentario);
	}
	
	public void deleteComentario(Long id) {
		comentarioRepository.deleteById(id);
	}
	public Optional<Comentario> getById(Long id)
	{
	   return comentarioRepository.findById(id);
	}
}
