package com.developer.hairsaloon.service;

import java.util.List;
import java.util.Optional;
import com.developer.hairsaloon.entity.ServicoEntity;

public interface ServicoService {
  List<ServicoEntity> findAllServicos();

  Optional<ServicoEntity> findServicoById(Long id);

  ServicoEntity saveServico(ServicoEntity servico);

  ServicoEntity updateServico(ServicoEntity servico);

  void deleteServicoById(Long id);
}