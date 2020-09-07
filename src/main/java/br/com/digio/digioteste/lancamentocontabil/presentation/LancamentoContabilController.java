package br.com.digio.digioteste.lancamentocontabil.presentation;

import br.com.digio.digioteste.lancamentocontabil.application.RegistryGetByContaContabil;
import br.com.digio.digioteste.lancamentocontabil.application.RegistryGetById;
import br.com.digio.digioteste.lancamentocontabil.application.RegistryGetStats;
import br.com.digio.digioteste.lancamentocontabil.application.RegistrySave;
import br.com.digio.digioteste.lancamentocontabil.application.out.UsecaseGetRegistryByContaContabilOutputPort;
import br.com.digio.digioteste.lancamentocontabil.application.out.UsecaseGetRegistryByIdOutputPort;
import br.com.digio.digioteste.lancamentocontabil.application.out.UsecaseGetRegistryStatsOutputPort;
import br.com.digio.digioteste.lancamentocontabil.application.out.UsecaseSaveRegistryOutputPort;
import br.com.digio.digioteste.lancamentocontabil.presentation.in.UsecaseGetRegistryByContaContabilInputAdapter;
import br.com.digio.digioteste.lancamentocontabil.presentation.in.UsecaseGetRegistryByIdInputAdapter;
import br.com.digio.digioteste.lancamentocontabil.presentation.in.UsecaseGetRegistryStatsInputAdapter;
import br.com.digio.digioteste.lancamentocontabil.presentation.in.UsecaseSaveRegistryInputAdapter;
import br.com.digio.digioteste.lancamentocontabil.presentation.resources.LancamentoAgregateResource;
import br.com.digio.digioteste.lancamentocontabil.presentation.resources.LancamentoResource;
import br.com.digio.digioteste.lancamentocontabil.presentation.resources.LancamentoResourceID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static br.com.digio.digioteste.lancamentocontabil.presentation.LancamentoContabilController.LANCAMENTOS_CONTABEIS_PREFIX_URL;
import static br.com.digio.digioteste.lancamentocontabil.presentation.mapper.LancamentoMapper.mapper;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(LANCAMENTOS_CONTABEIS_PREFIX_URL)
public class LancamentoContabilController {

    public static final String LANCAMENTOS_CONTABEIS_PREFIX_URL = "/lancamentos-contabeis";

    private final RegistrySave registrySave;
    private final RegistryGetById getRegistryById;
    private final RegistryGetByContaContabil getRegistryByContaContabil;
    private final RegistryGetStats getRegistryByStats;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public LancamentoResourceID save(@Valid @RequestBody LancamentoResource lancamentoResource) {
        UsecaseSaveRegistryInputAdapter inputAdapter = mapper.mapInput(lancamentoResource);
        UsecaseSaveRegistryOutputPort outputPort = registrySave.execute(inputAdapter);
        return mapper.mapOut(outputPort);
    }

    @GetMapping("/{id}")
    public LancamentoResource getById(@PathVariable String id) {
        var input = new UsecaseGetRegistryByIdInputAdapter(id);
        UsecaseGetRegistryByIdOutputPort outputPort = getRegistryById.execute(input);
        return mapper.mapOut(outputPort);
    }

    @GetMapping
    public List<LancamentoResource> getByContaContabil(@RequestParam("contaContabil") Long contaContabil) {
        var inputAdapter = new UsecaseGetRegistryByContaContabilInputAdapter(contaContabil);
        List<UsecaseGetRegistryByContaContabilOutputPort> outputPorts = getRegistryByContaContabil.execute(inputAdapter);
        return mapper.map(outputPorts);
    }

    @GetMapping("/stats")
    public LancamentoAgregateResource stats(@RequestParam(value = "contaContabil", required = false) Long contaContabil) {
        UsecaseGetRegistryStatsInputAdapter in = new UsecaseGetRegistryStatsInputAdapter(contaContabil);
        UsecaseGetRegistryStatsOutputPort outputPort = getRegistryByStats.execute(in);
        return mapper.map(outputPort);
    }


}
