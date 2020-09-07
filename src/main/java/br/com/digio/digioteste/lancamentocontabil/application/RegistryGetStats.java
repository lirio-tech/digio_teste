package br.com.digio.digioteste.lancamentocontabil.application;

import br.com.digio.digioteste.lancamentocontabil.application.in.UsecaseGetRegistryStatsInputPort;
import br.com.digio.digioteste.lancamentocontabil.application.out.UsecaseGetRegistryStatsOutputPort;

public interface RegistryGetStats {

    UsecaseGetRegistryStatsOutputPort execute(UsecaseGetRegistryStatsInputPort inputPort);

}
