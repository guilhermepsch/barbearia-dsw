package com.developer.hairsaloon.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.developer.hairsaloon.entity.ServicoEntity;
import com.developer.hairsaloon.repository.ServicoRepository;
import com.developer.hairsaloon.service.ServicoService;

@Service
public class ServicoServiceImpl implements ServicoService {

  private final ServicoRepository servicoRepository;

  public ServicoServiceImpl(ServicoRepository servicoRepository) {
    this.servicoRepository = servicoRepository;
  }

  @Override
  public List<ServicoEntity> findAllServicos() {
    return servicoRepository.findAll();
  }

  @Override
  public Optional<ServicoEntity> findServicoById(Long id) {
    return servicoRepository.findById(id);
  }

  @Override
  public ServicoEntity saveServico(ServicoEntity servico) {
    // Add any validation or business logic here if needed
    return servicoRepository.save(servico);
  }

  @Override
  public ServicoEntity updateServico(ServicoEntity servico) {
    // Add any validation or business logic here if needed
    return servicoRepository.save(servico);
  }

  @Override
  public void deleteServicoById(Long id) {
    servicoRepository.deleteById(id);
  }
}
