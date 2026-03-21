import { InfoCard } from '../components/InfoCard';
import { PageHeader } from '../components/PageHeader';

export function TurmasPage() {
  return (
    <>
      <PageHeader
        title="Turmas"
        description="Base para gestão de cronogramas, vagas e responsáveis por turma."
      />

      <div className="info-grid">
        <InfoCard title="Integração sugerida" subtitle="Consumir GET /turmas com a trainingService." />
        <InfoCard title="Recursos futuros" subtitle="Calendário, status e capacidade de cada turma." />
      </div>
    </>
  );
}
