package desafio.desafio.modulo.itensproduto.service;

import desafio.desafio.modulo.itensproduto.model.ItemProduto;
import desafio.desafio.modulo.itensproduto.repository.ItensProdutoRepository;
import desafio.desafio.modulo.servicoproduto.model.ServicoProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ItensProdutoService {

    @Autowired
    ItensProdutoRepository itensProdutoRepository;

    public ItemProduto cadastraItensProduto(ItemProduto itemPedido){
        return itensProdutoRepository.save(itemPedido);
    }

    public ItemProduto editaItemPedido(ItemProduto itemPedido){
        return itensProdutoRepository.save(itemPedido);
    }

    public List<ItemProduto> resgataItensPedido(){
        return (List<ItemProduto>) itensProdutoRepository.findAll();
    }

    public ItemProduto resgataItemPedido(UUID id){
        return itensProdutoRepository.getById(id);
    }

    public Page<ItemProduto> paginacaoItensProduto(Pageable pageable){
        return itensProdutoRepository.findAll(pageable);
    }
}
