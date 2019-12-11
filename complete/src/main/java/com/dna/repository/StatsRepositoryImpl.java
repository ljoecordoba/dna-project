package com.dna.repository;

import com.dna.domain.Stats;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class StatsRepositoryImpl implements StatsRepository{
    @Override
    public Stats getStats() {
        return null;
    }


    private BigDecimal getRadio(){
        return null;
    }
}
