package br.com.digio.digioteste.lancamentocontabil.application;

import br.com.digio.digioteste.lancamentocontabil.application.in.UsecaseSaveRegistryInputPort;
import br.com.digio.digioteste.lancamentocontabil.application.out.UsecaseSaveRegistryOutputPort;

public interface RegistrySave {

    UsecaseSaveRegistryOutputPort execute(UsecaseSaveRegistryInputPort usecaseSaveRegistryInputPort);

}
