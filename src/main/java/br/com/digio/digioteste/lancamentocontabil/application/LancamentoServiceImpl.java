package br.com.digio.digioteste.lancamentocontabil.application;

import br.com.digio.digioteste.config.trace.LogTrace;
import br.com.digio.digioteste.lancamentocontabil.domain.Lancamento;
import br.com.digio.digioteste.lancamentocontabil.domain.LancamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LancamentoServiceImpl implements LancamentoService {

    private final LancamentoRepository repository;

    @LogTrace
    @Override
    public Lancamento save(Lancamento lancamento) {
        return lancamento.save(repository);
    }

    @LogTrace
    @Override
    public Lancamento getById(String id) {
        return Lancamento.builder()
                .id(id)
                .build()
                .getById(repository);
    }
}
