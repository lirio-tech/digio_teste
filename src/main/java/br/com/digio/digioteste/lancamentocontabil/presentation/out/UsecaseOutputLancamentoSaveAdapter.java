package br.com.digio.digioteste.lancamentocontabil.presentation.out;

import br.com.digio.digioteste.lancamentocontabil.application.out.UsecaseSaveRegistryOutputPort;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsecaseOutputLancamentoSaveAdapter implements UsecaseSaveRegistryOutputPort {

    private String id;

}
