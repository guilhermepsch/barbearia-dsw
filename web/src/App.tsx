import { Route, Routes } from 'react-router-dom';
import ItemList from './components/ItemList';
import ItemDetails from './components/ItemDetails';
import ItemForm from './components/ItemForm';

export default function App() {
	return (
		<>
		<Routes>
			<Route path="/" Component={ItemList} />
			<Route path="/scheduling/:id" Component={ItemDetails} />
			<Route path="/add" Component={ItemForm} />
			<Route path="/edit/:id" Component={ItemForm} />
			<Route path="*" Component={() => <h1>404 Not Found</h1>} />
		</Routes>
		</>
	);
}
