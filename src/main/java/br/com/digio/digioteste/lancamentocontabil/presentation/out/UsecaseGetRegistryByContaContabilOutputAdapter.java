package br.com.digio.digioteste.lancamentocontabil.presentation.out;

import br.com.digio.digioteste.lancamentocontabil.application.out.UsecaseGetRegistryByContaContabilOutputPort;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UsecaseGetRegistryByContaContabilOutputAdapter implements UsecaseGetRegistryByContaContabilOutputPort {

    private Long contaContabil;
    private LocalDate data;
}
