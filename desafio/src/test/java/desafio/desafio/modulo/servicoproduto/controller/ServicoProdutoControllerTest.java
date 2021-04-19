package desafio.desafio.modulo.servicoproduto.controller;

import desafio.desafio.modulo.servicoproduto.model.ServicoProduto;
import desafio.desafio.modulo.servicoproduto.repository.ServicoProdutoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class ServicoProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ServicoProdutoRepository servicoProdutoRepository;

    @Test
    void casdastraServicoProdutoProdutoTest() throws Exception {

        URI uri = new URI("http://localhost:8080/api/servicoproduto");
        String json = "{\n" +
                "  \"nome\": \"pasta de dente\",\n" +
                "  \"descricao\": \"sabor hortela tripla acao\",\n" +
                "  \"tipo\":\"PRODUTO\",\n" +
                "  \"estado\": true,\n" +
                "  \"valor\": 2.75\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders
                .post(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is(200));

    }

    @Test
    void casdastraServicoProdutoServicoTest() throws Exception {

        URI uri = new URI("http://localhost:8080/api/servicoproduto");
        String json = "{\n" +
                "  \"nome\": \"desntista\",\n" +
                "  \"descricao\": \"Limpeza dos dentes\",\n" +
                "  \"tipo\":\"SERVICO\",\n" +
                "  \"estado\": true,\n" +
                "  \"valor\": 60\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders
                .post(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is(200));

    }
    @Test
    void casdastraServicoProdutoComNomeVazio() throws Exception {

        URI uri = new URI("http://localhost:8080/api/servicoproduto");
        String json = "{\n" +
                "  \"nome\": \"\",\n" +
                "  \"descricao\": \"Teste Nome Vazio\",\n" +
                "  \"tipo\":\"SERVICO\",\n" +
                "  \"estado\": true,\n" +
                "  \"valor\": 60\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders
                .post(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is(400));

    }

    @Test
    void editaServicoProdutoTest() throws Exception {

        List<ServicoProduto> servicoProdutos = servicoProdutoRepository.findAllByOrderByIdAsc();
        UUID id = servicoProdutos.get(0).getId();
        URI uri = new URI("http://localhost:8080/api/servicoproduto");
        String json = "{\n" +
                "    \"id\": \""+id.toString()+"\",\n" +
                "    \"nome\": \"destista\",\n" +
                "    \"descricao\": \"manuten\",\n" +
                "    \"estado\": true,\n" +
                "    \"tipo\": \"SERVICO\",\n" +
                "    \"valor\": 2.75\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders
                .put(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void desativaServicoProdutoTest() throws Exception {
        List<ServicoProduto> servicoProdutos = servicoProdutoRepository.findAllByOrderByIdAsc();
        UUID id = servicoProdutos.get(0).getId();
        URI uri = new URI("http://localhost:8080/api/servicoproduto/"+id.toString());

        mockMvc.perform(MockMvcRequestBuilders
                .delete(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void resgataServicosProdutosTest() throws Exception {

        URI uri = new URI("http://localhost:8080/api/servicoproduto");

        mockMvc.perform(MockMvcRequestBuilders
                .get(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void resgataServicoProdutoIdTest() throws Exception {
        List<ServicoProduto> servicoProdutos = servicoProdutoRepository.findAllByOrderByIdAsc();
        UUID id = servicoProdutos.get(0).getId();
        URI uri = new URI("http://localhost:8080/api/servicoproduto/"+id.toString());

        mockMvc.perform(MockMvcRequestBuilders
                .get(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void paginacaoServicoProdutoTest() throws Exception {

        URI uri = new URI("http://localhost:8080/api/servicoproduto?page=0&size3&sort=id.desc");

        mockMvc.perform(MockMvcRequestBuilders
                .get(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }
}