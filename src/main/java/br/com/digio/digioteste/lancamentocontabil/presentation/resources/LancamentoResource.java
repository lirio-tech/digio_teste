package br.com.digio.digioteste.lancamentocontabil.presentation.resources;

import br.com.digio.digioteste.config.jacksonserializer.JacksonCustomSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LancamentoResource {

    @NotNull
    @Min(1)
    private Long contaContabil;

    @DecimalMin(value = "1.00", inclusive = false)
    @Digits(integer=9, fraction=2)
    private BigDecimal valor;

    @NotNull
    @JsonDeserialize(using = JacksonCustomSerializer.CustomLocalDateDeserializer.class)
    @JsonSerialize(using = JacksonCustomSerializer.CustomLocalDateSerializer.class)
    private LocalDate data;
}
