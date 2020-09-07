package br.com.digio.digioteste.lancamentocontabil.application.mapper;

import br.com.digio.digioteste.lancamentocontabil.application.in.UsecaseGetRegistryByContaContabilInputPort;
import br.com.digio.digioteste.lancamentocontabil.application.in.UsecaseGetRegistryByIdInputPort;
import br.com.digio.digioteste.lancamentocontabil.application.in.UsecaseGetRegistryStatsInputPort;
import br.com.digio.digioteste.lancamentocontabil.application.in.UsecaseSaveRegistryInputPort;
import br.com.digio.digioteste.lancamentocontabil.domain.Lancamento;
import br.com.digio.digioteste.lancamentocontabil.domain.LancamentoAggregate;
import br.com.digio.digioteste.lancamentocontabil.presentation.out.UsecaseGetRegistryByContaContabilOutputAdapter;
import br.com.digio.digioteste.lancamentocontabil.presentation.out.UsecaseGetRegistryByIdOutputAdapter;
import br.com.digio.digioteste.lancamentocontabil.presentation.out.UsecaseGetRegistryStatsOutputAdapter;
import br.com.digio.digioteste.lancamentocontabil.presentation.out.UsecaseOutputLancamentoSaveAdapter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

// TODO Rever

@Mapper(componentModel = "spring")
public interface LancamentoUsecasePortMapper {

    LancamentoUsecasePortMapper mapper = Mappers.getMapper(LancamentoUsecasePortMapper.class);

    Lancamento map(UsecaseSaveRegistryInputPort usecaseInputPort);

    UsecaseOutputLancamentoSaveAdapter mapOutputAdapter(Lancamento save);

    Lancamento map(UsecaseGetRegistryByIdInputPort inputPort);

    UsecaseGetRegistryByIdOutputAdapter mapGetByIdOutput(Lancamento save);

    Lancamento map(UsecaseGetRegistryByContaContabilInputPort inputPort);

    UsecaseGetRegistryByContaContabilOutputAdapter map(Lancamento lancamento);

    LancamentoAggregate map(UsecaseGetRegistryStatsInputPort inputPort);

    UsecaseGetRegistryStatsOutputAdapter map(LancamentoAggregate lancamentoAggregate);
}
