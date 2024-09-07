package com.api.blog.model;
//https://app.creately.com/d/kDI4vcASS0m/edit
// https://github.com/Jose-Santillano/hotel-api-spring/tree/main/src
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springdoc.api.ErrorMessage;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private  Date fechaNacimiento;
	
	private String paisResidencia;
	private String correoElectronico;
	
	@OneToMany(mappedBy = "autor",cascade = CascadeType.ALL,fetch = FetchType.LAZY)	
	private List<Blog>blogs = new ArrayList<Blog>();
	
	public Autor() {
		
	}	

	public Autor(String nombres, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento,
			String paisResidencia, String correoElectronico, List<Blog> blogs) {
		super();
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.fechaNacimiento = fechaNacimiento;
		this.paisResidencia = paisResidencia;
		this.correoElectronico = correoElectronico;
		this.blogs = blogs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getPaisResidencia() {
		return paisResidencia;
	}

	public void setPaisResidencia(String paisResidencia) {
		this.paisResidencia = paisResidencia;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidoMaterno, apellidoPaterno, blogs, correoElectronico, fechaNacimiento, id, nombres,
				paisResidencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return Objects.equals(apellidoMaterno, other.apellidoMaterno)
				&& Objects.equals(apellidoPaterno, other.apellidoPaterno) && Objects.equals(blogs, other.blogs)
				&& Objects.equals(correoElectronico, other.correoElectronico)
				&& Objects.equals(fechaNacimiento, other.fechaNacimiento) && Objects.equals(id, other.id)
				&& Objects.equals(nombres, other.nombres) && Objects.equals(paisResidencia, other.paisResidencia);
	}	

}
