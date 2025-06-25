import { useState } from 'react';
import api from '../services/api';

export default function CreateUsuario() {
  const [form, setForm] = useState({
    nome: '',
    matricula: '',
    imagem: '',
    email: '',
    senha: '',
    porcentagemAcertos: '',
    porcentagemErros: ''
  });

  const [mensagem, setMensagem] = useState('');

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm(prev => ({ ...prev, [name]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await api.post('/usuario/save', {
        ...form,
        porcentagemAcertos: parseFloat(form.porcentagemAcertos),
        porcentagemErros: parseFloat(form.porcentagemErros)
      });
      setMensagem('Usuário cadastrado com sucesso!');
      setForm({
        nome: '',
        matricula: '',
        imagem: '',
        email: '',
        senha: '',
        porcentagemAcertos: '',
        porcentagemErros: ''
      });
    } catch (err) {
      console.error(err);
      setMensagem('Erro ao cadastrar usuário.');
    }
  };

  return (
    <div style={{ maxWidth: '500px', margin: 'auto' }}>
      <h2>Cadastrar Usuário</h2>
      <form onSubmit={handleSubmit}>
        <label>Nome:</label>
        <input name="nome" value={form.nome} onChange={handleChange} required />

        <label>Matrícula:</label>
        <input name="matricula" value={form.matricula} onChange={handleChange} required />

        <label>Imagem (URL):</label>
        <input name="imagem" value={form.imagem} onChange={handleChange} />

        <label>Email:</label>
        <input name="email" type="email" value={form.email} onChange={handleChange} required />

        <label>Senha:</label>
        <input name="senha" type="password" value={form.senha} onChange={handleChange} required />

        <label>% Acertos:</label>
        <input name="porcentagemAcertos" type="number" step="0.01" value={form.porcentagemAcertos} onChange={handleChange} required />

        <label>% Erros:</label>
        <input name="porcentagemErros" type="number" step="0.01" value={form.porcentagemErros} onChange={handleChange} required />

        <button type="submit" style={{ marginTop: '10px' }}>Cadastrar</button>
      </form>
      {mensagem && <p style={{ marginTop: '10px' }}>{mensagem}</p>}
    </div>
  );
}
