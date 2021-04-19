package desafio.desafio.modulo.pedido.repository;

import desafio.desafio.modulo.itensproduto.model.ItemProduto;
import desafio.desafio.modulo.pedido.model.Pedido;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.List;
import java.util.UUID;

public interface PedidoRepository extends PagingAndSortingRepository<Pedido, UUID> {

    Pedido getById(UUID id);
    Pedido getByItemPedido(ItemProduto itemProduto);
    List<Pedido> findAllByOrderByIdAsc();
}
