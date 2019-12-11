package com.dna.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Stats {

    @JsonProperty("count_mutant_dna")
    private Long mutantCount = 0L;
    @JsonProperty("count_human_dna")
    private Long humanCount = 0L;
    private BigDecimal ratio;
    @JsonIgnore
    private Long total = 0L;

    /**
     * @return the mutantCount
     */
    public Long getMutantCount() {
        return mutantCount;
    }

    /**
     * @param mutantCount the mutantCount to set
     */
    public void setMutantCount(Long mutantCount) {
        this.mutantCount = mutantCount;
    }

    /**
     * @return the humanCount
     */
    public Long getHumanCount() {
        return humanCount;
    }

    /**
     * @param humanCount the humanCount to set
     */
    public void setHumanCount(Long humanCount) {
        this.humanCount = humanCount;
    }

    /**
     * @return the ratio
     */
    public BigDecimal getRatio() {
        return ratio;
    }

    /**
     * @param ratio the ratio to set
     */
    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }

    /**
     * @return the total
     */
    public Long getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Long total) {
        this.total = total;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "DNAStatus [mutantCount=" + mutantCount + ", humanCount=" + humanCount + ", ratio=" + ratio + ", total="
                + total + "]";
    }
}
