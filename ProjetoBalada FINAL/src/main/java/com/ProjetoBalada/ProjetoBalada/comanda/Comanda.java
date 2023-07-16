package com.ProjetoBalada.ProjetoBalada.comanda;

import java.util.Date;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.ProjetoBalada.ProjetoBalada.cliente.Cliente;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "comanda")
public class Comanda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date criadoEm;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date modificadoEm;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true)
    private Date fechadoEm;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @JsonManagedReference
    @OneToMany(mappedBy = "comanda", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ComandaProduto> comandaProdutos;

    private Boolean ativo;
    
      public void excluir() {
        this.ativo = false;
    }

    public void ativar(){
        this.ativo = true;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(Date criadoEm) {
        this.criadoEm = criadoEm;
    }

    public Date getModificadoEm() {
        return modificadoEm;
    }

    public void setModificadoEm(Date modificadoEm) {
        this.modificadoEm = modificadoEm;
    }

    public Date getFechadoEm() {
        return fechadoEm;
    }

    public void setFechadoEm(Date fechadoEm) {
        this.fechadoEm = fechadoEm;
    }

    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="comanda")
    public Set<ComandaProduto> getComandaProdutos() {
        return comandaProdutos;
    }

    public void setComandaProdutos(Set<ComandaProduto> comandaProdutos) {
        this.comandaProdutos = comandaProdutos;
    }


}