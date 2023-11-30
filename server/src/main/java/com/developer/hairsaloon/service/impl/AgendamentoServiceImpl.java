package com.developer.hairsaloon.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.developer.hairsaloon.entity.AgendamentoEntity;
import com.developer.hairsaloon.repository.AgendamentoRepository;
import com.developer.hairsaloon.service.AgendamentoService;

@Service
public class AgendamentoServiceImpl implements AgendamentoService {

  private final AgendamentoRepository agendamentoRepository;

  public AgendamentoServiceImpl(AgendamentoRepository agendamentoRepository) {
    this.agendamentoRepository = agendamentoRepository;
  }

  @Override
  public List<AgendamentoEntity> findAllAgendamentos() {
    return agendamentoRepository.findAll();
  }

  @Override
  public Optional<AgendamentoEntity> findAgendamentoById(Long id) {
    return agendamentoRepository.findById(id);
  }

  @Override
  public AgendamentoEntity saveAgendamento(AgendamentoEntity agendamento) {
    if (agendamento.getDataHora().before(new Date())) {
      throw new RuntimeException("Não é possível agendar para uma data passada");
    }
    List<AgendamentoEntity> agendamentos = agendamentoRepository.findAll();
    for (AgendamentoEntity agendamentoEntity : agendamentos) {
      if ((agendamentoEntity.getDataHora().getTime() == agendamento.getDataHora().getTime()) && (agendamentoEntity.getFuncionario().getId() == agendamento.getFuncionario().getId())) {
        throw new RuntimeException("Não é possível agendar para o mesmo horário com o mesmo funcionário");
      }
      if ((agendamentoEntity.getDataHora().getTime() == agendamento.getDataHora().getTime() + 3600000)
          && (agendamentoEntity.getFuncionario().getId() == agendamento.getFuncionario().getId())) {
        throw new RuntimeException("Já existe um agendamento dentro de uma hora com o mesmo funcionário");
      }
    }
    return agendamentoRepository.save(agendamento);
  }

  @Override
  public AgendamentoEntity updateAgendamento(AgendamentoEntity agendamento) {
    if (agendamento.getDataHora().before(new Date())) {
      throw new RuntimeException("Não é possível agendar para uma data passada");
    }
    List<AgendamentoEntity> agendamentos = agendamentoRepository.findAll();
    for (AgendamentoEntity agendamentoEntity : agendamentos) {
      if ((agendamentoEntity.getDataHora().getTime() == agendamento.getDataHora().getTime()) && (agendamentoEntity.getFuncionario().getId() == agendamento.getFuncionario().getId())) {
        throw new RuntimeException("Não é possível agendar para o mesmo horário com o mesmo funcionário");
      }
      if ((agendamentoEntity.getDataHora().getTime() == agendamento.getDataHora().getTime() + 3600000)
          && (agendamentoEntity.getFuncionario().getId() == agendamento.getFuncionario().getId())) {
        throw new RuntimeException("Já existe um agendamento dentro de uma hora com o mesmo funcionário");
      }
    }
    return agendamentoRepository.save(agendamento);
  }

  @Override
  public void deleteAgendamentoById(Long id) {
    agendamentoRepository.deleteById(id);
  }

}