package br.com.digio.digioteste.lancamentocontabil.domain;

public interface LancamentoRepository {

    Lancamento save(Lancamento lancamento);
    Lancamento getById(String id);
}
