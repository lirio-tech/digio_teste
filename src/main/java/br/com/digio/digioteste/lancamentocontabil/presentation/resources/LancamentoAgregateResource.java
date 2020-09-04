package br.com.digio.digioteste.lancamentocontabil.presentation.resources;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LancamentoAgregateResource {

    private Double soma;
    private Double minimo;
    private Double maximo;
    private Double media;
    private Integer quantidade;
}
