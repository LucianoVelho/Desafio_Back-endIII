package desafio.desafio.modulo.servicoproduto.repository;

import desafio.desafio.modulo.servicoproduto.model.ServicoProduto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface ServicoProdutoRepository extends PagingAndSortingRepository<ServicoProduto, UUID> {
    ServicoProduto getById(UUID id);
}
