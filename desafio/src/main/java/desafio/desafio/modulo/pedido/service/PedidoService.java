package desafio.desafio.modulo.pedido.service;

import desafio.desafio.modulo.itensproduto.model.ItemProduto;
import desafio.desafio.modulo.itensproduto.repository.ItemProdutoRepository;
import desafio.desafio.modulo.pedido.model.Pedido;
import desafio.desafio.modulo.pedido.repository.PedidoRepository;
import desafio.desafio.modulo.servicoproduto.model.ServicoProduto;
import desafio.desafio.modulo.servicoproduto.model.Tipo;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ItemProdutoRepository itemProdutoRepository;

    public Pedido cadastraPedido(Pedido pedido){

        List<ItemProduto> itemProduto = new ArrayList<>();
        for(ItemProduto it : pedido.getItemPedido()) {
            itemProduto.add(itemProdutoRepository.getById(it.getId()));
            for (ServicoProduto s : itemProdutoRepository.getById(it.getId()).getItensPedido()) {
                if (Tipo.SERVICO == s.getTipo()) {
                    pedido.setValorServico(pedido.getValorServico() + s.getValor());
                } else {
                    pedido.setValorPedido(pedido.getValorPedido() + s.getValor());
                }
            }
        }
        pedido.setItemPedido(itemProduto);
        pedido.setTotal(pedido.getValorPedido() + pedido.getValorServico());
        return pedidoRepository.save(pedido);
    }

    public Pedido editaPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> resgastaPedidos(){
        return (List<Pedido>) pedidoRepository.findAll();
    }

    public Pedido resgataPedido(UUID id){
        return pedidoRepository.getById(id);
    }

    public JSONObject deletaPedido(UUID id){
        JSONObject js = new JSONObject();
        Pedido p =pedidoRepository.getById(id);
        if(p.isEstado() == false){
            pedidoRepository.delete(p);
            js.put("messagem","Pedido Deletado");
        }else {
           js.put("messagem","Para deletar este pedido deve se feichalo");
        }
        return js;
    }

    public Page<Pedido> paginacaoPedido(Pageable pageable){
        Page<Pedido> pedidos = pedidoRepository.findAll(pageable);
        return pedidos;
    }
    public Pedido fecharPedido(UUID id){
        Pedido pedido = pedidoRepository.getById(id);
        pedido.setEstado(false);
        return pedidoRepository.save(pedido);
    }

    public Pedido desconto(UUID id){
        Pedido pedido = pedidoRepository.getById(id);
        if (pedido.isEstado() == false)
           throw new DataIntegrityViolationException("O pedido se encontra fechado");
        pedido.setValorPedido(pedido.getValorPedido() - (pedido.getValorPedido()*0.1));
        pedido.setTotal(pedido.getValorPedido() + pedido.getValorServico());
        return pedidoRepository.save(pedido);
    }
}
