package br.com.digio.digioteste.lancamentocontabil.presentation;

import br.com.digio.digioteste.lancamentocontabil.application.LancamentoService;
import br.com.digio.digioteste.lancamentocontabil.domain.Lancamento;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static br.com.digio.digioteste.lancamentocontabil.presentation.mapper.LancamentoMapper.mapper;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lancamentos-contabeis")
public class LancamentoContabilController {

    private final LancamentoService lancamentoService;

    @PostMapping
    public LancamentoResourceID save(@RequestBody LancamentoResource lancamentoResource) {
        Lancamento lancamento = mapper.map(lancamentoResource);
        return mapper.mapID(this.lancamentoService.save(lancamento));
    }

    @GetMapping("/{id}")
    public LancamentoResource save(@PathVariable String id) {
        return mapper.map(this.lancamentoService.getById(id));
    }

}
