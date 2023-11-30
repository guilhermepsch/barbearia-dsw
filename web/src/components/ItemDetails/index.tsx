import { useNavigate, useParams } from 'react-router-dom';
import { Schedule } from '../../types';
import { useEffect, useState } from 'react';
import { getScheduling } from '../../api/api';
import { formatDate, formatTime } from '../../utils/date';

export default function ItemDetails() {
  const navigate = useNavigate();
	const { id } = useParams();
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

	useEffect(() => {
		if (isNaN(Number(id))) {
			return;
		}
		getScheduling(Number(id)).then(scheduling => setScheduling(scheduling));
	}, [id]);

	return (
		<div className="bg-gray-100 min-h-screen">
			<header className="bg-blue-600 text-white p-4">
				<div className="max-w-2xl mx-auto">
					<h1 className="text-3xl font-bold">
						Welcome to Our Barbershop
					</h1>
					<p className="mt-2">
						Experience the best haircuts in town!
					</p>
				</div>
			</header>

			{/* Main Content */}
			<main className="max-w-4xl mx-auto mt-8">
				<form className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4">
					<h2 className="text-2xl font-bold mb-4">
						Barbershop Current Schedulings
					</h2>
					<div className="flex flex-col gap-3 mb-4">
						<div>
							<label
								className="block text-gray-700 text-sm font-bold mb-2"
								htmlFor="id">
								Id
							</label>
							<input
								value={scheduling.id}
								className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
								type="text"
								readOnly={true}
							/>
						</div>
						<div>
							<label
								className="block text-gray-700 text-sm font-bold mb-2"
								htmlFor="name">
								Nome do Cliente
							</label>
							<input
								value={scheduling.clienteNome}
								className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
								type="text"
								readOnly={true}
							/>
						</div>
						<div>
							<label
								className="block text-gray-700 text-sm font-bold mb-2"
								htmlFor="email">
								Email do Cliente
							</label>
							<input
								value={scheduling.emailCliente}
								className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
								type="text"
								readOnly={true}
							/>
						</div>
						<div>
							<label
								className="block text-gray-700 text-sm font-bold mb-2"
								htmlFor="data">
								Data
							</label>
							<input
								value={formatDate(
									new Date(scheduling.dataHora),
								)}
								className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
								type="text"
								readOnly={true}
							/>
						</div>
						<div>
							<label
								className="block text-gray-700 text-sm font-bold mb-2"
								htmlFor="hora">
								Hora
							</label>
							<input
								value={formatTime(
									new Date(scheduling.dataHora),
								)}
								className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
								type="text"
								readOnly={true}
							/>
						</div>
						<div>
							<label
								className="block text-gray-700 text-sm font-bold mb-2"
								htmlFor="servico">
								Serviço
							</label>
							<input
								value={scheduling.servico.nome}
								className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
								type="text"
								readOnly={true}
							/>
						</div>
						<div>
							<label
								className="block text-gray-700 text-sm font-bold mb-2"
								htmlFor="funcionario">
								Funcionário
							</label>
							<input
								value={scheduling.funcionario.nome}
								className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
								type="text"
								readOnly={true}
							/>
						</div>
						<div>
							<label
								className="block text-gray-700 text-sm font-bold mb-2"
								htmlFor="preco">
								Preço
							</label>
							<input
								value={scheduling.servico.preco}
								className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
								type="text"
								readOnly={true}
							/>
						</div>
					</div>
					<div className="flex justify-between">
						<button 
            onClick={() => navigate(`/edit/${scheduling.id}`)}
            className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
							Editar
						</button>
						<button 
            onClick={() => navigate('/')}
            className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
							Voltar
						</button>
					</div>
				</form>
			</main>
		</div>
	);
}
