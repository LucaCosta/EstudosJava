import { NavLink, Outlet } from 'react-router-dom';
import type { NavItem } from '../types';

const navItems: NavItem[] = [
  { label: 'Dashboard', path: '/', description: 'Visão geral da operação' },
  { label: 'Treinamentos', path: '/treinamentos', description: 'Catálogo de treinamentos' },
  { label: 'Turmas', path: '/turmas', description: 'Agenda e turmas abertas' },
  { label: 'Inscrições', path: '/inscricoes', description: 'Acompanhamento de inscrições' },
  { label: 'Usuários', path: '/usuarios', description: 'Gestão de usuários e perfis' },
];

export function AppLayout() {
  return (
    <div className="app-shell">
      <aside className="sidebar">
        <div className="brand">
          <span className="brand-badge">EJ</span>
          <div>
            <strong>Estudos Java</strong>
            <p>Portal administrativo</p>
          </div>
        </div>

        <nav className="nav-menu" aria-label="Menu principal">
          {navItems.map((item) => (
            <NavLink
              key={item.path}
              to={item.path}
              end={item.path === '/'}
              className={({ isActive }) =>
                isActive ? 'nav-link nav-link-active' : 'nav-link'
              }
            >
              <span>{item.label}</span>
              <small>{item.description}</small>
            </NavLink>
          ))}
        </nav>
      </aside>

      <main className="content">
        <header className="topbar">
          <div>
            <span className="tag">React + TypeScript</span>
            <h2>Frontend para consumo da API Java</h2>
          </div>
          <NavLink to="/login" className="ghost-button">
            Sair
          </NavLink>
        </header>

        <section className="page-content">
          <Outlet />
        </section>
      </main>
    </div>
  );
}
