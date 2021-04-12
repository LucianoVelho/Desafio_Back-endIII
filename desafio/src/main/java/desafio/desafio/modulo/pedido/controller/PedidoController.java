package desafio.desafio.modulo.pedido.controller;

import desafio.desafio.modulo.pedido.model.Pedido;
import desafio.desafio.modulo.pedido.repository.PedidoRepository;
import desafio.desafio.modulo.pedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @PostMapping(value = "/pedido", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> cadastraPedido (@RequestBody Pedido pedido)  {
        return new ResponseEntity<>(pedidoService.cadastraPedido(pedido), HttpStatus.OK);
    }

    @PostMapping(value = "/pedido/desconto/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> cadastraPedido (@PathVariable(value = "id", required = false) UUID id)  {
        return new ResponseEntity<>(pedidoService.desconto(id), HttpStatus.OK);
    }

    @PutMapping(value = "/pedido", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> editaPedido (@RequestBody Pedido pedido) {
        return new ResponseEntity<>(pedidoService.editaPedido(pedido), HttpStatus.OK);
    }

    @GetMapping(value = "/pedido", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> resgataPedidos ()  {
        return new ResponseEntity<>( pedidoService.resgastaPedidos(),HttpStatus.OK);
    }
    @GetMapping(value = "/pedido/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> desativaServicoProduto (
            @PathVariable(value = "id", required = false) UUID id) {
        return new ResponseEntity<>(pedidoService.resgataPedido(id), HttpStatus.OK);
    }
    @GetMapping(value = "/pedido/paginacao", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> paginacaoPedidos (Pageable pageable)  {
        return new ResponseEntity<>( pedidoService.paginacaoPedido(pageable),HttpStatus.OK);
    }
}
