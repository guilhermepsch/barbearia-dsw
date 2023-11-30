package com.developer.hairsaloon.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developer.hairsaloon.entity.ServicoEntity;
import com.developer.hairsaloon.service.ServicoService;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

  private final ServicoService servicoService;

  @Autowired
  public ServicoController(ServicoService servicoService) {
    this.servicoService = servicoService;
  }

  @GetMapping
  public List<ServicoEntity> findAllServicos() {
    return servicoService.findAllServicos();
  }

  @GetMapping("/{id}")
  public Optional<ServicoEntity> findServicoById(@PathVariable("id") Long id) {
    return servicoService.findServicoById(id);
  }

  @PostMapping
  public ServicoEntity saveServico(@RequestBody ServicoEntity servico) {
    if (servico.getNome() == null || servico.getNome().isEmpty()) {
      throw new RuntimeException("O Nome do servico deve ser informado.");
    }
    if (servico.getDescricao() == null || servico.getDescricao().isEmpty()) {
      throw new RuntimeException("A Descricao do servico deve ser informada.");
    }
    if (servico.getPreco() == null) {
      throw new RuntimeException("O Preco do servico deve ser informado.");
    }
    return servicoService.saveServico(servico);
  }

  @PutMapping
  public ServicoEntity updateServico(@RequestBody ServicoEntity servico) {
    if (servico.getId() == null) {
      throw new RuntimeException("O ID do servico deve ser informado.");
    }
    if (servico.getNome() == null || servico.getNome().isEmpty()) {
      throw new RuntimeException("O Nome do servico deve ser informado.");
    } 
    if (servico.getDescricao() == null || servico.getDescricao().isEmpty()) {
      throw new RuntimeException("A Descricao do servico deve ser informada.");
    }
    if (servico.getPreco() == null) {
      throw new RuntimeException("O Preco do servico deve ser informado.");
    }
    return servicoService.updateServico(servico);
  }

  @DeleteMapping("/{id}")
  public void deleteServico(@PathVariable("id") Long id) {
    servicoService.deleteServicoById(id);
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<?> handleRuntimeException(RuntimeException e) {
    return ResponseEntity.badRequest().body(e.getMessage());
  }
}