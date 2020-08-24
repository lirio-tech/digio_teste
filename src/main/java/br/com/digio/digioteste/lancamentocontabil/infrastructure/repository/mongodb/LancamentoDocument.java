package br.com.digio.digioteste.lancamentocontabil.infrastructure.repository.mongodb;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@Document(value = "lancamentos")
public class LancamentoDocument {

    @Id
    private String id;
    private Long contaContabil;
    private Double valor;
    private LocalDate data;
}
