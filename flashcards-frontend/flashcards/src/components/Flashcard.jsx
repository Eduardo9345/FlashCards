import './Flashcard.css';

export default function Flashcard({ front, back }) {
  return (
    <div className="flashcard">
      <div className="front">{front}</div>
      <div className="back">{back}</div>
    </div>
  );
}
