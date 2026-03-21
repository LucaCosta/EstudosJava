import { createContext, useContext, useMemo, useState } from 'react';
import { tokenStorage } from './tokenStorage';

const AuthContext = createContext(null);

export function AuthProvider({ children }) {
  const [session, setSession] = useState(() => tokenStorage.load());

  async function login(login, password) {
    const response = await fetch('http://localhost:8080/auth/login', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ login, password })
    });

    if (!response.ok) {
      throw new Error('Credenciais inválidas');
    }

    const data = await response.json();
    tokenStorage.save(data);
    setSession(data);
  }

  function logout() {
    tokenStorage.clear();
    setSession(null);
  }

  const value = useMemo(() => ({
    session,
    isAuthenticated: Boolean(session?.token),
    role: session?.role,
    token: session?.token,
    login,
    logout,
    hasRole: (...roles) => roles.includes(session?.role)
  }), [session]);

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
}

export function useAuth() {
  const context = useContext(AuthContext);
  if (!context) {
    throw new Error('useAuth deve ser usado dentro de AuthProvider');
  }
  return context;
}
