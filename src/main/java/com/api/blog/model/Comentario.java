package com.api.blog.model;

import java.util.Objects;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String contenido;
	private int puntuacion;
	private String descripcion_puntuacion;
	
	@OneToOne
//	@JoinColumn(name="visitante_id")
	private Visitante visitante;
	
	@ManyToOne
	//@JoinColumn(name="blog_id")
	Blog blog;
	
	public Comentario() {
		
	}
	

	public Comentario(Long id, String contenido, int puntuacion, String descripcion_puntuacion, Visitante visitante,
			Blog blog) {
		super();
		this.id = id;
		this.contenido = contenido;
		this.puntuacion = puntuacion;
		this.descripcion_puntuacion = descripcion_puntuacion;
		this.visitante = visitante;
		this.blog = blog;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getDescripcion_puntuacion() {
		return descripcion_puntuacion;
	}

	public void setDescripcion_puntuacion(String descripcion_puntuacion) {
		this.descripcion_puntuacion = descripcion_puntuacion;
	}

	public Visitante getVisitante() {
		return visitante;
	}

	public void setAutor(Visitante visitante) {
		this.visitante = visitante;
	}

	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}	

	public Blog getBlog() {
		return blog;
	}


	public void setBlog(Blog blog) {
		this.blog = blog;
	}


	@Override
	public int hashCode() {
		return Objects.hash(blog, contenido, descripcion_puntuacion, id, puntuacion, visitante);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comentario other = (Comentario) obj;
		return Objects.equals(blog, other.blog) && Objects.equals(contenido, other.contenido)
				&& Objects.equals(descripcion_puntuacion, other.descripcion_puntuacion) && Objects.equals(id, other.id)
				&& puntuacion == other.puntuacion && Objects.equals(visitante, other.visitante);
	}
	
	
		
}
