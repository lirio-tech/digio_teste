package br.com.digio.digioteste.lancamentocontabil.infrastructure.conta;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ContContabil {

    private Long numero;
    private LocalDateTime dateTimeRegistry;

}
