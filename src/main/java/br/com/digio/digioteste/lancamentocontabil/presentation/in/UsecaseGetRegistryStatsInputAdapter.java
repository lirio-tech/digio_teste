package br.com.digio.digioteste.lancamentocontabil.presentation.in;

import br.com.digio.digioteste.lancamentocontabil.application.in.UsecaseGetRegistryStatsInputPort;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsecaseGetRegistryStatsInputAdapter implements UsecaseGetRegistryStatsInputPort {

    private Long contaContabil;
}
