package br.com.digio.digioteste.lancamentocontabil.infrastructure.repository.mongodb;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LancamentoAggregation {

    static final String CONTA_CONTABIL_FIELD = "contaContabil";
    static final String VALOR_FIELD = "valor";

    static final String SOMA_FIELD = "soma";
    static final String MINIMO_FIELD = "minimo";
    static final String MAXIMO_FIELD = "maximo";
    static final String MEDIA_FIELD = "media";
    static final String QUANTIDADE_FIELD = "quantidade";

    private Double soma;
    private Double minimo;
    private Double maximo;
    private Double media;
    private Integer quantidade;

}
