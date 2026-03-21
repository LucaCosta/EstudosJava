import { useAuth } from '../auth/AuthContext';

export function HomePage() {
  const { role } = useAuth();

  return (
    <section>
      <h1>Portal EstudosJava</h1>
      <p>Faça login com admin/admin123, instrutor/instrutor123 ou aluno/aluno123.</p>
      <p>Ações visíveis conforme o perfil: {role ?? 'nenhum'}.</p>
    </section>
  );
}
