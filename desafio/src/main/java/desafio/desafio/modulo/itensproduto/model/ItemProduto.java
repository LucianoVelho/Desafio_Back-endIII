package desafio.desafio.modulo.itensproduto.model;

import desafio.desafio.modulo.pedido.model.Pedido;
import desafio.desafio.modulo.servicoproduto.model.ServicoProduto;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "item_pedido")
public class ItemProduto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @NotNull
    @NotEmpty
    @ManyToMany
    @JoinTable(
            name = "servico_produto_item_pedido",
            joinColumns = @JoinColumn(name = "servico_produto_id"),
            inverseJoinColumns = @JoinColumn(name = "item_pedido_id"))
    private List<ServicoProduto> itensPedido = new ArrayList<>();

    public ItemProduto() {

    }

    public ItemProduto(Iterable<ServicoProduto> all) {

    }

    public ItemProduto(UUID id, List<ServicoProduto> itensPedido) {
        this.id = id;
        this.itensPedido = itensPedido;
    }

    public List<ServicoProduto> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ServicoProduto> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


}
