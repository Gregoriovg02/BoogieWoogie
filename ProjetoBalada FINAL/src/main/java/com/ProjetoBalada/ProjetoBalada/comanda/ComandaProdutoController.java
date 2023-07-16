package com.ProjetoBalada.ProjetoBalada.comanda;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

import com.ProjetoBalada.ProjetoBalada.cliente.Cliente;
import com.ProjetoBalada.ProjetoBalada.comanda.enums.ProdutoEnum;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/comandaproduto")
public class ComandaProdutoController {

    @Autowired
    private ComandaProdutoRepository comandaprodutoRepository;
    @Autowired
    private ComandaRepository comandaRepository;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody CreateComandaProdutoDTO createDto) {
        Comanda comanda = comandaRepository.findById(createDto.getComandaId())
                .orElseThrow(() -> new IllegalArgumentException("Comanda deu ruim irmão"));
        ComandaProduto comandaproduto = new ComandaProduto();
        comandaproduto.setComanda(comanda);
        comandaproduto.setQuantidade(createDto.getQuantidade());
        comandaproduto.setTipo(createDto.getTipo());
        comandaproduto.setValor(createDto.getValor());
        comandaproduto.setAtivo(true);
        comandaprodutoRepository.save(comandaproduto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/edit")
    public void alterarComandaProduto(@RequestParam("id") Long id, @RequestBody ComandaProduto comandaProdutoDTO) {
        ComandaProduto comandaProduto = comandaprodutoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ComandaProduto não encontrado"));
        comandaProduto.setTipo(comandaProdutoDTO.getTipo());
        comandaProduto.setQuantidade(comandaProdutoDTO.getQuantidade());
        comandaProduto.setValor(comandaProdutoDTO.getValor());

        comandaprodutoRepository.save(comandaProduto);
    }

    @GetMapping(value = "/find", params = "id")
    public ComandaProduto findById(Long id) {
        return comandaprodutoRepository.findById(id).orElse(null);
    }

    @GetMapping("/list")
    public List<ComandaProdutoListDTO> produtoList() {
        List<ComandaProduto> produtos= comandaprodutoRepository.findByAtivos();
        return produtos.stream().map(ComandaProdutoListDTO::new).collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var produtocomanda = comandaprodutoRepository.getReferenceById(id);
        produtocomanda.excluir();

        return ResponseEntity.noContent().build();
    }

}
