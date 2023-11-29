package com.developer.hairsaloon.service.impl;

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
    // Add any validation or business logic here if needed
    return agendamentoRepository.save(agendamento);
  }

  @Override
  public AgendamentoEntity updateAgendamento(AgendamentoEntity agendamento) {
    // Add any validation or business logic here if needed
    return agendamentoRepository.save(agendamento);
  }

  @Override
  public void deleteAgendamentoById(Long id) {
    agendamentoRepository.deleteById(id);
  }

}