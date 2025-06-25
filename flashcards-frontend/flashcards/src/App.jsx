import { Link, Outlet } from 'react-router-dom';

export default function App() {
  return (
    <div style={{ padding: '20px' }}>
      <nav style={{ marginBottom: '20px' }}>
        <Link to="/">🏠 Início</Link> | <Link to="/criar">➕ Criar Flashcard</Link>
        <Link to="/usuarios/novo">👤 Criar Usuário</Link>
        <Link to="/decks/novo">📚 Criar Deck</Link>

      </nav>
      <Outlet />
    </div>
  );
}
