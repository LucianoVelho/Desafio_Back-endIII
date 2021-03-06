package desafio.desafio.modulo.servicoproduto.model;

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

    @NotNull
    @Column(name = "estado")
    private boolean estado;

    @NotNull
    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @NotNull
    @Column(name = "valor")
    private double valor;

    public ServicoProduto() {
    }

    public ServicoProduto(UUID id, @NotNull @NotEmpty @Size(max = 50) String nome, @NotNull @NotEmpty @Size(max = 100) String descricao, @NotNull boolean estado, @NotNull Tipo tipo, @NotNull double valor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.estado = estado;
        this.tipo = tipo;
        this.valor = valor;
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

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
