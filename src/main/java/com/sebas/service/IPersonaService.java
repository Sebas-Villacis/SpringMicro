package com.sebas.service;

import com.sebas.model.Persona;

public interface IPersonaService extends CRUD<Persona> {
	
	Integer getUserIdByEmail(String correo) throws Exception;

}
