package br.com.digio.digioteste.lancamentocontabil.application;

import br.com.digio.digioteste.lancamentocontabil.application.in.UsecaseGetRegistryStatsInputPort;
import br.com.digio.digioteste.lancamentocontabil.application.out.UsecaseGetRegistryStatsOutputPort;
import br.com.digio.digioteste.lancamentocontabil.domain.LancamentoAggregate;
import br.com.digio.digioteste.lancamentocontabil.domain.LancamentoRepository;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

import static br.com.digio.digioteste.lancamentocontabil.application.mapper.LancamentoUsecasePortMapper.mapper;

@Named
@RequiredArgsConstructor
public class RegistryGetStatsImpl implements RegistryGetStats {

    private final LancamentoRepository repository;

    @Override
    public UsecaseGetRegistryStatsOutputPort execute(UsecaseGetRegistryStatsInputPort inputPort) {
        LancamentoAggregate lancamentoAggregate = mapper.map(inputPort).getStats(repository);
        return mapper.map(lancamentoAggregate);
    }
}
