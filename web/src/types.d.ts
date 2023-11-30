export type Schedule = {
  id: number;
  clienteNome: string;
  emailCliente: string;
  dataHora: string;
  servico: Service;
  funcionario: Employee;
};

export type Service = {
  id: number;
  nome: string;
  descricao: string;
  preco: number;
};

export type Employee = {
  id: number;
  nome: string;
  cargo: string;
  salario: number;
};