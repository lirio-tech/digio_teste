package br.com.digio.digioteste.lancamentocontabil.presentation.mapper;

import br.com.digio.digioteste.lancamentocontabil.domain.Lancamento;
import br.com.digio.digioteste.lancamentocontabil.presentation.LancamentoResource;
import br.com.digio.digioteste.lancamentocontabil.presentation.LancamentoResourceID;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LancamentoMapper {

    LancamentoMapper mapper = Mappers.getMapper(LancamentoMapper.class);

    Lancamento map(LancamentoResource lancamentoResource);
    LancamentoResourceID mapID(Lancamento lancamento);
    LancamentoResource map(Lancamento lancamento);
}
