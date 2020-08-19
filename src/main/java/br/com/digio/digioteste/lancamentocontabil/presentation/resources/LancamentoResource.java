package br.com.digio.digioteste.lancamentocontabil.presentation.resources;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
public class LancamentoResource {

    @NotBlank
    private String descricao;
    @DecimalMin(value = "1.00", inclusive = false)
    @Digits(integer=3, fraction=2)
    private BigDecimal valor;

    private LocalDate data = LocalDate.now();
}
