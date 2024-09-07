package com.api.blog.model;

import java.util.Objects;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Visitante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String correo;
	private String pais_residencia;
	
	@OneToOne(mappedBy = "visitante")
	private  Comentario comentario;
	
	public Visitante() {
		
	}
	
	public Visitante(String nombre, String correo, String pais_residencia,Comentario comentario) {
		super();
		this.nombre			 = nombre;
		this.correo 		 = correo;
		this.pais_residencia = pais_residencia;
		this.comentario 	 = comentario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPais_residencia() {
		return pais_residencia;
	}

	public void setPais_residencia(String pais_residencia) {
		this.pais_residencia = pais_residencia;
	}

	public Comentario getComentario() {
		return comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comentario, correo, id, nombre, pais_residencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visitante other = (Visitante) obj;
		return Objects.equals(comentario, other.comentario) && Objects.equals(correo, other.correo)
				&& Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(pais_residencia, other.pais_residencia);
	}
	
	
	

}
