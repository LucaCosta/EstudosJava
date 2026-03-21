import { InfoCard } from '../components/InfoCard';
import { PageHeader } from '../components/PageHeader';

export function UsuariosPage() {
  return (
    <>
      <PageHeader
        title="Usuários"
        description="Base da administração de perfis, permissões e dados cadastrais."
      />

      <div className="info-grid">
        <InfoCard title="Serviço pronto" subtitle="Use trainingService.listUsers para carregar dados da API." />
        <InfoCard title="Próximas melhorias" subtitle="Listagem, edição e associação de perfis de acesso." />
      </div>
    </>
  );
}
