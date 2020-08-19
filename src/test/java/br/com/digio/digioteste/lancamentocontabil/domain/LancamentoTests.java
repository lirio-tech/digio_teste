package br.com.digio.digioteste.lancamentocontabil.domain;

import br.com.digio.digioteste.lancamentocontabil.infrastructure.repository.LancamentoRepository;
import br.com.digio.digioteste.lancamentocontabil.template.LancamentoFixtureTemplate;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static br.com.digio.digioteste.lancamentocontabil.template.LancamentoFixtureTemplate.LABEL_LANCAMENTO_COM_ID;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class LancamentoTests {

    @InjectMocks
    private Lancamento lancamento;

    @Mock
    private LancamentoRepository repository;

    @BeforeClass
    public static void init() {
        FixtureFactoryLoader.loadTemplates(LancamentoFixtureTemplate.class.getPackage().getName());
    }

    @Test
    public void testSave() {
        Lancamento lacamentoComId = Fixture.from(Lancamento.class).gimme(LABEL_LANCAMENTO_COM_ID);
        when(repository.save(lancamento)).thenReturn(lacamentoComId);
        Lancamento saved = this.lancamento.save(repository);
        Assert.assertNotNull(saved);
        Assert.assertNotNull(saved.getId());
    }

}
