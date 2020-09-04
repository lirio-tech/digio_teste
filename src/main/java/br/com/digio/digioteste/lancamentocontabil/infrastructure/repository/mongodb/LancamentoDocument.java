package br.com.digio.digioteste.lancamentocontabil.infrastructure.repository.mongodb;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

import static br.com.digio.digioteste.lancamentocontabil.infrastructure.repository.mongodb.LancamentoDocument.LANCAMENTOS;

@Getter
@Setter
@Document(value = LANCAMENTOS)
public class LancamentoDocument {

    public static final String LANCAMENTOS = "lancamentos";

    @Id
    private String id;
    private Long contaContabil;
    private Double valor;
    private LocalDate data;

}
