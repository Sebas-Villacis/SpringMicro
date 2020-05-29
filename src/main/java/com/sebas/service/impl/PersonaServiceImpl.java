package com.sebas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebas.dao.IPersonaDAO;
import com.sebas.model.Persona;
import com.sebas.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService{

	@Autowired
	private IPersonaDAO dao;
	
	@Override
	public List<Persona> findAll() {
		return dao.findAll();
	}

	@Override
	public Persona create(Persona obj) {
		return dao.save(obj);
	}

	@Override
	public Persona find(Integer id) {
		return dao.findOne(id);
	}

	@Override
	public Persona update(Persona obj) {
		return dao.save(obj);
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
		
	}

	@Override
	public Integer getUserIdByEmail(String correo) throws Exception {
		Integer rpta = 0;
		rpta = dao.getUserIdByEmail(correo);
		rpta = rpta != null ? rpta : 0;
		return rpta;
	}

}
