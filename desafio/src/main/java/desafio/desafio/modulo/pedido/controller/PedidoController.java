package desafio.desafio.modulo.pedido.controller;

import desafio.desafio.modulo.itensproduto.model.ItemProduto;
import desafio.desafio.modulo.pedido.model.Pedido;
import desafio.desafio.modulo.pedido.repository.PedidoRepository;
import desafio.desafio.modulo.pedido.service.PedidoService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @PostMapping(value = "/pedido", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> cadastraPedido (@RequestBody @Valid Pedido pedido)  {
        return new ResponseEntity<>(pedidoService.cadastraPedido(pedido), HttpStatus.OK);
    }

    @PutMapping(value = "/pedido/desconto/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> aplicaDescontoPedido (@PathVariable(value = "id", required = false) UUID id)  {
        return new ResponseEntity<>(pedidoService.desconto(id), HttpStatus.OK);
    }

    @PutMapping(value = "/pedido", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> editaPedido (@RequestBody @Valid Pedido pedido) {
        return new ResponseEntity<>(pedidoService.editaPedido(pedido), HttpStatus.OK);
    }

    @PutMapping(value = "/pedido/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> fechaPedido (
            @PathVariable(value = "id", required = false) UUID id )  {
        return new ResponseEntity<>( pedidoService.fecharPedido(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/pedido/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deletaPedido (
            @PathVariable(value = "id", required = false) UUID id) {
        JSONObject js = pedidoService.deletaPedido(id);
        return new ResponseEntity<>( js, HttpStatus.OK);
    }

    @GetMapping(value = "/pedido", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> resgataPedidos ()  {
        return new ResponseEntity<>( pedidoService.resgastaPedidos(),HttpStatus.OK);
    }
    @GetMapping(value = "/pedido/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> ResgataPedidoId (
            @PathVariable(value = "id", required = false) UUID id) {
        return new ResponseEntity<>(pedidoService.resgataPedido(id), HttpStatus.OK);
    }
    @GetMapping(value = "/pedido/paginacao", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> paginacaoPedidos (Pageable pageable)  {
        return new ResponseEntity<>( pedidoService.paginacaoPedido(pageable),HttpStatus.OK);
    }
}
