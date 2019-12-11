package com.dna.repository;

import com.dna.domain.DNA;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DNAWriterRepository extends MongoRepository<DNA,String>{
}
