package com.developer.hairsaloon.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.developer.hairsaloon.entity.ProdutoEntity;
import com.developer.hairsaloon.repository.ProdutoRepository;
import com.developer.hairsaloon.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

  private final ProdutoRepository produtoRepository;

  public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
    this.produtoRepository = produtoRepository;
  }

  @Override
  public List<ProdutoEntity> findAllProdutos() {
    return produtoRepository.findAll();
  }

  @Override
  public Optional<ProdutoEntity> findProdutoById(Long id) {
    return produtoRepository.findById(id);
  }

  @Override
  public ProdutoEntity saveProduto(ProdutoEntity produto) {
    return produtoRepository.save(produto);
  }

  @Override
  public ProdutoEntity updateProduto(ProdutoEntity produto) {
    return produtoRepository.save(produto);
  }

  @Override
  public void deleteProdutoById(Long id) {
    produtoRepository.deleteById(id);
  }
}