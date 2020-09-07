package br.com.digio.digioteste.lancamentocontabil.application;

import br.com.digio.digioteste.lancamentocontabil.application.in.UsecaseSaveRegistryInputPort;
import br.com.digio.digioteste.lancamentocontabil.application.out.UsecaseSaveRegistryOutputPort;
import br.com.digio.digioteste.lancamentocontabil.domain.Lancamento;
import br.com.digio.digioteste.lancamentocontabil.domain.LancamentoRepository;


import javax.inject.Named;

import static br.com.digio.digioteste.lancamentocontabil.application.mapper.LancamentoUsecasePortMapper.mapper;

@Named
public class RegistrySaveImpl implements RegistrySave {

    private final LancamentoRepository repository;

    public RegistrySaveImpl(LancamentoRepository repository) {
        this.repository = repository;
    }

    @Override
    public UsecaseSaveRegistryOutputPort execute(UsecaseSaveRegistryInputPort usecaseInputPort) {
        Lancamento lancamento = mapper.map(usecaseInputPort);
        return mapper.mapOutputAdapter(lancamento.save(repository));
    }
}
