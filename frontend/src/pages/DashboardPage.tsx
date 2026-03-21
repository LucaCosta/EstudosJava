import { InfoCard } from '../components/InfoCard';
import { PageHeader } from '../components/PageHeader';
import type { DashboardMetric } from '../types';

const metrics: DashboardMetric[] = [
  { label: 'Treinamentos ativos', value: '12', helperText: 'Catálogo publicado na API' },
  { label: 'Turmas abertas', value: '5', helperText: 'Turmas com matrícula disponível' },
  { label: 'Inscrições pendentes', value: '18', helperText: 'Aguardando validação' },
];

export function DashboardPage() {
  return (
    <>
      <PageHeader
        title="Dashboard"
        description="Visão inicial do portal para monitorar indicadores e atalhos de operação."
      />

      <div className="metrics-grid">
        {metrics.map((metric) => (
          <InfoCard
            key={metric.label}
            title={`${metric.value} · ${metric.label}`}
            subtitle={metric.helperText}
          />
        ))}
      </div>
    </>
  );
}
