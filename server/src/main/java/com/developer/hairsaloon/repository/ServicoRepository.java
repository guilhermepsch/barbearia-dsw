package com.developer.hairsaloon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.developer.hairsaloon.entity.ServicoEntity;

@Repository
public interface ServicoRepository extends JpaRepository<ServicoEntity, Long> {
  
}
