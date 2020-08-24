package br.com.digio.digioteste.lancamentocontabil.infrastructure.repository;

import static br.com.digio.digioteste.lancamentocontabil.infrastructure.repository.mapper.LancamentoRepositoryMapper.mapper;

import br.com.digio.digioteste.lancamentocontabil.domain.Lancamento;
import br.com.digio.digioteste.lancamentocontabil.domain.LancamentoRepository;
import br.com.digio.digioteste.lancamentocontabil.infrastructure.repository.mongodb.LancamentoCrudRepository;
import br.com.digio.digioteste.lancamentocontabil.infrastructure.repository.mongodb.LancamentoDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LancamentoRepositoryImpl implements LancamentoRepository {

    private final LancamentoCrudRepository lancamentoCrudRepository;

    @Override
    public Lancamento save(Lancamento lancamento) {
        LancamentoDocument document = mapper.map(lancamento);
        return mapper.map(this.lancamentoCrudRepository.save(document));
    }

    @Override
    public Lancamento getById(String id) {
        LancamentoDocument lancamentoDocument = lancamentoCrudRepository.findById(id).orElseThrow();
        return mapper.map(lancamentoDocument);
    }
}
