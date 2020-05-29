package com.sebas.service;

import java.util.List;

import com.sebas.model.Habilidad;

public interface IHabilidadService extends CRUD<Habilidad> {
	
	List<Habilidad> getHabilidadByPersonaId(Integer id);
}
