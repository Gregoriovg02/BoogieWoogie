package com.ProjetoBalada.ProjetoBalada.comanda;

import com.ProjetoBalada.ProjetoBalada.comanda.enums.ProdutoEnum;

public class CreateComandaProdutoDTO {

   private Long comandaId;
   private ProdutoEnum tipo;
   private Long quantidade;
   private Double valor;

public Long getComandaId() {
    return comandaId;
}
public void setComandaId(Long comandaId) {
    this.comandaId = comandaId;
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

   
}
