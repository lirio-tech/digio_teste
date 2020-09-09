package br.com.digio.digioteste.lancamentocontabil.domain;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LancamentoAggregate {

    private Long contaContabil;

    private Double soma;
    private Double minimo;
    private Double maximo;
    private Double media;
    private Integer quantidade;

    public LancamentoAggregate getStats(LancamentoGateway repository) {
        LancamentoAggregate lancamentoAggregate = repository.getEstatistica(contaContabil);
        if(Objects.isNull(lancamentoAggregate)) {
            return createInitialState();
        }
        return lancamentoAggregate;
    }

    private static LancamentoAggregate createInitialState() {
        return LancamentoAggregate.builder().soma(0D).minimo(0D).maximo(0D).media(0D).quantidade(0).build();
    }
}
