package br.com.digio.digioteste.lancamentocontabil.infrastructure.repository.mongodb;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LancamentoAggregation {

    private Double soma;
    private Double minimo;
    private Double maximo;
    private Double media;
    private Integer quantidade;

}
