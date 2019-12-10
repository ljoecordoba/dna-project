package com.dna.repository;

import com.dna.domain.DNAChain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface DNAWriterRepository extends MongoRepository<DNAChain,String>{
}
