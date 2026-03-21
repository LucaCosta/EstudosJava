import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useAuth } from '../auth/AuthContext';

export function LoginPage() {
  const { login } = useAuth();
  const navigate = useNavigate();
  const [form, setForm] = useState({ login: '', password: '' });
  const [error, setError] = useState('');

  async function handleSubmit(event) {
    event.preventDefault();
    setError('');
    try {
      await login(form.login, form.password);
      navigate('/');
    } catch (err) {
      setError(err.message);
    }
  }

  return (
    <form onSubmit={handleSubmit}>
      <h1>Entrar</h1>
      <input
        placeholder="Usuário ou e-mail"
        value={form.login}
        onChange={(event) => setForm({ ...form, login: event.target.value })}
      />
      <input
        type="password"
        placeholder="Senha"
        value={form.password}
        onChange={(event) => setForm({ ...form, password: event.target.value })}
      />
      <button type="submit">Autenticar</button>
      {error && <p>{error}</p>}
    </form>
  );
}
