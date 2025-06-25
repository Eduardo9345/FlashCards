import { useState } from 'react';
import api from '../services/api';

export default function CreateDeck() {
  const [titulo, setTitulo] = useState('');
  const [descricao, setDescricao] = useState('');
  const [categoria, setCategoria] = useState('');
  const [usuarioId, setUsuarioId] = useState('');
  const [mensagem, setMensagem] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    const payload = {
      titulo,
      descricao,
      categoria,
      usuario: {
        id: parseInt(usuarioId)
      }
    };

    try {
      await api.post('/decks', payload);
      setMensagem('Deck criado com sucesso!');
      setTitulo('');
      setDescricao('');
      setCategoria('');
      setUsuarioId('');
    } catch (error) {
      console.error(error);
      setMensagem('Erro ao criar deck.');
    }
  };

  return (
    <div style={{ maxWidth: '500px', margin: 'auto' }}>
      <h2>Cadastrar Novo Deck</h2>
      <form onSubmit={handleSubmit}>
        <label>Título:</label>
        <input type="text" value={titulo} onChange={(e) => setTitulo(e.target.value)} required />

        <label>Descrição:</label>
        <input type="text" value={descricao} onChange={(e) => setDescricao(e.target.value)} required />

        <label>Categoria:</label>
        <input type="text" value={categoria} onChange={(e) => setCategoria(e.target.value)} required />

        <label>ID do Usuário:</label>
        <input type="number" value={usuarioId} onChange={(e) => setUsuarioId(e.target.value)} required />

        <button type="submit" style={{ marginTop: '10px' }}>Cadastrar</button>
      </form>
      {mensagem && <p style={{ marginTop: '10px' }}>{mensagem}</p>}
    </div>
  );
}
