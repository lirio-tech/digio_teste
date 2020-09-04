package br.com.digio.digioteste.lancamentocontabil.application;

import br.com.digio.digioteste.config.trace.LogTrace;
import br.com.digio.digioteste.lancamentocontabil.domain.Lancamento;
import br.com.digio.digioteste.lancamentocontabil.domain.LancamentoAggregate;
import br.com.digio.digioteste.lancamentocontabil.domain.LancamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LancamentoServiceImpl implements LancamentoService {

    private final LancamentoRepository repository;

    @LogTrace
    @Override
    public Lancamento save(Lancamento lancamento) {
        return lancamento.save(repository);
    }

    @Override
    public Lancamento getById(String id) {
        return Lancamento.builder()
                .id(id)
                .build()
            .getById(repository);
    }

    @Override
    public List<Lancamento> getByContaContabil(Long contaContabil) {
        return Lancamento.builder()
                .contaContabil(contaContabil)
                .build()
            .getByContaContabil(repository);
    }

    @Override
    public LancamentoAggregate getEstatisticas(Long contaContabil) {
        return LancamentoAggregate.builder()
                .contaContabil(contaContabil)
                .build()
            .getStats(repository);
    }
}
