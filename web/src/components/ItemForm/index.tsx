import { useEffect, useState } from 'react';
import { Employee, Schedule, Service } from '../../types';
import {
	getFuncionarios,
	getScheduling,
	getServicos,
	postAtendimento,
	putAtendimento,
} from '../../api/api';
import { useNavigate, useParams } from 'react-router-dom';
import Header from '../Header';

export default function ItemForm() {
	const { id } = useParams();
	const navigate = useNavigate();
	const [scheduling, setScheduling] = useState<Schedule>({
		id: 0,
		clienteNome: '',
		dataHora: '',
		emailCliente: '',
		funcionario: {
			id: 0,
			nome: '',
			cargo: '',
			salario: 0,
		},
		servico: {
			id: 0,
			nome: '',
			descricao: '',
			preco: 0,
		},
	});
	const [funcionarios, setFuncionarios] = useState<Employee[]>([]);
	const [servicos, setServicos] = useState<Service[]>([]);
	const [isLoading, setIsLoading] = useState(true);

	useEffect(() => {
		getFuncionarios().then(data => setFuncionarios(data));
		getServicos().then(data => setServicos(data));
		if (isNaN(Number(id)) || !id) {
			console.log('id is not a number');
			setIsLoading(false);
			return;
		}
		getScheduling(Number(id)).then(scheduling => {
			scheduling.dataHora = scheduling.dataHora.slice(0, 16);
			setScheduling(scheduling);
			setIsLoading(false);
		});
		console.log('id is a number');
	}, []);

	function handleInputChange(event: React.ChangeEvent<HTMLInputElement>) {
		const { name, value } = event.target;
		setScheduling({ ...scheduling, [name]: value });
	}

	function handleSelectChange(event: React.ChangeEvent<HTMLSelectElement>) {
		const { name, value } = event.target;
		setScheduling({
			...scheduling,
			[name]: {
				id: Number(value),
			},
		});
	}

	function handleSubmit(event: React.FormEvent<HTMLFormElement>) {
		event.preventDefault();
		if (!validateFields()) {
			return;
		}
		if (scheduling.id === 0) {
			postAtendimento(scheduling).then(() => {
				alert('Atendimento salvo com sucesso!');
				navigate('/');
			});
		} else {
			putAtendimento(scheduling).then(() => {
				alert('Atendimento atualizado com sucesso!');
				navigate('/');
			});
		}
	}

	function validateFields() {
		if (scheduling.clienteNome === '') {
			alert('Preencha o nome do cliente!');
			return false;
		}
		if (scheduling.emailCliente === '') {
			alert('Preencha o email do cliente!');
			return false;
		}
		if (scheduling.dataHora === '') {
			alert('Preencha a data e hora do atendimento!');
			return false;
		}
		if (scheduling.funcionario.id === 0) {
			alert('Selecione um funcionário!');
			return false;
		}
		if (scheduling.servico.id === 0) {
			alert('Selecione um serviço!');
			return false;
		}
		return true;
	}

	if (isLoading) {
		return <p>Loading...</p>;
	}

	return (
		<div className="bg-gray-100 min-h-screen">
			<Header />

			{/* Main Content */}
			<main className="max-w-4xl mx-auto mt-8">
				<div className="flex flex-col">
					<form
						onSubmit={handleSubmit}
						className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4">
						<h2 className="text-2xl font-bold mb-4">
							{scheduling.id === 0
								? 'Novo Atendimento'
								: 'Editar Atendimento'}
						</h2>
						<div className="flex flex-col gap-3 mb-4">
							<div>
								<label
									className="block text-gray-700 text-sm font-bold mb-2"
									htmlFor="id">
									Id
								</label>
								<input
									value={
										scheduling.id === 0 ? '' : scheduling.id
									}
									className={
										'shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline bg-gray-200'
									}
									type="text"
									readOnly={true}
								/>
							</div>
							<div>
								<label
									className="block text-gray-700 text-sm font-bold mb-2"
									htmlFor="clienteNome">
									Nome do Cliente
								</label>
								<input
									value={scheduling.clienteNome}
									onChange={handleInputChange}
									className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
									type="text"
									name="clienteNome"
									id="clienteNome"
									placeholder="Nome do Cliente"
								/>
							</div>
							<div>
								<label
									className="block text-gray-700 text-sm font-bold mb-2"
									htmlFor="emailCliente">
									Email do Cliente
								</label>
								<input
									value={scheduling.emailCliente}
									onChange={handleInputChange}
									className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
									type="email"
									name="emailCliente"
									id="emailCliente"
									placeholder="Email do Cliente"
								/>
							</div>
							<div>
								<label
									className="block text-gray-700 text-sm font-bold mb-2"
									htmlFor="dataHora">
									Data e Hora
								</label>
								<input
									value={scheduling.dataHora}
									onChange={handleInputChange}
									className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
									type="datetime-local"
									name="dataHora"
									id="dataHora"
									placeholder="Data e Hora"
								/>
							</div>
							<div>
								<label
									className="block text-gray-700 text-sm font-bold mb-2"
									htmlFor="funcionario">
									Funcionário
								</label>
								<select
									value={scheduling.funcionario.id}
									onChange={handleSelectChange}
									name="funcionario"
									id="funcionario"
									className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
									<option value="">Selecione...</option>
									{funcionarios.map(employee => (
										<option
											key={employee.id}
											value={employee.id}>
											{employee.nome}
										</option>
									))}
								</select>
							</div>
							<div>
								<label
									className="block text-gray-700 text-sm font-bold mb-2"
									htmlFor="servico">
									Serviço
								</label>
								<select
									value={scheduling.servico.id}
									onChange={handleSelectChange}
									name="servico"
									id="servico"
									className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
									<option value="">Selecione...</option>
									{servicos.map(service => (
										<option
											key={service.id}
											value={service.id}>
											{service.nome}
										</option>
									))}
								</select>
							</div>
						</div>
						<div className="flex justify-between">
							<button
								type="submit"
								className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">
								Salvar
							</button>
							<button
								onClick={() => navigate('/')}
								className="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">
								Cancelar
							</button>
						</div>
					</form>
				</div>
			</main>
		</div>
	);
}
