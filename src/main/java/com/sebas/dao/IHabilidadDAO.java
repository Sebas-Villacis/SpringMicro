package com.sebas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sebas.model.Habilidad;

public interface IHabilidadDAO extends JpaRepository<Habilidad, Integer>{

	/*@Query("from habilidad h where h.persona.id = :idPersona")
	List<Habilidad> getHabilidadByPersonaId(@Param("idPersona") Integer id);*/
	
	@Query("select new com.sebas.model.Habilidad(h.id, h.nombre, h.experiencia) from habilidad h where h.persona.id = :idPersona")
	List<Habilidad> getHabilidadByPersonaId(@Param("idPersona") Integer id);

}
