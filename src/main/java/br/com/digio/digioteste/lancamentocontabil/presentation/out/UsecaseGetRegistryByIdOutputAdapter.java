package br.com.digio.digioteste.lancamentocontabil.presentation.out;

import br.com.digio.digioteste.lancamentocontabil.application.out.UsecaseGetRegistryByIdOutputPort;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UsecaseGetRegistryByIdOutputAdapter implements UsecaseGetRegistryByIdOutputPort {

    private Long contaContabil;
    private Double valor;
    private LocalDate data;
}
