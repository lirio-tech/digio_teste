package br.com.digio.digioteste.lancamentocontabil.application;

import br.com.digio.digioteste.lancamentocontabil.application.in.UsecaseGetRegistryByContaContabilInputPort;
import br.com.digio.digioteste.lancamentocontabil.application.out.UsecaseGetRegistryByContaContabilOutputPort;
import br.com.digio.digioteste.lancamentocontabil.domain.Lancamento;
import br.com.digio.digioteste.lancamentocontabil.domain.LancamentoRepository;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.digio.digioteste.lancamentocontabil.application.mapper.LancamentoUsecasePortMapper.mapper;

@Named
@RequiredArgsConstructor
public class RegistryGetByContaContabilImpl implements RegistryGetByContaContabil {

    private final LancamentoRepository repository;

    @Override
    public List<UsecaseGetRegistryByContaContabilOutputPort> execute(UsecaseGetRegistryByContaContabilInputPort inputPort) {
        Lancamento lancamento = mapper.map(inputPort);
        List<Lancamento> lancamentos = lancamento.getByContaContabil(repository);
        return lancamentos.stream()
                          .map(l -> mapper.map(l))
                          .collect(Collectors.toList());
    }
}
