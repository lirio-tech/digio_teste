package br.com.digio.digioteste.lancamentocontabil.domain;

import br.com.digio.digioteste.lancamentocontabil.template.LancamentoFixtureTemplate;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static br.com.digio.digioteste.lancamentocontabil.template.LancamentoFixtureTemplate.LABEL_LANCAMENTO_COM_ID;
import static br.com.digio.digioteste.lancamentocontabil.template.LancamentoFixtureTemplate.LABEL_LANCAMENTO_SEM_ID_E_DATA_NULL;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class LancamentoTests {

    @Mock
    private LancamentoGateway repository;

    @BeforeClass
    public static void init() {
        FixtureFactoryLoader.loadTemplates(LancamentoFixtureTemplate.class.getPackage().getName());
    }

    @Test
    public void testSave() {
        Lancamento lancamento = Fixture.from(Lancamento.class).gimme(LABEL_LANCAMENTO_SEM_ID_E_DATA_NULL);
        Lancamento lacamentoComId = Fixture.from(Lancamento.class).gimme(LABEL_LANCAMENTO_COM_ID);
        when(repository.save(lancamento)).thenReturn(lacamentoComId);
        Lancamento saved = lancamento.save(repository);
        Assert.assertNotNull(saved);
        Assert.assertNotNull(saved.getId());
    }

    @Test
    public void testSaveWithDateNull() {
        Lancamento lancamento = Lancamento.builder().data(null).id("165s2fdgn3").contaContabil(121566L).valor(6.99D).build();
        when(repository.save(lancamento)).thenReturn(lancamento);
        Lancamento saved = lancamento.save(repository);
        Assert.assertNotNull(saved);
        Assert.assertNotNull(saved.getData());
    }

    @Test
    public void testGetById() {
        Lancamento lacamentoComId = Fixture.from(Lancamento.class).gimme(LABEL_LANCAMENTO_COM_ID);
        when(repository.findById(lacamentoComId.getId())).thenReturn(lacamentoComId);
        Lancamento getById = lacamentoComId.getById(repository);
        Assert.assertNotNull(getById);
        Assert.assertNotNull(getById.getId());
        Assert.assertNotNull(getById.getContaContabil());
        Assert.assertTrue(getById.getValor() > 0);
        Assert.assertEquals(getById.getData(), lacamentoComId.getData());
    }

}
