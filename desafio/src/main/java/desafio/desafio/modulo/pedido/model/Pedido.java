package desafio.desafio.modulo.pedido.model;

import desafio.desafio.modulo.itensproduto.model.ItemProduto;
import desafio.desafio.modulo.servicoproduto.model.ServicoProduto;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @NotNull
    @Column(name = "estado")
    private boolean estado;

    @NotNull
    @Column(name = "valor_pedido")
    private double valorPedido;

    @NotNull
    @Column(name = "valor_servico")
    private double valorServico;

    @NotNull
    @Column(name = "total")
    private double total;

    @NotNull @NotEmpty
    @ManyToMany
    @JoinTable(
            name = "item_pedido_pedido",
            joinColumns = @JoinColumn(name = "item_pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "pedido_id"))
    private List<ItemProduto> itemPedido ;

    public Pedido() {

    }

    public Pedido(boolean b, List<ItemProduto> itemPedido) {
    }

    public Pedido(UUID id, @NotNull boolean estado, @NotNull double valorPedido, @NotNull double valorServico, @NotNull double total, @NotNull List<ItemProduto> itemPedido) {
        this.id = id;
        this.estado = estado;
        this.valorPedido = valorPedido;
        this.valorServico = valorServico;
        this.total = total;
        this.itemPedido = itemPedido;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(double valorPedido) {
        this.valorPedido = valorPedido;
    }

    public double getValorServico() {
        return valorServico;
    }

    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<ItemProduto> getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(List<ItemProduto> itemPedido) {
        this.itemPedido = itemPedido;
    }
}
