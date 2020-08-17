package br.com.digio.digioteste.lancamentocontabil.presentation;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class LancamentoResource {
    private String descricao;
    private Double valor;
    private LocalDate data;
}
