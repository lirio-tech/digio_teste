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

import static br.com.digio.digioteste.lancamentocontabil.infrastructure.repository.mongodb.LancamentoAggregation.*;

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
                        .min(VALOR_FIELD).as(MINIMO_FIELD)
                        .max(VALOR_FIELD).as(MAXIMO_FIELD)
                        .avg(VALOR_FIELD).as(MEDIA_FIELD)
                        .sum(VALOR_FIELD).as(SOMA_FIELD)
                        .count().as(QUANTIDADE_FIELD);
        Aggregation aggregation = Aggregation.newAggregation(group);
        AggregationResults<LancamentoAggregation> aggregate =
                mongoTemplate.aggregate(aggregation, LancamentoDocument.LANCAMENTOS, LancamentoAggregation.class);
        return aggregate.getUniqueMappedResult();
    }

    private LancamentoAggregation getStatsWithContaContabil(Long contaContabil) {
        MatchOperation matchOperation =
                Aggregation.match(new Criteria(CONTA_CONTABIL_FIELD).is(contaContabil));
        GroupOperation group =
                Aggregation.group(CONTA_CONTABIL_FIELD)
                        .min(VALOR_FIELD).as(MINIMO_FIELD)
                        .max(VALOR_FIELD).as(MAXIMO_FIELD)
                        .avg(VALOR_FIELD).as(MEDIA_FIELD)
                        .sum(VALOR_FIELD).as(SOMA_FIELD)
                        .count().as(QUANTIDADE_FIELD);

        Aggregation aggregation = Aggregation.newAggregation(matchOperation, group);
        AggregationResults<LancamentoAggregation> aggregate =
                mongoTemplate.aggregate(aggregation, LancamentoDocument.LANCAMENTOS, LancamentoAggregation.class);
        return aggregate.getUniqueMappedResult();
    }

}
