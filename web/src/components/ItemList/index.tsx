import { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { getSchedulings } from '../../api/api';
import { Schedule } from '../../types';

export default function ItemList() {
	const [scheduling, setScheduling] = useState<Schedule[]>([]);
  const navigate = useNavigate();

	useEffect(() => {
		getSchedulings().then(scheduling => setScheduling(scheduling));
	}, []);

  const handleClickSchedule = (id: number) => {
    navigate(`/scheduling/${id}`);
  }

	return (
		<div className="bg-gray-100 min-h-screen">
			{/* Header Section */}
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
				<h2 className="text-2xl font-bold mb-4">
					Barbershop Current Schedulings
				</h2>
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
						</tr>
					</thead>
					<tbody>
						{scheduling.map(schedule => {
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
								<tr key={schedule.id} className="hover:bg-gray-100" onClick={() => handleClickSchedule(schedule.id)}>
									<td className="p-4">{schedule.id}</td>
									<td className="p-4">{schedule.clienteNome}</td>
									<td className="p-4">{schedule.emailCliente}</td>
									<td className="p-4">{date}</td>
									<td className="p-4">{time}</td>
									<td className="p-4">{schedule.servico.nome}</td>
									<td className="p-4">
										{schedule.funcionario.nome}
									</td>
									<td className="p-4">
										{schedule.servico.preco}
									</td>
								</tr>
							);
						})}
					</tbody>
				</table>
			</main>

			{/* About Section */}
			<section className="bg-gray-200 py-8">
				<div className="max-w-2xl mx-auto">
					<h2 className="text-2xl font-bold mb-4">
						About Our Barbershop
					</h2>
					<p>
						Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Nulla luctus libero et efficitur eleifend. Vivamus sit
						amet lacus nec leo convallis bibendum. Fusce eu
						ullamcorper lacus.
					</p>
				</div>
			</section>

			{/* Footer Section */}
			<footer className="bg-gray-800 text-white p-4 mt-8">
				<div className="max-w-2xl mx-auto">
					<p>&copy; 2023 Your Barbershop. All rights reserved.</p>
					<p>Contact us at info@barbershop.com</p>
				</div>
			</footer>
		</div>
	);
}
