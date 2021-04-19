package desafio.desafio.modulo.pedido.controller;

import desafio.desafio.modulo.itensproduto.repository.ItemProdutoRepository;
import desafio.desafio.modulo.pedido.repository.PedidoRepository;
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
class PedidoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemProdutoRepository itemProdutoRepository;

    @Test
    void cadastraPedidoTest() throws Exception {

        UUID id  = itemProdutoRepository.findAllByOrderByIdAsc().get(0).getId();

        URI uri = new URI("http://localhost:8080/api/pedido");
        String json = "{\n" +
                "  \"estado\": true,\n" +
                "  \"itemPedido\": [ {\n" +
                "        \"id\": \""+id.toString()+"\"\n" +
                "    }],\n" +
                "  \"total\": 0,\n" +
                "  \"valorPedido\": 0,\n" +
                "  \"valorServico\": 0\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders
                .post(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void aplicaDescontoPedido() throws Exception {

        UUID idPedido  = pedidoRepository.findAllByOrderByIdAsc().get(0).getId();

        URI uri = new URI("http://localhost:8080/api/pedido/"+idPedido.toString());

        mockMvc.perform(MockMvcRequestBuilders
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void editaPedido() throws Exception {
        UUID idPedido  = pedidoRepository.findAllByOrderByIdAsc().get(0).getId();
        UUID idServico  = pedidoRepository.findAllByOrderByIdAsc().get(0).getItemPedido().get(0).getId();

        URI uri = new URI("http://localhost:8080/api/pedido");
        String json = "{\n" +
                "    \"id\": \""+idPedido.toString()+"\",\n" +
                "    \"estado\": true,\n" +
                "    \"valorPedido\": 2.75,\n" +
                "    \"valorServico\": 60,\n" +
                "    \"total\": 62.75,\n" +
                "    \"itemPedido\": [\n" +
                "        {\n" +
                "            \"id\": \""+idServico.toString()+"\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders
                .post(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void desativaPedido() {
    }

    @Test
    void resgataPedidos() throws Exception {

        URI uri = new URI("http://localhost:8080/api/pedido");

        mockMvc.perform(MockMvcRequestBuilders
                .get(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void resgataPedidoId() throws Exception {

        UUID id  = pedidoRepository.findAllByOrderByIdAsc().get(0).getId();

        URI uri = new URI("http://localhost:8080/api/pedido/"+id.toString());

        mockMvc.perform(MockMvcRequestBuilders
                .get(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is(200));

    }

    @Test
    void paginacaoPedidos() throws Exception {
        URI uri = new URI("http://localhost:8080/api/pedido?page=0&size3&sort=id.desc");

        mockMvc.perform(MockMvcRequestBuilders
                .get(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }
}