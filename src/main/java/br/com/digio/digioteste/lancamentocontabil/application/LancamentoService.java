package br.com.digio.digioteste.lancamentocontabil.application;

import br.com.digio.digioteste.lancamentocontabil.domain.Lancamento;

public interface LancamentoService {

    Lancamento save(Lancamento lancamento);
    Lancamento getById(String id);
}
