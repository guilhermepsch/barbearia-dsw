package com.developer.hairsaloon.service;

import java.util.List;
import java.util.Optional;

import com.developer.hairsaloon.entity.FuncionarioEntity;

public interface FuncionarioService {
  List<FuncionarioEntity> findAllFuncionarios();
  Optional<FuncionarioEntity> findFuncionarioById(Long id);
  FuncionarioEntity saveFuncionario(FuncionarioEntity funcionario);
  FuncionarioEntity updateFuncionario(FuncionarioEntity funcionario);
  void deleteFuncionarioById(Long id);
}

