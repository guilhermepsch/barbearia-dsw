package com.developer.hairsaloon.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.developer.hairsaloon.entity.FuncionarioEntity;
import com.developer.hairsaloon.repository.FuncionarioRepository;
import com.developer.hairsaloon.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

  private final FuncionarioRepository funcionarioRepository;

  public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository) {
    this.funcionarioRepository = funcionarioRepository;
  }

  @Override
  public List<FuncionarioEntity> findAllFuncionarios() {
    return funcionarioRepository.findAll();
  }

  @Override
  public Optional<FuncionarioEntity> findFuncionarioById(Long id) {
    return funcionarioRepository.findById(id);
  }

  @Override
  public FuncionarioEntity saveFuncionario(FuncionarioEntity funcionario) {
    return funcionarioRepository.save(funcionario);
  }

  @Override
  public FuncionarioEntity updateFuncionario(FuncionarioEntity funcionario) {
    return funcionarioRepository.save(funcionario);
  }

  @Override
  public void deleteFuncionarioById(Long id) {
    funcionarioRepository.deleteById(id);
  }
}
