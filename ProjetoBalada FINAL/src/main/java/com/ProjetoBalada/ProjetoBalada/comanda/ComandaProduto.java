package com.ProjetoBalada.ProjetoBalada.comanda;

import com.ProjetoBalada.ProjetoBalada.comanda.enums.ProdutoEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "comanda_produto")
public class ComandaProduto {

    @Override
    public String toString() {
        return "ComandaProduto [id=" + id + ", comanda=" + comanda + ", tipo=" + tipo + ", quantidade=" + quantidade
                + ", valor=" + valor + ", ativo=" + ativo + "]";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "comanda_id", nullable = false)
    private Comanda comanda;

    

    public ComandaProduto(Long id, Comanda comanda, ProdutoEnum tipo, Long quantidade, Double valor, Boolean ativo) {
        this.id = id;
        this.comanda = comanda;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.valor = valor;
        this.ativo = ativo;
    }

    @Column(nullable = false)
    ProdutoEnum tipo;

    @Column(nullable = false)
    Long quantidade;

    @Column(nullable = false)
    Double valor;

    private Boolean ativo;

   
    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }


    public ComandaProduto() {
    }

    public ComandaProduto(Long id,Comanda comanda, ProdutoEnum tipo, Long quantidade, Double valor) {
        this.id = id;
        this.comanda = comanda;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.valor = valor;
        this.ativo = ativo;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public ProdutoEnum getTipo() {
        return tipo;
    }

    public void setTipo(ProdutoEnum tipo) {
        this.tipo = tipo;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    public void excluir() {
        this.ativo = false;
    }

}
