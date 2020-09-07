package br.com.digio.digioteste.lancamentocontabil.presentation.in;

import br.com.digio.digioteste.lancamentocontabil.application.in.UsecaseSaveRegistryInputPort;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class UsecaseSaveRegistryInputAdapter implements UsecaseSaveRegistryInputPort {

    private Long contaContabil;
    private Double valor;
    private LocalDate data;

}
