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

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ItensProdutoController {

    @Autowired
    ItensProdutoService itensProdutoService;

    @PostMapping(value = "/itensproduto", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> casdastraItensProduto (
            @RequestBody ItemProduto itemProduto ) throws Exception {
        return new ResponseEntity<>(itensProdutoService.cadastraItensProduto(itemProduto), HttpStatus.OK);
    }

    @PutMapping(value = "/itensproduto", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> editaItensProduto (
            @RequestBody ItemProduto itemProduto ) throws Exception {
        return new ResponseEntity<>(itensProdutoService.editaItemPedido(itemProduto), HttpStatus.OK);
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
