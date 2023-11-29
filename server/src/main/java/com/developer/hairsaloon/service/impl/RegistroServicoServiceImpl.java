package com.developer.hairsaloon.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.developer.hairsaloon.entity.RegistroServicoEntity;
import com.developer.hairsaloon.repository.RegistroServicoRepository;
import com.developer.hairsaloon.service.RegistroServicoService;

@Service
public class RegistroServicoServiceImpl implements RegistroServicoService {

  private final RegistroServicoRepository registroServicoRepository;

  public RegistroServicoServiceImpl(RegistroServicoRepository registroServicoRepository) {
    this.registroServicoRepository = registroServicoRepository;
  }

  @Override
  public List<RegistroServicoEntity> findAllRegistroServicos() {
    return registroServicoRepository.findAll();
  }

  @Override
  public Optional<RegistroServicoEntity> findRegistroServicosById(Long id) {
    return registroServicoRepository.findById(id);
  }

  @Override
  public RegistroServicoEntity saveRegistroServicos(RegistroServicoEntity registroServicos) {
    return registroServicoRepository.save(registroServicos);
  }

  @Override
  public RegistroServicoEntity updateRegistroServicos(RegistroServicoEntity registroServicos) {
    return registroServicoRepository.save(registroServicos);
  }

  @Override
  public void deleteRegistroServicosById(Long id) {
    registroServicoRepository.deleteById(id);
  } 
  
}
