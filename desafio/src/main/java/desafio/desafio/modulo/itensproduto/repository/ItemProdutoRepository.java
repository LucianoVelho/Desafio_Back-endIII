package desafio.desafio.modulo.itensproduto.repository;

import desafio.desafio.modulo.itensproduto.model.ItemProduto;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface ItemProdutoRepository extends PagingAndSortingRepository<ItemProduto, UUID> {
    ItemProduto getById(UUID id);
}
