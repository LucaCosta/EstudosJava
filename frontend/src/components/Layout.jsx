import { Link, Outlet } from 'react-router-dom';
import { useAuth } from '../auth/AuthContext';

export function Layout() {
  const { role, logout, isAuthenticated } = useAuth();

  return (
    <div>
      <nav>
        <Link to="/">Home</Link> | <Link to="/aluno">Área do aluno</Link>{' '}
        {(role === 'ADMIN' || role === 'INSTRUTOR') && <>| <Link to="/instrutor">Área do instrutor</Link></>}
        {role === 'ADMIN' && <>| <Link to="/admin">Painel admin</Link></>}
        {!isAuthenticated ? (
          <> | <Link to="/login">Login</Link></>
        ) : (
          <button onClick={logout}>Sair</button>
        )}
      </nav>
      <p>Perfil autenticado: {role ?? 'visitante'}</p>
      <Outlet />
    </div>
  );
}
