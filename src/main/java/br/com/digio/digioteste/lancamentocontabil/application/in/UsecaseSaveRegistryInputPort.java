package br.com.digio.digioteste.lancamentocontabil.application.in;

import java.time.LocalDate;

public interface UsecaseSaveRegistryInputPort {

    Long getContaContabil();
    Double getValor();
    LocalDate getData();


}
