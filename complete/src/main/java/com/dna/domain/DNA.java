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
public class DNA implements Serializable {
    @Id
    private int dnaId = 0;
    private String[] dna;
    private boolean mutante;

    public DNA(@JsonProperty(value = "dna", required = true) String[] dna) {
        String letters = "";
        for (String dnaString:
             dna) {
            letters = letters.concat(dnaString);
        }
        dnaId = letters.hashCode();

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

    public Integer getDnaId() {
        return dnaId;
    }

    public void setDnaId(Integer dnaId) {
        this.dnaId = dnaId;
    }
}
