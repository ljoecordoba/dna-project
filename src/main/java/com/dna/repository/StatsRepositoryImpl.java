package com.dna.repository;

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

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;

@Resource(name="statsRepositoryImpl")
@Repository
public class StatsRepositoryImpl implements StatsRepository{


    private Logger logger = LoggerFactory.getLogger(StatsRepositoryImpl.class.getName());
    @Autowired
    private transient MongoTemplate template;

    @Override
    public Stats getStats() {
        Stats stats = getSumaTotalAndMutante();
        //logger.info("Los campos son " + stats.getMutantQuantity() + " y " + stats.getHumansQuantity());
        //stats.setRatio(stats.getMutantQuantity().divide(stats.getHumansQuantity()));
        return stats;
    }


    private BigDecimal getRadio(){
        return null;
    }


    private Stats getSumaTotalAndMutante() {

        Aggregation aggregation = Aggregation.newAggregation(
                group()
                        .sum(ConditionalOperators
                                .when(ComparisonOperators.valueOf("mutante").equalToValue(true)).then(1).otherwise(0)).as("mutantsQuantity")
                        .sum(ConditionalOperators
                                .when(ComparisonOperators.valueOf("mutante").equalToValue(false)).then(1).otherwise(0)).as("humansQuantity")

        );
        Aggregation ownAggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("mutante").is(true)),Aggregation.group().count().as("totalMutants"));
        //AggregationResults<Stats> results = this.template.aggregate(aggregation, Stats.class, Stats.class);
        AggregationResults<Stats> results = this.template.aggregate(aggregation,Stats.class,Stats.class);
        //Long.parseLong(results.getMappedResults().get(0).getT;

        Stats status = results.getUniqueMappedResult();
        return status;
    }
}
