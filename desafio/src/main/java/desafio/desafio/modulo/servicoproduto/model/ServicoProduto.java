package desafio.desafio.modulo.servicoproduto.model;

import desafio.desafio.modulo.itensproduto.model.ItemPedido;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "servico_produto")
public class ServicoProduto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @NotNull
    @NotEmpty
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;

    @NotNull @NotEmpty @Size(max = 100)
    @Column(name = "descricao")
    private String descricao;

    @NotNull @NotEmpty
    @Column(name = "estado")
    private boolean estado;

    @NotNull @NotEmpty
    @Column(name = "valor")
    private double valor;

    @OneToOne
    private ItemPedido itemPedido;

    public ServicoProduto() {
    }

    public ServicoProduto(UUID id, @NotNull @NotEmpty @Size(max = 50) String nome, @NotNull @NotEmpty @Size(max = 100) String descricao, @NotNull @NotEmpty boolean estado, @NotNull @NotEmpty double valor, ItemPedido itemPedido) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.estado = estado;
        this.valor = valor;
        this.itemPedido = itemPedido;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public ItemPedido getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(ItemPedido itemPedido) {
        this.itemPedido = itemPedido;
    }
}
