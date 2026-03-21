import { createBrowserRouter } from 'react-router-dom';
import { AppLayout } from '../layouts/AppLayout';
import { DashboardPage } from '../pages/DashboardPage';
import { InscricoesPage } from '../pages/InscricoesPage';
import { LoginPage } from '../pages/LoginPage';
import { TreinamentosPage } from '../pages/TreinamentosPage';
import { TurmasPage } from '../pages/TurmasPage';
import { UsuariosPage } from '../pages/UsuariosPage';

export const router = createBrowserRouter([
  {
    path: '/login',
    element: <LoginPage />,
  },
  {
    path: '/',
    element: <AppLayout />,
    children: [
      { index: true, element: <DashboardPage /> },
      { path: 'treinamentos', element: <TreinamentosPage /> },
      { path: 'turmas', element: <TurmasPage /> },
      { path: 'inscricoes', element: <InscricoesPage /> },
      { path: 'usuarios', element: <UsuariosPage /> },
    ],
  },
]);
