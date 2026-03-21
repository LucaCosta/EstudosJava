import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { AuthProvider } from './auth/AuthContext';
import { Layout } from './components/Layout';
import { ProtectedRoute } from './routes/ProtectedRoute';
import { AdminPage } from './pages/AdminPage';
import { AlunoPage } from './pages/AlunoPage';
import { HomePage } from './pages/HomePage';
import { InstrutorPage } from './pages/InstrutorPage';
import { LoginPage } from './pages/LoginPage';
import { UnauthorizedPage } from './pages/UnauthorizedPage';

export default function App() {
  return (
    <AuthProvider>
      <BrowserRouter>
        <Routes>
          <Route element={<Layout />}>
            <Route index element={<HomePage />} />
            <Route path="login" element={<LoginPage />} />
            <Route path="unauthorized" element={<UnauthorizedPage />} />
            <Route element={<ProtectedRoute allowedRoles={['ADMIN', 'INSTRUTOR', 'ALUNO']} />}>
              <Route path="aluno" element={<AlunoPage />} />
            </Route>
            <Route element={<ProtectedRoute allowedRoles={['ADMIN', 'INSTRUTOR']} />}>
              <Route path="instrutor" element={<InstrutorPage />} />
            </Route>
            <Route element={<ProtectedRoute allowedRoles={['ADMIN']} />}>
              <Route path="admin" element={<AdminPage />} />
            </Route>
          </Route>
        </Routes>
      </BrowserRouter>
    </AuthProvider>
  );
}
