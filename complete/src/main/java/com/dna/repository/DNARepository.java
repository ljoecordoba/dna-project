package com.dna.repository;

import com.dna.domain.DNAChain;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DNARepository extends MongoRepository<DNAChain, String>{
}
