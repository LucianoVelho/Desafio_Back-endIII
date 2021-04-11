package desafio.desafio.modulo.servicoproduto.repository;


import desafio.desafio.modulo.servicoproduto.model.ServicoProduto;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface ServicoProdutoRepository extends PagingAndSortingRepository<ServicoProduto, UUID> {
    ServicoProduto getById(UUID id);
}
