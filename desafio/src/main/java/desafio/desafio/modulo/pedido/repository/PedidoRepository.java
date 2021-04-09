package desafio.desafio.modulo.pedido.repository;

import desafio.desafio.modulo.pedido.model.Pedido;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PedidoRepository extends CrudRepository<Pedido, UUID> {
}
