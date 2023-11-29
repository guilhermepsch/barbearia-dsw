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

import com.developer.hairsaloon.entity.FuncionarioEntity;
import com.developer.hairsaloon.entity.RegistroServicoEntity;
import com.developer.hairsaloon.entity.ServicoEntity;
import com.developer.hairsaloon.service.FuncionarioService;
import com.developer.hairsaloon.service.RegistroServicoService;
import com.developer.hairsaloon.service.ServicoService;

@RestController
@RequestMapping("/registros-servicos")
public class RegistroServicoController {

  private final RegistroServicoService registroServicoService;
  private final ServicoService servicoService;
  private final FuncionarioService funcionarioService;

  @Autowired
  public RegistroServicoController(RegistroServicoService registroServicoService, ServicoService servicoService,
      FuncionarioService funcionarioService) {
    this.registroServicoService = registroServicoService;
    this.servicoService = servicoService;
    this.funcionarioService = funcionarioService;
  }

  @GetMapping
  public List<RegistroServicoEntity> findAllRegistrosServicos() {
    return registroServicoService.findAllRegistroServicos();
  }

  @GetMapping("/{id}")
  public Optional<RegistroServicoEntity> findRegistroServicoById(@PathVariable("id") Long id) {
    return registroServicoService.findRegistroServicosById(id);
  }

  @PostMapping
  public RegistroServicoEntity saveRegistroServico(@RequestBody RegistroServicoEntity registroServico) {
    if (registroServico.getServicoId() != null && registroServico.getFuncionarioId() != null) {
      ServicoEntity servico = servicoService.findServicoById(registroServico.getServicoId())
          .orElseThrow(() -> new RuntimeException("Servico not found"));
      FuncionarioEntity funcionario = funcionarioService.findFuncionarioById(registroServico.getFuncionarioId())
          .orElseThrow(() -> new RuntimeException("Funcionario not found"));
      registroServico.setServico(servico);
      registroServico.setFuncionario(funcionario);
    } else {
      throw new RuntimeException("ServicoId and FuncionarioId are required");
    }
    return registroServicoService.saveRegistroServicos(registroServico);
  }

  @PutMapping
  public RegistroServicoEntity updateRegistroServico(@RequestBody RegistroServicoEntity registroServico) {
    if (registroServico.getServicoId() != null && registroServico.getFuncionarioId() != null) {
      ServicoEntity servico = servicoService.findServicoById(registroServico.getServicoId())
          .orElseThrow(() -> new RuntimeException("Servico not found"));
      FuncionarioEntity funcionario = funcionarioService.findFuncionarioById(registroServico.getFuncionarioId())
          .orElseThrow(() -> new RuntimeException("Funcionario not found"));
      registroServico.setServico(servico);
      registroServico.setFuncionario(funcionario);
    } else {
      throw new RuntimeException("ServicoId and FuncionarioId are required");
    }

    return registroServicoService.saveRegistroServicos(registroServico);
  }

  @DeleteMapping("/{id}")
  public void deleteRegistroServico(@PathVariable("id") Long id) {
    registroServicoService.deleteRegistroServicosById(id);
  }
}