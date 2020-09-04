package br.com.digio.digioteste.lancamentocontabil.domain;

import lombok.*;

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

    public LancamentoAggregate getStats(LancamentoRepository repository) {
        return repository.getEstatistica(contaContabil);
    }
}
