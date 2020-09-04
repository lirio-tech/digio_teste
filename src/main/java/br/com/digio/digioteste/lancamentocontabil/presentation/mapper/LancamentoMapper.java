package br.com.digio.digioteste.lancamentocontabil.presentation.mapper;

import br.com.digio.digioteste.lancamentocontabil.domain.Lancamento;
import br.com.digio.digioteste.lancamentocontabil.domain.LancamentoAggregate;
import br.com.digio.digioteste.lancamentocontabil.presentation.resources.LancamentoAgregateResource;
import br.com.digio.digioteste.lancamentocontabil.presentation.resources.LancamentoResource;
import br.com.digio.digioteste.lancamentocontabil.presentation.resources.LancamentoResourceID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface LancamentoMapper {

    LancamentoMapper mapper = Mappers.getMapper(LancamentoMapper.class);

    Lancamento map(LancamentoResource lancamentoResource);

    LancamentoResourceID mapID(Lancamento lancamento);

    LancamentoResource map(Lancamento lancamento);

    @Named("mapToSearch")
    @Mapping(target = "valor", ignore = true)
    LancamentoResource mapToSearch(Lancamento lancamento);

    default List<LancamentoResource> mapToSearch(List<Lancamento> lancamentos) {
        return lancamentos.stream()
                   .map(l -> this.mapToSearch(l))
                   .collect(Collectors.toList());
    }

    LancamentoAgregateResource map(LancamentoAggregate lancamentoAgregate);

}
