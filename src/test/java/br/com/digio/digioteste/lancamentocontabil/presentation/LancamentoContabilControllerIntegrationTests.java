package br.com.digio.digioteste.lancamentocontabil.presentation;

import br.com.digio.digioteste.DigioTesteApplication;
import br.com.digio.digioteste.lancamentocontabil.presentation.resources.LancamentoResource;
import br.com.digio.digioteste.lancamentocontabil.presentation.resources.LancamentoResourceID;
import br.com.digio.digioteste.lancamentocontabil.template.LancamentoFixtureTemplate;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.Matchers.greaterThan;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.GreaterThan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static br.com.digio.digioteste.lancamentocontabil.template.LancamentoFixtureTemplate.LABEL_RESOURCES_LANCAMENTO_SEM_ID_E_DATA_NULL;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static br.com.digio.digioteste.lancamentocontabil.presentation.LancamentoContabilController.LANCAMENTOS_CONTABEIS_PREFIX_URL;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = DigioTesteApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.yml")
public class LancamentoContabilControllerIntegrationTests {

    @Autowired
    private MockMvc mvc;

    @BeforeClass
    public static void init() {
        FixtureFactoryLoader.loadTemplates(LancamentoFixtureTemplate.class.getPackage().getName());
    }

    @Test
    public void testLancamento_save_thenStatus201()
            throws Exception {

        String json = new ObjectMapper().writeValueAsString(
                Fixture.from(LancamentoResource.class).gimme(LABEL_RESOURCES_LANCAMENTO_SEM_ID_E_DATA_NULL));

        mvc.perform(post(LANCAMENTOS_CONTABEIS_PREFIX_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", CoreMatchers.notNullValue()));
    }

    @Test
    public void testLancamento_getById_thenStatus200() throws Exception {

        String json = new ObjectMapper().writeValueAsString(
                Fixture.from(LancamentoResource.class).gimme(LABEL_RESOURCES_LANCAMENTO_SEM_ID_E_DATA_NULL));

        String responseBodyJson = mvc.perform(post(LANCAMENTOS_CONTABEIS_PREFIX_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andReturn()
                .getResponse().getContentAsString();

        LancamentoResourceID lancamentoResourceID = new ObjectMapper().readValue(responseBodyJson, LancamentoResourceID.class);

        mvc.perform(get(LANCAMENTOS_CONTABEIS_PREFIX_URL+"/"+lancamentoResourceID.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testLancamento_getById_thenStatus404() throws Exception {
        mvc.perform(get(LANCAMENTOS_CONTABEIS_PREFIX_URL+"/a404")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message", CoreMatchers.equalTo("No value present")))
                .andExpect(jsonPath("$.type", CoreMatchers.equalTo("warning")));
    }

    @Test
    public void testLancamento_save_thenStatus400() throws Exception {

        LancamentoResource lancamentoResource = Fixture.from(LancamentoResource.class).gimme(LABEL_RESOURCES_LANCAMENTO_SEM_ID_E_DATA_NULL);
        lancamentoResource.setValor(BigDecimal.valueOf(0.00D));
        String json = new ObjectMapper().writeValueAsString(lancamentoResource);

        mvc.perform(post(LANCAMENTOS_CONTABEIS_PREFIX_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.valor", CoreMatchers.notNullValue()));
    }

    @Test
    public void testLancamento_getByContaContabil_thenStatus200() throws Exception {

        LancamentoResource lancamentoResource = Fixture.from(LancamentoResource.class).gimme(LABEL_RESOURCES_LANCAMENTO_SEM_ID_E_DATA_NULL);
        String json = new ObjectMapper().writeValueAsString(lancamentoResource);

        String responseBodyJson = mvc.perform(post(LANCAMENTOS_CONTABEIS_PREFIX_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andReturn()
                .getResponse().getContentAsString();

        LancamentoResourceID lancamentoResourceID = new ObjectMapper().readValue(responseBodyJson, LancamentoResourceID.class);

        mvc.perform(get(LANCAMENTOS_CONTABEIS_PREFIX_URL)
                    .param("contaContabil", String.valueOf(lancamentoResource.getContaContabil()))
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
    }

    @Test
    public void testLancamentoAggregate_WithoutContaContabil_thenStatus200() throws Exception {

        LancamentoResource lancamentoResource = Fixture.from(LancamentoResource.class).gimme(LABEL_RESOURCES_LANCAMENTO_SEM_ID_E_DATA_NULL);
        String json = new ObjectMapper().writeValueAsString(lancamentoResource);

        String responseBodyJson = mvc.perform(post(LANCAMENTOS_CONTABEIS_PREFIX_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andReturn()
                .getResponse().getContentAsString();

        mvc.perform(get(LANCAMENTOS_CONTABEIS_PREFIX_URL+"/stats")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.soma", greaterThan(1D)))
                .andExpect(jsonPath("$.minimo", greaterThan(1D)))
                .andExpect(jsonPath("$.maximo", greaterThan(1D)))
                .andExpect(jsonPath("$.media", greaterThan(1D)))
                .andExpect(jsonPath("$.quantidade", greaterThan(0)));
    }

    @Test
    public void testLancamentoAggregate_WithContaContabil_thenStatus200() throws Exception {

        LancamentoResource lancamentoResource = Fixture.from(LancamentoResource.class).gimme(LABEL_RESOURCES_LANCAMENTO_SEM_ID_E_DATA_NULL);
        String json = new ObjectMapper().writeValueAsString(lancamentoResource);

        String responseBodyJson = mvc.perform(post(LANCAMENTOS_CONTABEIS_PREFIX_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andReturn()
                .getResponse().getContentAsString();

        mvc.perform(get(LANCAMENTOS_CONTABEIS_PREFIX_URL+"/stats")
                .param("contaContabil", String.valueOf(lancamentoResource.getContaContabil()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.soma", greaterThan(1D)))
                .andExpect(jsonPath("$.minimo", greaterThan(1D)))
                .andExpect(jsonPath("$.maximo", greaterThan(1D)))
                .andExpect(jsonPath("$.media", greaterThan(1D)))
                .andExpect(jsonPath("$.quantidade", greaterThan(0)));
    }

    @Test
    public void testLancamentoAggregate_WithContaContabilThatNotExists_thenStatus200() throws Exception {
        mvc.perform(get(LANCAMENTOS_CONTABEIS_PREFIX_URL+"/stats")
                .param("contaContabil", String.valueOf(UUID.randomUUID().getLeastSignificantBits()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.soma", is(0D)))
                .andExpect(jsonPath("$.minimo", is(0D)))
                .andExpect(jsonPath("$.maximo", is(0D)))
                .andExpect(jsonPath("$.media", is(0D)))
                .andExpect(jsonPath("$.quantidade", is(0)));
    }

}
