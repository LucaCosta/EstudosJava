interface InfoCardProps {
  title: string;
  subtitle: string;
}

export function InfoCard({ title, subtitle }: InfoCardProps) {
  return (
    <article className="info-card">
      <h3>{title}</h3>
      <p>{subtitle}</p>
    </article>
  );
}
