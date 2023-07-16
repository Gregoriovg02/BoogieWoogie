package com.ProjetoBalada.ProjetoBalada.cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long> {

    @Query(value = "SELECT a.* FROM projetobalada.cliente a WHERE a.ativo = 1", nativeQuery = true)
    List<Cliente> findByAtivos();

    Optional<Cliente> findByCpf(String cpf);
    Optional<Cliente> findById(Long id);



    
}
