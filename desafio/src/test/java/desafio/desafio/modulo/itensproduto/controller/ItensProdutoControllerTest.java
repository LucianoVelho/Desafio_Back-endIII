package desafio.desafio.modulo.itensproduto.controller;

import desafio.desafio.modulo.itensproduto.repository.ItemProdutoRepository;
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
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ItensProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ServicoProdutoRepository servicoProdutoRepository;

    @Autowired
    private ItemProdutoRepository itemProdutoRepository;

    @Test
    void casdastraItensProdutoTeste() throws Exception {

        UUID id = servicoProdutoRepository.findAllByOrderByIdAsc().get(0).getId();

        URI uri = new URI("http://localhost:8080/api/itensproduto");
        String json = "{\n" +
                "  \n" +
                "  \"itensPedido\":[    \n" +
                "    {\n" +
                "        \"id\": \""+id.toString()+"\"\n" +
                "       \n" +
                "    }\n" +
                "\n" +
                "]\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders
                .post(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }
    @Test
    void casdastraItensProdutoVazioTeste() throws Exception {

        URI uri = new URI("http://localhost:8080/api/itensproduto");
        String json = "{\n" +
                "  \n" +
                "  \"itensPedido\":[    \n" +
                "   \n" +
                "\n" +
                "]\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders
                .post(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void editaItensProduto() throws Exception {
        URI uri = new URI("http://localhost:8080/api/itensproduto");
        String json = "{\n" +
                "        \"id\": \""+itemProdutoRepository.findAllByOrderByIdAsc().get(0).getId().toString()+"\",\n" +
                "        \"itensPedido\": [\n" +
                "            {\n" +
                "                \"id\": \""+servicoProdutoRepository.findAllByOrderByIdAsc().get(0).getId().toString()+"\",\n" +
                "                \"nome\": \"pasta de dente\",\n" +
                "                \"descricao\": \"sabor hortela tripla acao\",\n" +
                "                \"estado\": true,\n" +
                "                \"tipo\": \"PRODUTO\",\n" +
                "                \"valor\": 2.75\n" +
                "            },\n" +
                "        ]\n" +
                "    }";

        mockMvc.perform(MockMvcRequestBuilders
                .put(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void desativaPedido() {

    }

    @Test
    void resgataItensProdutoTest() throws Exception {
        URI uri = new URI("http://localhost:8080/api/itensproduto");

        mockMvc.perform(MockMvcRequestBuilders
                .get(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void resgataItensProdutoIdTest() throws Exception {
        UUID id = servicoProdutoRepository.findAllByOrderByIdAsc().get(0).getId();
        URI uri = new URI("http://localhost:8080/api/itensproduto/"+id.toString());

        mockMvc.perform(MockMvcRequestBuilders
                .get(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void paginacaoItensProduto() throws Exception {

        URI uri = new URI("http://localhost:8080/api/itensproduto?page=0&size3&sort=id.desc");


        mockMvc.perform(MockMvcRequestBuilders
                .get(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }
}