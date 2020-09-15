package br.com.digio.digioteste.lancamentocontabil.infrastructure.conta;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "contaClient", url = "${services.conta.url}")
public interface ContaClient {

    @GetMapping("/{numero}")
    ContContabil getByNumero(@PathVariable("numero") int numero);
}
