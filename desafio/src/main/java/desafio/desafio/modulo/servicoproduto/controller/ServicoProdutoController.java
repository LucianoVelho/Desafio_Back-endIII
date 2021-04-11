package desafio.desafio.modulo.servicoproduto.controller;

import desafio.desafio.modulo.servicoproduto.model.ServicoProduto;
import desafio.desafio.modulo.servicoproduto.service.ServicoProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ServicoProdutoController {

    @Autowired
    ServicoProdutoService servicoProdutoService;

    @PostMapping(value = "/servicoproduto", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> casdastraServicoProduto (
            @RequestBody ServicoProduto servicoProduto) throws Exception {
        return new ResponseEntity<>(servicoProdutoService.cadastraServicoProduto(servicoProduto), HttpStatus.OK);
    }

    @PutMapping(value = "/servicoproduto", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> editaServicoProduto (
            @RequestBody ServicoProduto servicoProduto) throws Exception {
        return new ResponseEntity<>(servicoProdutoService.editaServicoProduto(servicoProduto), HttpStatus.OK);
    }
    @DeleteMapping(value = "/servicoproduto", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> desativaServicoProduto (
            @RequestParam(value = "id", required = false) UUID id) throws Exception {
        servicoProdutoService.desativaServicoProduto(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @GetMapping(value = "/servicoproduto", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> resgataServicosProdutos () throws Exception {
        return new ResponseEntity<>(servicoProdutoService.resgataTodos(), HttpStatus.OK);
    }

    @GetMapping(value = "/servicoproduto/paginacao", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> paginacaoServicoProduto (Pageable pageable) throws Exception {
        return new ResponseEntity<>(servicoProdutoService.paginacaoServivoProduto(pageable), HttpStatus.OK);
    }
}
