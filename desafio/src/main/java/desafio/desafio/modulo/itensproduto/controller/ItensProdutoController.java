package desafio.desafio.modulo.itensproduto.controller;

import desafio.desafio.modulo.itensproduto.model.ItemProduto;
import desafio.desafio.modulo.itensproduto.service.ItensProdutoService;
import desafio.desafio.modulo.servicoproduto.model.ServicoProduto;
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
public class ItensProdutoController {

    @Autowired
    ItensProdutoService itensProdutoService;

    @PostMapping(value = "/itensproduto", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> casdastraItensProduto (
            @RequestBody @Valid ItemProduto itemProduto ) throws Exception {
        return new ResponseEntity<>(itensProdutoService.cadastraItensProduto(itemProduto), HttpStatus.OK);
    }

    @PutMapping(value = "/itensproduto", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> editaItensProduto (
            @RequestBody @Valid ItemProduto itemProduto ) throws Exception {
        return new ResponseEntity<>(itensProdutoService.editaItemPedido(itemProduto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/itensproduto/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> desativaPedido (
            @PathVariable(value = "id", required = false) UUID id) {
        return new ResponseEntity<>( itensProdutoService.deletaItensPedido(id),HttpStatus.OK);
    }

    @GetMapping(value = "/itensproduto/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> resgataItensProdutoId (
            @PathVariable(value = "id", required = false) UUID id) {
        return new ResponseEntity<>( itensProdutoService.resgataItemPedidoId(id),HttpStatus.OK);
    }

    @GetMapping(value = "/itensproduto", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> resgataItensProduto () throws Exception {
        return new ResponseEntity<>(itensProdutoService.resgataItensPedido(), HttpStatus.OK);
    }

    @GetMapping(value = "/itensproduto/paginacao", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> paginacaoItensProduto (Pageable pageable) throws Exception {
        return new ResponseEntity<>(itensProdutoService.paginacaoItensProduto(pageable), HttpStatus.OK);
    }
}
