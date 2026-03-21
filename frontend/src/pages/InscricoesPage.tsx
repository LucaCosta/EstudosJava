import { InfoCard } from '../components/InfoCard';
import { PageHeader } from '../components/PageHeader';

export function InscricoesPage() {
  return (
    <>
      <PageHeader
        title="Inscrições"
        description="Página base para acompanhamento do funil de inscrição dos participantes."
      />

      <div className="info-grid">
        <InfoCard title="Endpoint esperado" subtitle="Mapear fluxo com GET /inscricoes e ações de aprovação." />
        <InfoCard title="Evolução natural" subtitle="Adicionar filtros por turma, usuário e status." />
      </div>
    </>
  );
}
