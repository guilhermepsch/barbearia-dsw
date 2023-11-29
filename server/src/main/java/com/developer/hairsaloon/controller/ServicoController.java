package com.developer.hairsaloon.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    return servicoService.saveServico(servico);
  }

  @PutMapping
  public ServicoEntity updateServico(@RequestBody ServicoEntity servico) {
    return servicoService.updateServico(servico);
  }

  @DeleteMapping("/{id}")
  public void deleteServico(@PathVariable("id") Long id) {
    servicoService.deleteServicoById(id);
  }
}