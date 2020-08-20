package br.com.digio.digioteste.lancamentocontabil.application;

import br.com.digio.digioteste.lancamentocontabil.domain.Lancamento;
import br.com.digio.digioteste.lancamentocontabil.infrastructure.repository.LancamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LancamentoServiceImpl implements LancamentoService {

    private final LancamentoRepository repository;

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
}
