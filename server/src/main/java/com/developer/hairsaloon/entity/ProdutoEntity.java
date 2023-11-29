package com.developer.hairsaloon.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class ProdutoEntity {

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

  @Column(name = "estoque")
  private Integer estoque;

  public ProdutoEntity() {
  }

  public ProdutoEntity(Long id, String nome, String descricao, Double preco, Integer estoque) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.preco = preco;
    this.estoque = estoque;
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

  public Integer getEstoque() {
    return this.estoque;
  }

  public void setEstoque(Integer estoque) {
    this.estoque = estoque;
  }
}