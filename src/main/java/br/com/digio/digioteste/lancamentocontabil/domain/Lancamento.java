package br.com.digio.digioteste.lancamentocontabil.domain;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Lancamento {

    private String id;
    private Long contaContabil;
    private Double valor;
    private LocalDate data;

    public Lancamento save(LancamentoRepository repository) {
        if (Objects.isNull(data)) {
            data = LocalDate.now();
            log.info("Data Null, {}", data);
        }
        return repository.save(this);
    }

    public Lancamento getById(LancamentoRepository repository) {
        return repository.findById(this.id);
    }

    public List<Lancamento> getByContaContabil(LancamentoRepository repository) {
        return repository.findByContaContabil(this.getContaContabil());
    }

}
