package br.com.digio.digioteste.lancamentocontabil.infrastructure.repository.mapper;

import br.com.digio.digioteste.lancamentocontabil.domain.Lancamento;
import br.com.digio.digioteste.lancamentocontabil.domain.LancamentoAggregate;
import br.com.digio.digioteste.lancamentocontabil.infrastructure.repository.mongodb.LancamentoAggregation;
import br.com.digio.digioteste.lancamentocontabil.infrastructure.repository.mongodb.LancamentoDocument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LancamentoRepositoryMapper {

    LancamentoRepositoryMapper mapper = Mappers.getMapper(LancamentoRepositoryMapper.class);

    Lancamento map(LancamentoDocument lancamentoDocument);
    List<Lancamento> map(List<LancamentoDocument> lancamentosDocument);
    LancamentoDocument map(Lancamento lancamento);

    LancamentoAggregate map(LancamentoAggregation lancamentoAggregation);
}
