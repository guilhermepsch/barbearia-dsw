package com.developer.hairsaloon.service;

import java.util.List;
import java.util.Optional;
import com.developer.hairsaloon.entity.ProdutoEntity;

public interface ProdutoService {
  List<ProdutoEntity> findAllProdutos();
  Optional<ProdutoEntity> findProdutoById(Long id);
  ProdutoEntity saveProduto(ProdutoEntity produto);
  ProdutoEntity updateProduto(ProdutoEntity produto);
  void deleteProdutoById(Long id);
}