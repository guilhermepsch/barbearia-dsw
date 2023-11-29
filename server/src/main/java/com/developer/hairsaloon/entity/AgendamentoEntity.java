package com.developer.hairsaloon.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "agendamentos")
public class AgendamentoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "cliente_nome")
  private String clienteNome;

  @Column(name = "data_hora")
  private Date dataHora;

  @ManyToOne
  @JoinColumn(name = "servico_id")
  private ServicoEntity servico;

  @ManyToOne
  @JoinColumn(name = "funcionario_id")
  private FuncionarioEntity funcionario;

  @Column(name = "email_cliente")
  private String emailCliente;

  @Transient
  private Long servicoId;

  @Transient
  private Long funcionarioId;

  public AgendamentoEntity() {
  }

  public AgendamentoEntity(String clienteNome, Date dataHora, String emailCliente) {
    this.clienteNome = clienteNome;
    this.dataHora = dataHora;
    this.emailCliente = emailCliente;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getClienteNome() {
    return this.clienteNome;
  }

  public void setClienteNome(String clienteNome) {
    this.clienteNome = clienteNome;
  }

  public Date getDataHora() {
    return this.dataHora;
  }

  public void setDataHora(Date dataHora) {
    this.dataHora = dataHora;
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

  public String getEmailCliente() {
    return this.emailCliente;
  }

  public void setEmailCliente(String emailCliente) {
    this.emailCliente = emailCliente;
  }

  public Long getServicoId() {
    return servicoId;
  }

  public void setServicoId(Long servicoId) {
    this.servicoId = servicoId;
  }

  public Long getFuncionarioId() {
    return funcionarioId;
  }

  public void setFuncionarioId(Long funcionarioId) {
    this.funcionarioId = funcionarioId;
  }
}
