package br.com.digio.digioteste.lancamentocontabil.infrastructure.repository.mapper;

import br.com.digio.digioteste.lancamentocontabil.domain.Lancamento;
import br.com.digio.digioteste.lancamentocontabil.infrastructure.repository.mongodb.LancamentoDocument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LancamentoRepositoryMapper {

    LancamentoRepositoryMapper mapper = Mappers.getMapper(LancamentoRepositoryMapper.class);

    Lancamento map(LancamentoDocument lancamentoDocument);
    LancamentoDocument map(Lancamento lancamento);
}
