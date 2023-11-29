package com.developer.hairsaloon.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "funcionarios")
public class FuncionarioEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "cargo")
  private String cargo;

  @Column(name = "salario")
  private Double salario;

  public FuncionarioEntity() {
  }

  public FuncionarioEntity(Long id, String nome, String cargo, Double salario) {
    this.id = id;
    this.nome = nome;
    this.cargo = cargo;
    this.salario = salario;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCargo() {
    return this.cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  public Double getSalario() {
    return this.salario;
  }

  public void setSalario(Double salario) {
    this.salario = salario;
  }

}