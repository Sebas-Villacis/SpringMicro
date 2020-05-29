package com.sebas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity(name = "habilidad")
@Table(name = "habilidad")
@JsonInclude(Include.NON_NULL)
public class Habilidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nombre", length = 50, nullable = false)
	private String nombre;

	// @JsonIgnore
	/*@JsonProperty("idPersona")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonIdentityReference(alwaysAsId = true)*/
	@ManyToOne
	@JoinColumn(name = "id_persona", nullable = false)
	private Persona persona;

	// A: Alto B: Bueno R: Regular
	@Column(name = "experiencia", length = 1, nullable = false)
	private String experiencia;	

	public Habilidad() {
		
	}
	
	public Habilidad(Integer id, String nombre, String experiencia) {		
		this.id = id;
		this.nombre = nombre;
		this.experiencia = experiencia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

}
