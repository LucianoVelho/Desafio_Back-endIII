package desafio.desafio.modulo.itensproduto.service;

import desafio.desafio.modulo.itensproduto.model.ItemProduto;
import desafio.desafio.modulo.itensproduto.repository.ItemProdutoRepository;
import desafio.desafio.modulo.pedido.model.Pedido;
import desafio.desafio.modulo.pedido.repository.PedidoRepository;
import desafio.desafio.modulo.servicoproduto.model.ServicoProduto;
import desafio.desafio.modulo.servicoproduto.repository.ServicoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ItensProdutoService {

    @Autowired
    ItemProdutoRepository itensProdutoRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ServicoProdutoRepository servicoProdutoRepository;

    public ItemProduto cadastraItensProduto(ItemProduto itemPedido){
        List<ServicoProduto> sProdutosAtivados =  new ArrayList<>();
        for(ServicoProduto sp : itemPedido.getItensPedido() ){
            ServicoProduto spb = servicoProdutoRepository.getById(sp.getId());
            if(spb.isEstado())
                sProdutosAtivados.add(spb);
        }
        itemPedido.setItensPedido(sProdutosAtivados);
        return itensProdutoRepository.save(itemPedido);
    }

    public ItemProduto editaItemPedido(ItemProduto itemPedido){
        return itensProdutoRepository.save(itemPedido);
    }

    public List<ItemProduto> resgataItensPedido(){
        return (List<ItemProduto>) itensProdutoRepository.findAll();
    }

    public ItemProduto resgataItemPedidoId(UUID id){
        return itensProdutoRepository.getById(id);
    }

    public String deletaItensPedido(UUID id){
       if(pedidoRepository.getByItemPedido(resgataItemPedidoId(id)) != null){
           return "Item Pedido nao pode ser deletado";
       }else {
           itensProdutoRepository.delete(itensProdutoRepository.getById(id));
           return "Item Pedido deletado";
       }
    }

    public Page<ItemProduto> paginacaoItensProduto(Pageable pageable){
        return itensProdutoRepository.findAll(pageable);
    }
}
