import axios, { AxiosError } from 'axios';
import { Schedule, Service, Employee } from '../types';

const API_URL = 'http://localhost:8080';

const api = axios.create({
	baseURL: API_URL,
	headers: {
		'Content-Type': 'application/json',
	},
});

export async function getSchedulings() {
	const response = await api.get<Schedule[]>('/agendamentos');
	console.log(response.data);
	return response.data;
}

export async function getScheduling(id: number) {
	const response = await api.get<Schedule>(`/agendamentos/${id}`);
	return response.data;
}

export async function getServicos() {
	const response = await api.get<Service[]>('/servicos');
	return response.data;
}

export async function getFuncionarios() {
	const response = await api.get<Employee[]>('/funcionarios');
	return response.data;
}

interface PostAtendimento {
	servicoId: number;
	funcionarioId: number;
	clienteNome: string;
	emailCliente: string;
	dataHora: string;
};

interface PutAtendimento extends PostAtendimento {
  id: number;
};

export async function postAtendimento(atendimento: Schedule) {
	const body: PostAtendimento = {
		servicoId: atendimento.servico.id,
		funcionarioId: atendimento.funcionario.id,
		clienteNome: atendimento.clienteNome,
		emailCliente: atendimento.emailCliente,
		dataHora: atendimento.dataHora,
	};
	try {
		const response = await api.post<Schedule>('/agendamentos', body);
		return response.data;
	} catch (error) {
    const axiosError = error as AxiosError;
    if (axiosError.response?.status === 400) {
      alert(axiosError.response.data as string);
    } else {
      alert('Erro ao agendar atendimento');
    }
		throw axiosError;
  }
}

export async function putAtendimento(atendimento: Schedule) {
  const body: PutAtendimento = {
    id: atendimento.id,
    servicoId: atendimento.servico.id,
    funcionarioId: atendimento.funcionario.id,
    clienteNome: atendimento.clienteNome,
    emailCliente: atendimento.emailCliente,
    dataHora: atendimento.dataHora,
  };
  try {
    const response = await api.put<Schedule>(`/agendamentos`, body);
    return response.data;
  } catch (error) {
    const axiosError = error as AxiosError;
    if (axiosError.response?.status === 400) {
      alert(axiosError.response.data as string);
    } else {
      alert('Erro ao agendar atendimento');
    }
    throw axiosError;
  }
}

export async function deleteAtendimento(id: number) {
	try {
		await api.delete(`/agendamentos/${id}`);
	} catch (error) {
		const axiosError = error as AxiosError;
		if (axiosError.response?.status === 400) {
			alert(axiosError.response.data as string);
		} else {
			alert('Erro ao deletar atendimento');
		}
		throw axiosError;
	}
}
