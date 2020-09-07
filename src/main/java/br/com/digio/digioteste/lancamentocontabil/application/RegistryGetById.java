package br.com.digio.digioteste.lancamentocontabil.application;

import br.com.digio.digioteste.lancamentocontabil.application.in.UsecaseGetRegistryByIdInputPort;
import br.com.digio.digioteste.lancamentocontabil.application.out.UsecaseGetRegistryByIdOutputPort;

public interface RegistryGetById {

    UsecaseGetRegistryByIdOutputPort execute(UsecaseGetRegistryByIdInputPort inputPort);

}
