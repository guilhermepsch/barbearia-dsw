import { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { deleteAtendimento, getSchedulings } from '../../api/api';
import { Schedule } from '../../types';
import { Pencil, X, Eye } from '@phosphor-icons/react';
import { formatMoney } from '../../utils/money';
import Header from '../Header';

export default function ItemList() {
	const [scheduling, setScheduling] = useState<Schedule[]>([]);
	const [searchTerm, setSearchTerm] = useState<string>('');
	const [filteredScheduling, setFilteredScheduling] = useState<Schedule[]>(
		[],
	);
	const navigate = useNavigate();

	useEffect(() => {
		getSchedulings().then(scheduling => {
			setScheduling(scheduling);
			setFilteredScheduling(scheduling);
		});
	}, []);

	useEffect(() => {
		const filteredData = scheduling.filter(schedule =>
			schedule.clienteNome
				.toLowerCase()
				.includes(searchTerm.toLowerCase()),
		);
		setFilteredScheduling(filteredData);
	}, [searchTerm, scheduling]);

	function handleDelete(id: number) {
		const isConfirmed = window.confirm(
      'Tem certeza que deseja excluir este atendimento?'
    );
    if (!isConfirmed) {
			return
    }
		deleteAtendimento(id).then(() => {
			setScheduling(scheduling.filter(schedule => schedule.id !== id));
		});
	}

	return (
		<div className="bg-gray-100 min-h-screen">
			<Header />

			{/* Main Content */}
			<main className="max-w-4xl mx-auto mt-8">
				<h2 className="text-2xl font-bold mb-4">Atendimentos</h2>
				<div className="mt-4 mb-4">
					<input
						type="text"
						placeholder="Busca por nome do cliente"
						value={searchTerm}
						onChange={e => setSearchTerm(e.target.value)}
						className="p-2 border border-gray-300 rounded"
					/>
				</div>
				<table className="w-full bg-white">
					<thead>
						<tr className="bg-gray-100 border-b border-gray-300">
							<th className="text-left p-4">Id</th>
							<th className="text-left p-4">Nome do Cliente</th>
							<th className="text-left p-4">Email do Cliente</th>
							<th className="text-left p-4">Data</th>
							<th className="text-left p-4">Hora</th>
							<th className="text-left p-4">Serviço</th>
							<th className="text-left p-4">Funcionário</th>
							<th className="text-left p-4">Preço</th>
							<th className=" text-center p-4" colSpan={3}>
								Ações
							</th>
						</tr>
					</thead>
					<tbody>
						{filteredScheduling.map(schedule => {
							const dataHora = new Date(schedule.dataHora);
							const date =
								(dataHora.getDate() < 10 ? '0' : '') +
								dataHora.getDate() +
								'/' +
								(dataHora.getMonth() + 1 < 10 ? '0' : '') +
								(dataHora.getMonth() + 1) +
								'/' +
								dataHora.getFullYear();
							const time =
								(dataHora.getHours() < 10 ? '0' : '') +
								dataHora.getHours() +
								':' +
								(dataHora.getMinutes() < 10 ? '0' : '') +
								dataHora.getMinutes();
							return (
								<tr
									key={schedule.id}
									className="hover:bg-gray-100">
									<td className="p-4">{schedule.id}</td>
									<td className="p-4">
										{schedule.clienteNome}
									</td>
									<td className="p-4">
										{schedule.emailCliente}
									</td>
									<td className="p-4">{date}</td>
									<td className="p-4">{time}</td>
									<td className="p-4">
										{schedule.servico.nome}
									</td>
									<td className="p-4">
										{schedule.funcionario.nome}
									</td>
									<td className="p-4">
										{formatMoney(schedule.servico.preco)}
									</td>
									<td className="p-4">
										<button
											onClick={() =>
												navigate(
													`/scheduling/${schedule.id}`,
												)
											}>
											<Eye size={32} />
										</button>
									</td>
									<td className="p-4">
										<button
											onClick={() =>
												navigate(`/edit/${schedule.id}`)
											}>
											<Pencil size={32} />
										</button>
									</td>
									<td className="p-4">
										<button onClick={() => handleDelete(schedule.id)}>
											<X size={32} />
										</button>
									</td>
								</tr>
							);
						})}
					</tbody>
				</table>

				{/* Add Item Button */}
				<div className="mt-8">
					<button
						className="bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded"
						onClick={() => navigate('/add')}>
						Novo atendimento
					</button>
				</div>
			</main>

			{/* About Section */}
			<section className="bg-gray-200 py-8 mt-8">
				<div className="max-w-2xl mx-auto">
					<h2 className="text-2xl font-bold mb-4">
						Sobre a weBarbearia
					</h2>
					<p>
						Nós da weBarbearia temos como objetivo proporcionar a
						melhor experiência para nossos clientes. Para isso,
						contamos com os melhores profissionais da cidade, que
						estão sempre prontos para atender nossos clientes. A
						weBarbearia é uma empresa fictícia criada para o
						trabalho final da disciplina de Desenvolvimento Web do
						curso de Engenharia de Software da UDESC - CEAVI.
					</p>
				</div>
			</section>
		</div>
	);
}
