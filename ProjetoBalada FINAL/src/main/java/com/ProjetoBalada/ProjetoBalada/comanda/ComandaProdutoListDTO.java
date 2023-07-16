package com.ProjetoBalada.ProjetoBalada.comanda;

import com.ProjetoBalada.ProjetoBalada.comanda.enums.ProdutoEnum;

public class ComandaProdutoListDTO {

    private Long comandaId;
    private Long quantidade;
    private ProdutoEnum tipo;
    private Double valor;
    private Boolean ativo;

    public Long getComandaId() {
        return comandaId;
    }

    public void setComandaId(Long comandaId) {
        this.comandaId = comandaId;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public ProdutoEnum getTipo() {
        return tipo;
    }

    public void setTipo(ProdutoEnum tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public ComandaProdutoListDTO(ComandaProduto comandaProduto) {
        this.comandaId = comandaProduto.getComanda().getId();
        this.quantidade = comandaProduto.getQuantidade();
        this.tipo = comandaProduto.getTipo();
        this.valor = comandaProduto.getValor();
        this.ativo = comandaProduto.getAtivo();
    }
}