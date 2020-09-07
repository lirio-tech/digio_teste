package br.com.digio.digioteste.lancamentocontabil.presentation.in;

import br.com.digio.digioteste.lancamentocontabil.application.in.UsecaseGetRegistryByContaContabilInputPort;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsecaseGetRegistryByContaContabilInputAdapter implements UsecaseGetRegistryByContaContabilInputPort {

    private Long contaContabil;
}
