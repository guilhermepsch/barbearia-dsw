package com.developer.hairsaloon.service;

import java.util.List;
import java.util.Optional;
import com.developer.hairsaloon.entity.RegistroServicoEntity;

public interface RegistroServicoService {
  List<RegistroServicoEntity> findAllRegistroServicos();

  Optional<RegistroServicoEntity> findRegistroServicosById(Long id);

  RegistroServicoEntity saveRegistroServicos(RegistroServicoEntity registroServicos);

  RegistroServicoEntity updateRegistroServicos(RegistroServicoEntity registroServicos);

  void deleteRegistroServicosById(Long id);
}