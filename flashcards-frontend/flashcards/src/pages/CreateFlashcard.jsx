import { useState } from 'react';
import api from '../services/api';

export default function CreateFlashcard() {
  const [pergunta, setPergunta] = useState('');
  const [resposta, setResposta] = useState('');
  const [tags, setTags] = useState('');
  const [dificuldade, setDificuldade] = useState('FACIL');
  const [deckId, setDeckId] = useState('');
  const [materiaId, setMateriaId] = useState('');
  const [mensagem, setMensagem] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    const payload = {
      pergunta,
      resposta,
      tags: tags.split(',').map(tag => tag.trim()),
      dificuldade,
      deck: { id: parseInt(deckId) },
      materia: { id: parseInt(materiaId) }
    };

    try {
      await api.post('/flashcards', payload);
      setMensagem('Flashcard criado com sucesso!');
      setPergunta('');
      setResposta('');
      setTags('');
      setDificuldade('FACIL');
      setDeckId('');
      setMateriaId('');
    } catch (err) {
      console.error(err);
      setMensagem('Erro ao criar flashcard.');
    }
  };

  return (
    <div style={{ maxWidth: '500px', margin: 'auto' }}>
      <h2>Cadastro de Flashcard</h2>
      <form onSubmit={handleSubmit}>
        <label>Pergunta:</label>
        <input type="text" value={pergunta} onChange={(e) => setPergunta(e.target.value)} required />

        <label>Resposta:</label>
        <input type="text" value={resposta} onChange={(e) => setResposta(e.target.value)} required />

        <label>Tags (separadas por vírgula):</label>
        <input type="text" value={tags} onChange={(e) => setTags(e.target.value)} />

        <label>Dificuldade:</label>
        <select value={dificuldade} onChange={(e) => setDificuldade(e.target.value)}>
          <option value="FACIL">Fácil</option>
          <option value="MEDIA">Média</option>
          <option value="DIFICIL">Difícil</option>
        </select>

        <label>ID do Deck:</label>
        <input type="number" value={deckId} onChange={(e) => setDeckId(e.target.value)} required />

        <label>ID da Matéria:</label>
        <input type="number" value={materiaId} onChange={(e) => setMateriaId(e.target.value)} required />

        <button type="submit" style={{ marginTop: '10px' }}>Cadastrar</button>
      </form>
      {mensagem && <p style={{ marginTop: '10px' }}>{mensagem}</p>}
    </div>
  );
}
