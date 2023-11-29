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
import com.developer.hairsaloon.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

  private final FuncionarioService funcionarioService;

  @Autowired
  public FuncionarioController(FuncionarioService funcionarioService) {
    this.funcionarioService = funcionarioService;
  }

  @GetMapping
  public List<FuncionarioEntity> findAllFuncionarios() {
    return funcionarioService.findAllFuncionarios();
  }

  @GetMapping("/{id}")
  public Optional<FuncionarioEntity> findFuncionarioById(@PathVariable("id") Long id) {
    return funcionarioService.findFuncionarioById(id);
  }

  @PostMapping
  public FuncionarioEntity saveFuncionario(@RequestBody FuncionarioEntity funcionario) {
    return funcionarioService.saveFuncionario(funcionario);
  }

  @PutMapping
  public FuncionarioEntity updateFuncionario(@RequestBody FuncionarioEntity funcionario) {
    return funcionarioService.updateFuncionario(funcionario);
  }

  @DeleteMapping("/{id}")
  public void deleteFuncionario(@PathVariable("id") Long id) {
    funcionarioService.deleteFuncionarioById(id);
  }
}