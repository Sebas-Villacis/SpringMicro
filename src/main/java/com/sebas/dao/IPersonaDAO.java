package com.sebas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sebas.model.Persona;

public interface IPersonaDAO extends JpaRepository<Persona, Integer>{

	@Query("select p.id from persona p where p.correo = :correo")
	Integer getUserIdByEmail(@Param("correo") String correo) throws Exception;
}
