package com.dna.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Stats {

    private BigInteger mutantCount = new BigInteger("0");
    private BigInteger totalCount = new BigInteger("0");
    private BigDecimal ratio = new BigDecimal("0.0");


    public BigInteger getMutantCount() {
        return mutantCount;
    }

    public void setMutantCount(BigInteger mutantCount) {
        this.mutantCount = mutantCount;
    }

    public BigInteger getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(BigInteger totalCount) {
        this.totalCount = totalCount;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }
}
