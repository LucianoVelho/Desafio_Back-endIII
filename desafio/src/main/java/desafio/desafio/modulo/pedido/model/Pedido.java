package desafio.desafio.modulo.pedido.model;

import desafio.desafio.modulo.itensproduto.model.ItemPedido;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
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
    @NotEmpty
    @Column(name = "estado")
    private boolean estado;

    @NotNull @NotEmpty
    @Column(name = "valor_pedido")
    private double valorPedido;

    @NotNull @NotEmpty
    @Column(name = "valor_servico")
    private double valorServico;

    @NotNull @NotEmpty
    @Column(name = "total")
    private double total;

    @NotNull @NotEmpty
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<ItemPedido> itensPedido = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(UUID id, @NotNull @NotEmpty boolean estado, @NotNull @NotEmpty double valorPedido, @NotNull @NotEmpty double valorServico, @NotNull @NotEmpty double total, @NotNull @NotEmpty List<ItemPedido> itensPedido) {
        this.id = id;
        this.estado = estado;
        this.valorPedido = valorPedido;
        this.valorServico = valorServico;
        this.total = total;
        this.itensPedido = itensPedido;
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

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }
}
