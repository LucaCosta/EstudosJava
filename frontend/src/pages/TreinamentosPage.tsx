import { InfoCard } from '../components/InfoCard';
import { PageHeader } from '../components/PageHeader';

const trainingHighlights = [
  'Crie listagens, detalhes e formulários integrados com /treinamentos.',
  'Adicione filtros, paginação e upload de materiais.',
  'Reutilize os tipos centrais definidos em src/types.',
];

export function TreinamentosPage() {
  return (
    <>
      <PageHeader
        title="Treinamentos"
        description="Área inicial para consulta e manutenção do catálogo de treinamentos."
      />

      <div className="info-grid">
        {trainingHighlights.map((item) => (
          <InfoCard key={item} title="Próximo passo" subtitle={item} />
        ))}
      </div>
    </>
  );
}
