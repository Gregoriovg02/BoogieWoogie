package com.ProjetoBalada.ProjetoBalada.comanda;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ComandaRepository  extends JpaRepository<Comanda, Long> {

    @Query(value = "SELECT a.* FROM projetobalada.comanda a WHERE a.ativo = 1", nativeQuery = true)
    List<Comanda> findByAtivoTrue();

    
  
}
