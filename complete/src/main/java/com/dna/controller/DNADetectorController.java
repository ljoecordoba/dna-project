package com.dna.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.dna.domain.DNAChain;
import com.dna.service.MutantDetectorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DNADetectorController {

	private final AtomicLong counter = new AtomicLong();
	private final MutantDetectorService mutantDetectorService = new MutantDetectorService();

	@RequestMapping(path = "/mutant", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = "application/json")
	public ResponseEntity mutant(
								   @RequestBody DNAChain dnaChain)  throws Exception{


		if(mutantDetectorService.isMutant(dnaChain.getDna())){
			return ResponseEntity.ok().body("El DNA ha sido verificado con exito");
		}
		else{
			return ResponseEntity.status(403).body("El DNA no pertenece a un mutante");
		}

	}


}
