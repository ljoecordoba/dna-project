package com.dna.controller;

import java.io.Serializable;
import java.util.Optional;

import com.dna.domain.DNA;
import com.dna.repository.DNAWriterRepository;
import com.dna.service.MutantDetectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DNADetectorController implements Serializable {



	Logger logger = LoggerFactory.getLogger(DNADetectorController.class.getName());
	@Autowired
	private DNAWriterRepository dnaWriterRepository;


	private final MutantDetectorService mutantDetectorService = new MutantDetectorService();


	@RequestMapping(path = "/mutant", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = "application/json")
	public ResponseEntity mutant( @RequestBody DNA DNA)  throws Exception{


		if(!mutantDetectorService.isValidDNA(DNA.getDna())){
			return ResponseEntity.status(403).body("Esa cadena no corresponde a un ADN valido");
		}

		if(mutantDetectorService.isMutant(DNA.getDna())){
			DNA.setMutante(true);
			try{
				dnaWriterRepository.insert(DNA);
			}
			catch (Exception e){
				logger.error("No se pudo insertar el documento en la base de datos: "  + e.getMessage());
			}
			return ResponseEntity.ok().body("El DNA ha sido verificado con exito");
		}
		else{
			try{
				dnaWriterRepository.insert(DNA);
			}
			catch (Exception e){
				logger.error("No se pudo insertar el documento en la base de datos: " + e.getMessage());
			}
			return ResponseEntity.status(403).body("El DNA no pertenece a un mutante");
		}

	}





	@RequestMapping(path = "/stats", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = "application/json")
	public ResponseEntity stats(
			@RequestBody DNA DNA)  throws Exception{



		if(mutantDetectorService.isMutant(DNA.getDna())){
			return ResponseEntity.ok().body("El DNA ha sido verificado con exito");
		}
		else{
			return ResponseEntity.status(403).body("El DNA no pertenece a un mutante");
		}

	}


}
