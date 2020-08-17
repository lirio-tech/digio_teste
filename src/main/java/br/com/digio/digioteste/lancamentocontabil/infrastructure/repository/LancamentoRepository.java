package br.com.digio.digioteste.lancamentocontabil.infrastructure.repository;

import br.com.digio.digioteste.lancamentocontabil.domain.Lancamento;

public interface LancamentoRepository {

    Lancamento save(Lancamento lancamento);
    Lancamento getById(String id);
}
