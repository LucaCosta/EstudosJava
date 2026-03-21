import { FormEvent, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { authService } from '../services/authService';

export function LoginPage() {
  const navigate = useNavigate();
  const [email, setEmail] = useState('admin@estudosjava.com');
  const [password, setPassword] = useState('123456');
  const [message, setMessage] = useState('');

  const handleSubmit = async (event: FormEvent<HTMLFormElement>) => {
    event.preventDefault();

    try {
      await authService.login({ email, password });
      navigate('/');
    } catch {
      setMessage('Falha ao autenticar na API. Verifique a URL configurada em VITE_API_URL.');
    }
  };

  return (
    <div className="auth-page">
      <form className="auth-card" onSubmit={handleSubmit}>
        <span className="tag">Acesso</span>
        <h1>Login</h1>
        <p>Entre com suas credenciais para consumir a API Java do projeto.</p>

        <label>
          E-mail
          <input value={email} onChange={(event) => setEmail(event.target.value)} type="email" />
        </label>

        <label>
          Senha
          <input
            value={password}
            onChange={(event) => setPassword(event.target.value)}
            type="password"
          />
        </label>

        <button type="submit">Entrar</button>

        {message ? <div className="feedback-error">{message}</div> : null}
      </form>
    </div>
  );
}
