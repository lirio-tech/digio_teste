package br.com.digio.digioteste.lancamentocontabil.template;

import br.com.digio.digioteste.lancamentocontabil.domain.Lancamento;
import br.com.digio.digioteste.lancamentocontabil.presentation.resources.LancamentoResource;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.time.LocalDate;

public class LancamentoFixtureTemplate implements TemplateLoader {

    public final static String LABEL_LANCAMENTO_COM_ID = "label-lamento-com-id";
    public final static String LABEL_LANCAMENTO_SEM_ID_E_DATA_NULL = "label-lamento-sem-id-e-com-data-null";

    public final static String LABEL_RESOURCES_LANCAMENTO_SEM_ID_E_DATA_NULL = "label-resources-lamento-sem-id-e-com-data-null";

    private static final String ID = "id";
    private static final String DESCRICAO = "descricao";
    private static final String VALOR = "valor";
    private static final String DATA = "data";


    @Override
    public void load() {
        Fixture.of(Lancamento.class).addTemplate(LABEL_LANCAMENTO_COM_ID, new Rule() {
            {
                add(LancamentoFixtureTemplate.ID, "65saf21df21b6541fhm");
                add(LancamentoFixtureTemplate.DESCRICAO, "Lancamento Test");
                add(LancamentoFixtureTemplate.VALOR, 29.99D);
                add(LancamentoFixtureTemplate.DATA, LocalDate.now());
            }
        });
        Fixture.of(Lancamento.class).addTemplate(LABEL_LANCAMENTO_SEM_ID_E_DATA_NULL, new Rule() {
            {
                add(LancamentoFixtureTemplate.DESCRICAO, "Lancamento Test com Data Null");
                add(LancamentoFixtureTemplate.VALOR, 1.99D);
            }
        });
        Fixture.of(LancamentoResource.class).addTemplate(LABEL_RESOURCES_LANCAMENTO_SEM_ID_E_DATA_NULL, new Rule() {
            {
                add(LancamentoFixtureTemplate.DESCRICAO, "Lancamento RESOURCES");
                add(LancamentoFixtureTemplate.VALOR, "1.99");
            }
        });
    }
}
