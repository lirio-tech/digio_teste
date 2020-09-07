package br.com.digio.digioteste.lancamentocontabil.application;

import br.com.digio.digioteste.lancamentocontabil.application.in.UsecaseGetRegistryByContaContabilInputPort;
import br.com.digio.digioteste.lancamentocontabil.application.out.UsecaseGetRegistryByContaContabilOutputPort;

import java.util.List;

public interface RegistryGetByContaContabil {

    List<UsecaseGetRegistryByContaContabilOutputPort> execute(UsecaseGetRegistryByContaContabilInputPort inputPort);

}
