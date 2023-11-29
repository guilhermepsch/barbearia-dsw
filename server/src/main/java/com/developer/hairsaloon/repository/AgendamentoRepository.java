package com.developer.hairsaloon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.developer.hairsaloon.entity.AgendamentoEntity;

@Repository
public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity, Long> {
  
}
