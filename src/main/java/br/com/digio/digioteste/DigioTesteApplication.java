package br.com.digio.digioteste;

import br.com.digio.digioteste.lancamentocontabil.infrastructure.conta.ContContabil;
import br.com.digio.digioteste.lancamentocontabil.infrastructure.conta.ContaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@EnableFeignClients
@RestController
@RequestMapping
@SpringBootApplication
public class DigioTesteApplication {

    @Autowired
    private ContaClient contaClient;

    public static void main(String[] args) {
        SpringApplication.run(DigioTesteApplication.class, args);
    }

    @GetMapping("/conta")
    public ContContabil getConta(int qtde) {
        return get(qtde == 0 ? new Random().nextInt() : qtde);
    }

    private ContContabil get(int numero) {
        return contaClient.getByNumero(numero);
    }

}
