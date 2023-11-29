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

import com.developer.hairsaloon.entity.ProdutoEntity;
import com.developer.hairsaloon.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

  private final ProdutoService produtoService;

  @Autowired
  public ProdutoController(ProdutoService produtoService) {
    this.produtoService = produtoService;
  }

  @GetMapping
  public List<ProdutoEntity> findAllProdutos() {
    return produtoService.findAllProdutos();
  }

  @GetMapping("/{id}")
  public Optional<ProdutoEntity> findProdutoById(@PathVariable("id") Long id) {
    return produtoService.findProdutoById(id);
  }

  @PostMapping
  public ProdutoEntity saveProduto(@RequestBody ProdutoEntity produto) {
    return produtoService.saveProduto(produto);
  }

  @PutMapping
  public ProdutoEntity updateProduto(@RequestBody ProdutoEntity produto) {
    return produtoService.updateProduto(produto);
  }

  @DeleteMapping("/{id}")
  public void deleteProduto(@PathVariable("id") Long id) {
    produtoService.deleteProdutoById(id);
  }
}