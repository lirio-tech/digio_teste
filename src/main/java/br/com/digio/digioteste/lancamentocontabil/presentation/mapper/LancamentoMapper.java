package br.com.digio.digioteste.lancamentocontabil.presentation.mapper;

import br.com.digio.digioteste.lancamentocontabil.application.out.UsecaseGetRegistryByContaContabilOutputPort;
import br.com.digio.digioteste.lancamentocontabil.application.out.UsecaseGetRegistryByIdOutputPort;
import br.com.digio.digioteste.lancamentocontabil.application.out.UsecaseGetRegistryStatsOutputPort;
import br.com.digio.digioteste.lancamentocontabil.application.out.UsecaseSaveRegistryOutputPort;
import br.com.digio.digioteste.lancamentocontabil.presentation.in.UsecaseSaveRegistryInputAdapter;
import br.com.digio.digioteste.lancamentocontabil.presentation.resources.LancamentoAgregateResource;
import br.com.digio.digioteste.lancamentocontabil.presentation.resources.LancamentoResource;
import br.com.digio.digioteste.lancamentocontabil.presentation.resources.LancamentoResourceID;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LancamentoMapper {

    LancamentoMapper mapper = Mappers.getMapper(LancamentoMapper.class);

    UsecaseSaveRegistryInputAdapter mapInput(LancamentoResource lancamentoResource);

    LancamentoResourceID mapOut(UsecaseSaveRegistryOutputPort output);

    LancamentoResource mapOut(UsecaseGetRegistryByIdOutputPort outputAdapter);

    List<LancamentoResource> map(List<UsecaseGetRegistryByContaContabilOutputPort> outputPorts);

    LancamentoAgregateResource map(UsecaseGetRegistryStatsOutputPort outputPort);
}
