package desafio.desafio.modulo.servicoproduto.repository;

import desafio.desafio.modulo.servicoproduto.model.ServicoProduto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.Select;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.UUID;

public interface ServicoProdutoRepository extends PagingAndSortingRepository<ServicoProduto, UUID> {
    ServicoProduto getById(UUID id);
}
