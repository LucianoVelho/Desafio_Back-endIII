package desafio.desafio.modulo.itensproduto.repository;

import desafio.desafio.modulo.itensproduto.model.ItemPedido;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface itensProdutoRepository extends CrudRepository<ItemPedido, UUID> {

}
