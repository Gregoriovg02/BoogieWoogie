package com.ProjetoBalada.ProjetoBalada.comanda;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetoBalada.ProjetoBalada.cliente.Cliente;

import jakarta.persistence.Id;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/comanda")
public class ComandaController {

    @Autowired
    private ComandaRepository comandaRepository;

    @GetMapping(value = "/find", params = "id")
    public Comanda findById(Long id) {
        return comandaRepository.findById(id).orElse(null);
    }

   
    @PostMapping("/create")
    public void create(@RequestBody Comanda comanda) {
        comanda.setAtivo(true);
        comandaRepository.save(comanda);
    }

    @GetMapping("/list")
    public List<Comanda> comandaList() {
        return comandaRepository.findByAtivoTrue();
    }
    
    @PutMapping("/edit/{id}")
    @Transactional
    public void editar(@RequestBody Comanda comanda){
        if (comanda.getAtivo() == false)
        comanda.setAtivo(true);
    }

    @Transactional
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        var comandadelete = comandaRepository.getReferenceById(id);
        comandadelete.excluir();

        return ResponseEntity.noContent().build();
    }

}
