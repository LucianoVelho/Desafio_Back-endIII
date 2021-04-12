package desafio.desafio.modulo.pedido.service;

import desafio.desafio.modulo.itensproduto.model.ItemProduto;
import desafio.desafio.modulo.pedido.model.Pedido;
import desafio.desafio.modulo.pedido.repository.PedidoRepository;
import desafio.desafio.modulo.servicoproduto.model.ServicoProduto;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public Pedido cadastraPedido(Pedido pedido){
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

    public Page<Pedido> paginacaoPedido(Pageable pageable){
        Page<Pedido> pedidos = pedidoRepository.findAll(pageable);
        return null;
    }

    public Pedido desconto(UUID id){
        Pedido pedido = pedidoRepository.getById(id);
        if (pedido.isEstado() == false)
           throw new DataIntegrityViolationException("O pedido se encontra fechado");
        pedido.setValorPedido(pedido.getValorPedido() - (pedido.getValorPedido()*0.1));
        return pedidoRepository.save(pedido);
    }
}
