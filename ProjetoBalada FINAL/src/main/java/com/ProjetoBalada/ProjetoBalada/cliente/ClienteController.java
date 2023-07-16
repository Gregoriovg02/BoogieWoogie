package com.ProjetoBalada.ProjetoBalada.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetoBalada.ProjetoBalada.comanda.Comanda;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    
     @PostMapping("/create")
    public void save(@RequestBody Cliente cliente){
        cliente.setAtivo(true);
        clienteRepository.save(cliente);
    }

    @GetMapping(value = "/find/{id}")
    public Cliente findById(@PathVariable Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    
@PutMapping("/edit/{id}")
public void alterarCliente(@PathVariable("id") Long id, @RequestBody Cliente clienteDTO) {
    Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
    cliente.setNome(clienteDTO.getNome());
    cliente.setCpf(clienteDTO.getCpf());
    cliente.setTelefone(clienteDTO.getTelefone());

    clienteRepository.save(cliente);
}



    @GetMapping("/list")
  public List<Cliente> Listclientes() {
     return clienteRepository.findByAtivos();
  }

   @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var cliente = clienteRepository.getReferenceById(id);
        cliente.excluir();

        return ResponseEntity.noContent().build();
    }
  }

