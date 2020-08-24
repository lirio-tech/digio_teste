package br.com.digio.digioteste.lancamentocontabil.presentation;

import br.com.digio.digioteste.lancamentocontabil.application.LancamentoService;
import br.com.digio.digioteste.lancamentocontabil.domain.Lancamento;
import br.com.digio.digioteste.lancamentocontabil.presentation.resources.LancamentoResource;
import br.com.digio.digioteste.lancamentocontabil.presentation.resources.LancamentoResourceID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static br.com.digio.digioteste.lancamentocontabil.presentation.mapper.LancamentoMapper.mapper;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/lancamentos-contabeis")
public class LancamentoContabilController {

    private final LancamentoService lancamentoService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public LancamentoResourceID save(@Valid @RequestBody LancamentoResource lancamentoResource) {
        Lancamento lancamento = mapper.map(lancamentoResource);
        return mapper.mapID(this.lancamentoService.save(lancamento));
    }

    @GetMapping("/{id}")
    public LancamentoResource getById(@PathVariable String id) {
        return mapper.map(this.lancamentoService.getById(id));
    }


}
