package br.com.digio.digioteste.lancamentocontabil.presentation.in;

import br.com.digio.digioteste.lancamentocontabil.application.in.UsecaseGetRegistryByIdInputPort;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsecaseGetRegistryByIdInputAdapter implements UsecaseGetRegistryByIdInputPort {

    private String id;
}
