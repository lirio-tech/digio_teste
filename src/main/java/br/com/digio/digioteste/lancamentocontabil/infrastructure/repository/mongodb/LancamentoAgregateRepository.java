package br.com.digio.digioteste.lancamentocontabil.infrastructure.repository.mongodb;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class LancamentoAgregateRepository {

    private final MongoTemplate mongoTemplate;

    public LancamentoAggregation getStats(Long contaContabil) {
        if (Objects.isNull(contaContabil)) {
            return getStats();
        }
        return getStatsWithContaContabil(contaContabil);
    }

    private LancamentoAggregation getStats() {
        GroupOperation group =
                Aggregation.group()
                        .min("valor").as("minimo")
                        .max("valor").as("maximo")
                        .avg("valor").as("media")
                        .sum("valor").as("soma")
                        .count().as("quantidade");
        Aggregation aggregation = Aggregation.newAggregation(group);
        AggregationResults<LancamentoAggregation> aggregate =
                mongoTemplate.aggregate(aggregation, LancamentoDocument.LANCAMENTOS, LancamentoAggregation.class);
        return aggregate.getUniqueMappedResult();
    }

    private LancamentoAggregation getStatsWithContaContabil(Long contaContabil) {
        MatchOperation matchOperation =
                Aggregation.match(new Criteria("contaContabil").is(contaContabil));
        GroupOperation group =
                Aggregation.group("contaContabil")
                        .min("valor").as("minimo")
                        .max("valor").as("maximo")
                        .avg("valor").as("media")
                        .sum("valor").as("soma")
                        .count().as("quantidade");

        Aggregation aggregation = Aggregation.newAggregation(matchOperation, group);
        AggregationResults<LancamentoAggregation> aggregate =
                mongoTemplate.aggregate(aggregation, LancamentoDocument.LANCAMENTOS, LancamentoAggregation.class);
        return aggregate.getUniqueMappedResult();
    }

}
