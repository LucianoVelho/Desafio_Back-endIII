package desafio.desafio.modulo.itensproduto.repository;

import desafio.desafio.modulo.itensproduto.model.ItemProduto;
import desafio.desafio.modulo.servicoproduto.model.ServicoProduto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.UUID;

public interface ItemProdutoRepository extends PagingAndSortingRepository<ItemProduto, UUID> {
    ItemProduto getById(UUID id);
    List<ItemProduto> findAllByOrderByIdAsc();
}
