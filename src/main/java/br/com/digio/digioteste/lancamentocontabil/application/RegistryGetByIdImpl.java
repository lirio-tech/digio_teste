package br.com.digio.digioteste.lancamentocontabil.application;

import br.com.digio.digioteste.lancamentocontabil.application.in.UsecaseGetRegistryByIdInputPort;
import br.com.digio.digioteste.lancamentocontabil.application.out.UsecaseGetRegistryByIdOutputPort;
import br.com.digio.digioteste.lancamentocontabil.domain.Lancamento;
import br.com.digio.digioteste.lancamentocontabil.domain.LancamentoRepository;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

import static br.com.digio.digioteste.lancamentocontabil.application.mapper.LancamentoUsecasePortMapper.mapper;

@Named
@RequiredArgsConstructor
public class RegistryGetByIdImpl implements RegistryGetById {

    private final LancamentoRepository repository;

    @Override
    public UsecaseGetRegistryByIdOutputPort execute(UsecaseGetRegistryByIdInputPort inputPort) {
        Lancamento lancamento = mapper.map(inputPort);
        return mapper.mapGetByIdOutput(lancamento.getById(repository));
    }
}
