package com.sebas.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebas.model.Persona;
import com.sebas.service.IPersonaService;
import com.sebas.util.PersonaCorreo;

@RestController
@RequestMapping("/persona")
public class PersonaAPI {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IPersonaService service;
	
	@GetMapping(value = "/leer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	//@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Persona> leer(@PathVariable("id") Integer id){
		logger.info("Entro a leer [PersonaAPI]");
		
		Persona per = new Persona();
		try {
			per = service.find(id);
					
			if(per == null) {
				per = new Persona();
			}
		}catch(Exception e) {
			logger.error("Error -> ", e);
			return new ResponseEntity<Persona>(per, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("Salio a leer [PersonaAPI]");
		return new ResponseEntity<Persona>(per, HttpStatus.OK);
	}
	
	@PostMapping(value = "/leerCorreo", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Integer> getPersonaId(@RequestBody PersonaCorreo personaCorreo) {
		logger.info("Entro a leerCorreo [PersonaAPI]");
		
		Integer id = 0;
		try {
			id = service.getUserIdByEmail(personaCorreo.getCorreo());
		}catch(Exception e) {
			logger.error("Error -> ", e);
			return new ResponseEntity<Integer>(id, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("Salio a leerCorreo [PersonaAPI]");
		return new ResponseEntity<Integer>(id, HttpStatus.OK);
	}
}
