package br.com.digio.digioteste.lancamentocontabil.application;

import br.com.digio.digioteste.lancamentocontabil.domain.Lancamento;
import br.com.digio.digioteste.lancamentocontabil.domain.LancamentoAggregate;

import java.util.List;

public interface LancamentoService {

    Lancamento save(Lancamento lancamento);
    Lancamento getById(String id);
    List<Lancamento> getByContaContabil(Long contaContabil);
    LancamentoAggregate getEstatisticas(Long contaContabil);
}
