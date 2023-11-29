package com.developer.hairsaloon.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "servicos")
public class ServicoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "descricao")
  private String descricao;

  @Column(name = "preco")
  private Double preco;

  public ServicoEntity() {
  }

  public ServicoEntity(Long id, String nome, String descricao, Double preco) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.preco = preco;
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

  public String getDescricao() {
    return this.descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Double getPreco() {
    return this.preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }

}