package com.developer.hairsaloon.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.developer.hairsaloon.entity.AgendamentoEntity;
import com.developer.hairsaloon.entity.FuncionarioEntity;
import com.developer.hairsaloon.entity.ServicoEntity;
import com.developer.hairsaloon.service.AgendamentoService;
import com.developer.hairsaloon.service.FuncionarioService;
import com.developer.hairsaloon.service.ServicoService;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

  private final AgendamentoService agendamentoService;
  private final ServicoService servicoService;
  private final FuncionarioService funcionarioService;

  @Autowired
  public AgendamentoController(
      AgendamentoService agendamentoService,
      ServicoService servicoService,
      FuncionarioService funcionarioService) {
    this.agendamentoService = agendamentoService;
    this.servicoService = servicoService;
    this.funcionarioService = funcionarioService;
  }

  @GetMapping
  public List<AgendamentoEntity> findAllAgendamentos() {
    return agendamentoService.findAllAgendamentos();
  }

  @GetMapping("/{id}")
  public Optional<AgendamentoEntity> findAgendamentoById(@PathVariable("id") Long id) {
    return agendamentoService.findAgendamentoById(id);
  }

  @PostMapping
  public ResponseEntity<AgendamentoEntity> createAgendamento(@RequestBody AgendamentoEntity agendamento) {
    if (agendamento.getClienteNome() == null || agendamento.getClienteNome().isEmpty()) {
      throw new RuntimeException("O Nome do cliente deve ser informado.");
    }
    if (agendamento.getEmailCliente() == null || agendamento.getEmailCliente().isEmpty()) {
      throw new RuntimeException("O Email do cliente deve ser informado.");
    }
    if (agendamento.getDataHora() == null) {
      throw new RuntimeException("A Data e Hora do agendamento deve ser informada.");
    }
    if (agendamento.getServicoId() != null && agendamento.getFuncionarioId() != null) {
      ServicoEntity servico = servicoService.findServicoById(agendamento.getServicoId())
          .orElseThrow(() -> new RuntimeException("Servico not found"));
      FuncionarioEntity funcionario = funcionarioService.findFuncionarioById(agendamento.getFuncionarioId())
          .orElseThrow(() -> new RuntimeException("Funcionario not found"));

      agendamento.setServico(servico);
      agendamento.setFuncionario(funcionario);
    } else {
      throw new RuntimeException("ServicoId and FuncionarioId must be informed");
    }

    AgendamentoEntity createdAgendamento = agendamentoService.saveAgendamento(agendamento);
    return new ResponseEntity<>(createdAgendamento, HttpStatus.CREATED);
  }

  @PutMapping
  public AgendamentoEntity updateAgendamento(@RequestBody AgendamentoEntity agendamento) {
    if (agendamento.getId() == null) {
      throw new RuntimeException("Id do agendamento deve ser informado.");
    }
    if (agendamento.getClienteNome() == null || agendamento.getClienteNome().isEmpty()) {
      throw new RuntimeException("O Nome do cliente deve ser informado.");
    }
    if (agendamento.getEmailCliente() == null || agendamento.getEmailCliente().isEmpty()) {
      throw new RuntimeException("O Email do cliente deve ser informado.");
    }
    if (agendamento.getDataHora() == null) {
      throw new RuntimeException("A Data e Hora do agendamento deve ser informada.");
    }
    if (agendamento.getServicoId() != null && agendamento.getFuncionarioId() != null) {
      ServicoEntity servico = servicoService.findServicoById(agendamento.getServicoId())
          .orElseThrow(() -> new RuntimeException("Servico not found"));
      FuncionarioEntity funcionario = funcionarioService.findFuncionarioById(agendamento.getFuncionarioId())
          .orElseThrow(() -> new RuntimeException("Funcionario not found"));

      agendamento.setServico(servico);
      agendamento.setFuncionario(funcionario);
    } else {
      throw new RuntimeException("ServicoId and FuncionarioId must be informed");
    }

    return agendamentoService.updateAgendamento(agendamento);
  }

  @DeleteMapping("/{id}")
  public void deleteAgendamento(@PathVariable("id") Long id) {
    agendamentoService.deleteAgendamentoById(id);
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<?> handleRuntimeException(RuntimeException e) {
    return ResponseEntity.badRequest().body(e.getMessage());
  }
}