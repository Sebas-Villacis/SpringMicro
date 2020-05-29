package com.sebas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebas.dao.IHabilidadDAO;
import com.sebas.model.Habilidad;
import com.sebas.service.IHabilidadService;

@Service
public class HabilidadServiceImpl implements IHabilidadService{

	@Autowired
	private IHabilidadDAO dao;
	
	@Override
	public List<Habilidad> findAll() {		
		return dao.findAll();
	}

	@Override
	public Habilidad create(Habilidad obj) {
		return dao.save(obj);
	}

	@Override
	public Habilidad find(Integer id) {		
		return dao.findOne(id);
	}

	@Override
	public Habilidad update(Habilidad obj) {
		return dao.save(obj);
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public List<Habilidad> getHabilidadByPersonaId(Integer id) {		
		return dao.getHabilidadByPersonaId(id);
	}

}
