package com.developer.hairsaloon.service;

import java.util.List;
import java.util.Optional;

import com.developer.hairsaloon.entity.AgendamentoEntity;

public interface AgendamentoService {
  List<AgendamentoEntity> findAllAgendamentos();
  Optional<AgendamentoEntity> findAgendamentoById(Long id);
  AgendamentoEntity saveAgendamento(AgendamentoEntity agendamento);
  AgendamentoEntity updateAgendamento(AgendamentoEntity agendamento);
  void deleteAgendamentoById(Long id);
}
