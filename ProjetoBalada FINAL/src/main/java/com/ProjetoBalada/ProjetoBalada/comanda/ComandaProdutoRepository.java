package com.ProjetoBalada.ProjetoBalada.comanda;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ProjetoBalada.ProjetoBalada.cliente.Cliente;



@Repository
public interface ComandaProdutoRepository extends JpaRepository <ComandaProduto, Long>{

    @Query(value = "SELECT a.* FROM projetobalada.comanda_produto a WHERE a.ativo = 1", nativeQuery = true)
    List<ComandaProduto> findByAtivos();

     Optional<ComandaProduto> findById(Long id);
}
