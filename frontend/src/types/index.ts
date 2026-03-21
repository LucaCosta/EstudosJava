export interface NavItem {
  label: string;
  path: string;
  description: string;
}

export interface DashboardMetric {
  label: string;
  value: string;
  helperText: string;
}

export interface Credentials {
  email: string;
  password: string;
}

export interface ApiListResponse<T> {
  data: T[];
  total: number;
}

export interface Training {
  id: number;
  nome: string;
  descricao: string;
  cargaHoraria: number;
}

export interface ClassGroup {
  id: number;
  nome: string;
  treinamentoId: number;
  inicio: string;
  fim: string;
}

export interface Enrollment {
  id: number;
  turmaId: number;
  usuarioId: number;
  status: 'PENDENTE' | 'CONFIRMADA' | 'CANCELADA';
}

export interface User {
  id: number;
  nome: string;
  email: string;
  perfil: string;
}
