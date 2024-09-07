package com.api.blog.repository;

import org.springframework.data.repository.CrudRepository;

import com.api.blog.model.Comentario;

public interface ComentarioRepository extends CrudRepository<Comentario, Long>{

}
