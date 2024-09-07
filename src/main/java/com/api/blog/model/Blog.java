package com.api.blog.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Blog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String tema;
	private String contenido;
	private String periocidad;
	private String comentario;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private  Date fechaPublicacion;
	private boolean estado;
	//	private Long id_autor;	
	@ManyToOne
	@JoinColumn(name="autor_id")
	Autor autor;	

	@OneToMany(mappedBy = "blog",cascade = CascadeType.ALL,fetch = FetchType.LAZY)	
	private List<Comentario>comentarios = new ArrayList<Comentario>();
	
	public Blog() {
		
	}

	public Blog(String titulo, String tema, String contenido, String periocidad, String comentario,Date fechaPublicacion, Autor autor,
			List<Comentario> comentarios) 
	{
		super();
		this.titulo 		  = titulo;
		this.tema = tema;
		this.contenido 		  = contenido;
		this.periocidad 	  = periocidad;
		this.comentario 	  = comentario;
		this.fechaPublicacion = fechaPublicacion;
		this.estado			  = true;
		this.autor 			  = autor;
		this.comentarios 	  = comentarios;
			}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getPeriocidad() {
		return periocidad;
	}

	public void setPeriocidad(String periocidad) {
		this.periocidad = periocidad;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autor, comentario, comentarios, contenido, fechaPublicacion, id, periocidad, tema, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Blog other = (Blog) obj;
		return Objects.equals(autor, other.autor) && Objects.equals(comentario, other.comentario)
				&& Objects.equals(comentarios, other.comentarios) && Objects.equals(contenido, other.contenido)
				&& Objects.equals(fechaPublicacion, other.fechaPublicacion) && Objects.equals(id, other.id)
				&& Objects.equals(periocidad, other.periocidad) && Objects.equals(tema, other.tema)
				&& Objects.equals(titulo, other.titulo);
	}

	public boolean isEstado() 
	{
		return estado;
	}

	public void setEstado(boolean estado) 
	{
		this.estado = estado;
	}
	
	
	
}
