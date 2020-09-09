package br.com.digio.digioteste.lancamentocontabil.domain;

import java.util.List;

public interface LancamentoGateway {

    Lancamento save(Lancamento lancamento);

    Lancamento findById(String id);

    List<Lancamento> findByContaContabil(Long contaContabil);

    LancamentoAggregate getEstatistica(Long contaContabil);
}
