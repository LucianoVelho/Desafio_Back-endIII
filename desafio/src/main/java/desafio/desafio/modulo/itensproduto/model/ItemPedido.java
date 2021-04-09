package desafio.desafio.modulo.itensproduto.model;

import desafio.desafio.modulo.pedido.model.Pedido;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "item_pedido")
public class ItemPedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Pedido> itensPedido = new ArrayList<>();

    public ItemPedido() {

    }

    public ItemPedido(UUID id, List<Pedido> itensPedido) {
        this.id = id;
        this.itensPedido = itensPedido;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Pedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<Pedido> itensPedido) {
        this.itensPedido = itensPedido;
    }
}
