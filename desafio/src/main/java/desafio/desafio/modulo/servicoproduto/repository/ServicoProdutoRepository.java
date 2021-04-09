package desafio.desafio.modulo.servicoproduto.repository;

import desafio.desafio.modulo.servicoproduto.model.ServicoProduto;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ServicoProdutoRepository extends CrudRepository<ServicoProduto, UUID> {
}
