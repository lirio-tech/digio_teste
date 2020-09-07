package br.com.digio.digioteste.lancamentocontabil.presentation.out;

import br.com.digio.digioteste.lancamentocontabil.application.out.UsecaseGetRegistryStatsOutputPort;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsecaseGetRegistryStatsOutputAdapter implements UsecaseGetRegistryStatsOutputPort {
    private Double soma;
    private Double minimo;
    private Double maximo;
    private Double media;
    private Integer quantidade;
}
