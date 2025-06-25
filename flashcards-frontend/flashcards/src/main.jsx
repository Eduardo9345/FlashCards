import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import App from './App.jsx';
import Home from './pages/Home.jsx';
import CreateFlashcard from './pages/CreateFlashcard.jsx';
import CreateUsuario from './pages/CreateUsuario';
import CreateDeck from './pages/CreateDeck';

ReactDOM.createRoot(document.getElementById('root')).render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<App />}>
        <Route index element={<Home />} />
        <Route path="criar" element={<CreateFlashcard />} />
        <Route path="/usuarios/novo" element={<CreateUsuario />} />
        <Route path="/decks/novo" element={<CreateDeck />} />

      </Route>
    </Routes>
  </BrowserRouter>
);
