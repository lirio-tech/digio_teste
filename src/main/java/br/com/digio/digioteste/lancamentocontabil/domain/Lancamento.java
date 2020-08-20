package br.com.digio.digioteste.lancamentocontabil.domain;

import br.com.digio.digioteste.lancamentocontabil.infrastructure.repository.LancamentoRepository;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Objects;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Lancamento {

    private String id;
    private String descricao;
    private Double valor;
    private LocalDate data;

    public Lancamento save(LancamentoRepository repository) {
        if(Objects.isNull(data)) {
            data = LocalDate.now();
            log.info("Data Nulla, {}", data);
        }
        return repository.save(this);
    }

    public Lancamento getById(LancamentoRepository repository) {
        return repository.getById(this.id);
    }
}
