package com.dna.repository;

import com.dna.domain.DNA;
import com.dna.domain.Stats;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.ComparisonOperators;
import org.springframework.data.mongodb.core.aggregation.ConditionalOperators;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;

@Resource(name="statsRepositoryImpl")
@Repository
public class StatsRepositoryImpl implements StatsRepository{


    @Autowired
    private transient MongoTemplate template;

    @Override
    public Stats getStats() {
        Stats stats = getStatsWithoutRatio();
        BigDecimal ratio = getRatio(stats);
        stats.setRatio(ratio);
        return stats;
    }


    private BigDecimal getRatio(Stats stats){
        BigDecimal ratio = BigDecimal.ZERO;

        if (stats.getMutantCount() != 0) {
            if (stats.getHumanCount() == 0) {
                ratio = BigDecimal.ONE;
            } else {
                BigDecimal mutant = BigDecimal.valueOf(stats.getMutantCount());
                BigDecimal human = BigDecimal.valueOf(stats.getHumanCount());
                ratio = mutant.divide(human, 2, RoundingMode.HALF_UP);
            }
        }
        return ratio;

    }


    private Stats getStatsWithoutRatio() {

        Aggregation aggregation = Aggregation.newAggregation(
                group()
                        .sum(ConditionalOperators
                                .when(ComparisonOperators.valueOf("mutante").equalToValue(true)).then(1).otherwise(0)).as("mutantCount")
                        .sum(ConditionalOperators
                                .when(ComparisonOperators.valueOf("mutante").equalToValue(false)).then(1).otherwise(0)).as("nonMutantCount")
                        .count().as("total")
        );

        AggregationResults<Stats> result = this.template.aggregate(aggregation, DNA.class, Stats.class);
        Stats stats = result.getUniqueMappedResult();
        if(stats == null){
            return new Stats();
        }
        else{
            return stats;
        }
    }
}
