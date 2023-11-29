package com.developer.hairsaloon.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "registros_servicos")
public class RegistroServicoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "cliente_email")
  private String clienteEmail;

  @ManyToOne
  @JoinColumn(name = "servico_id")
  private ServicoEntity servico;

  @ManyToOne
  @JoinColumn(name = "funcionario_id")
  private FuncionarioEntity funcionario;

  @Column(name = "data_hora")
  private java.util.Date dataHora;

  @Transient
  private Long servicoId;

  @Transient
  private Long funcionarioId;

  public RegistroServicoEntity() {
  }

  public RegistroServicoEntity(Long id, String clienteEmail, Date dataHora) {
    this.id = id;
    this.clienteEmail = clienteEmail;
    this.dataHora = dataHora;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ServicoEntity getServico() {
    return this.servico;
  }

  public void setServico(ServicoEntity servico) {
    this.servico = servico;
  }

  public FuncionarioEntity getFuncionario() {
    return this.funcionario;
  }

  public void setFuncionario(FuncionarioEntity funcionario) {
    this.funcionario = funcionario;
  }

  public Date getDataHora() {
    return this.dataHora;
  }

  public void setDataHora(Date dataHora) {
    this.dataHora = dataHora;
  }

  public String getClienteEmail() {
    return this.clienteEmail;
  }

  public void setClienteEmail(String clienteEmail) {
    this.clienteEmail = clienteEmail;
  }

  public Long getServicoId() {
    return this.servicoId;
  }

  public void setServicoId(Long servicoId) {
    this.servicoId = servicoId;
  }

  public Long getFuncionarioId() {
    return this.funcionarioId;
  }

  public void setFuncionarioId(Long funcionarioId) {
    this.funcionarioId = funcionarioId;
  }
}