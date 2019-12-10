package com.dna.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "dna")
public class DNAChain implements Serializable {

    private String[] dna;
    private boolean mutante;

    public DNAChain(@JsonProperty(value = "dna", required = true) String[] dna) {
        this.dna = dna; mutante = false;
    }

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    public boolean isMutante() {
        return mutante;
    }

    public void setMutante(boolean mutante) {
        this.mutante = mutante;
    }
}
