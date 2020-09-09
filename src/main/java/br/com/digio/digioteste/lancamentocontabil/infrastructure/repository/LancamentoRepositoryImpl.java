package br.com.digio.digioteste.lancamentocontabil.infrastructure.repository;

import br.com.digio.digioteste.lancamentocontabil.domain.Lancamento;
import br.com.digio.digioteste.lancamentocontabil.domain.LancamentoAggregate;
import br.com.digio.digioteste.lancamentocontabil.domain.LancamentoGateway;
import br.com.digio.digioteste.lancamentocontabil.infrastructure.repository.mongodb.LancamentoAgregateRepository;
import br.com.digio.digioteste.lancamentocontabil.infrastructure.repository.mongodb.LancamentoCrudRepository;
import br.com.digio.digioteste.lancamentocontabil.infrastructure.repository.mongodb.LancamentoDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static br.com.digio.digioteste.lancamentocontabil.infrastructure.repository.mapper.LancamentoRepositoryMapper.mapper;

@Repository
@RequiredArgsConstructor
public class LancamentoRepositoryImpl implements LancamentoGateway {

    private final LancamentoCrudRepository lancamentoCrudRepository;
    private final LancamentoAgregateRepository agregateRepository;

    @Override
    public Lancamento save(Lancamento lancamento) {
        LancamentoDocument document = mapper.map(lancamento);
        return mapper.map(this.lancamentoCrudRepository.save(document));
    }

    @Override
    public Lancamento findById(String id) {
        LancamentoDocument lancamentoDocument = lancamentoCrudRepository.findById(id).orElseThrow();
        return mapper.map(lancamentoDocument);
    }

    @Override
    public List<Lancamento> findByContaContabil(Long contaContabil) {
        List<LancamentoDocument> lancamentos = lancamentoCrudRepository.findByContaContabil(contaContabil);
        return mapper.map(lancamentos);
    }

    @Override
    public LancamentoAggregate getEstatistica(Long contaContabil) {
        return mapper.map(agregateRepository.getStats(contaContabil));
    }

}
