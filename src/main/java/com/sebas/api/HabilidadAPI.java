package com.sebas.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebas.model.Habilidad;
import com.sebas.service.IHabilidadService;

@RestController
@RequestMapping("/habilidad")
public class HabilidadAPI {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IHabilidadService service;

	@GetMapping(value = "/listar/{idPersona}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Habilidad>> getAll(@PathVariable("idPersona") Integer id) {
		logger.info("Entro getAll [Habilidad]");

		List<Habilidad> list = new ArrayList<Habilidad>();
		try {
			list = service.getHabilidadByPersonaId(id);
 
			if (list == null) {
				list = new ArrayList<Habilidad>();
			}
		} catch (Exception e) {
			logger.error("Error ->", e);
			return new ResponseEntity<List<Habilidad>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("Salio getAll [Habilidad]");
		return new ResponseEntity<List<Habilidad>>(list, HttpStatus.OK);
	}
}
