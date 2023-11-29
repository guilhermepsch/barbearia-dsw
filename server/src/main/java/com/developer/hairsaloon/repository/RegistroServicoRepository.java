package com.developer.hairsaloon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.developer.hairsaloon.entity.RegistroServicoEntity;

@Repository
public interface RegistroServicoRepository extends JpaRepository<RegistroServicoEntity, Long> {
  
}
