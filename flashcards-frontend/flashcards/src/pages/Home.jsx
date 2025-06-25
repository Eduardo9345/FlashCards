import { useEffect, useState } from 'react';
import api from '../services/api';
import Flashcard from '../components/Flashcard';

export default function Home() {
  const [flashcards, setFlashcards] = useState([]);

  useEffect(() => {
    api.get('/flashcards')
      .then(res => setFlashcards(res.data))
      .catch(err => console.error("Erro ao buscar flashcards:", err));
  }, []);

  return (
    <div>
      <h1>Meus Flashcards</h1>
      <div style={{ display: 'flex', flexWrap: 'wrap' }}>
        {flashcards.map(card => (
          <Flashcard key={card.id} front={card.front} back={card.back} />
        ))}
      </div>
    </div>
  );
}
