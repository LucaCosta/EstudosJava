import { http } from './http';
import type { ApiListResponse, ClassGroup, Enrollment, Training, User } from '../types';

export const trainingService = {
  listTrainings: async () => {
    const response = await http.get<ApiListResponse<Training>>('/treinamentos');
    return response.data;
  },
  listClasses: async () => {
    const response = await http.get<ApiListResponse<ClassGroup>>('/turmas');
    return response.data;
  },
  listEnrollments: async () => {
    const response = await http.get<ApiListResponse<Enrollment>>('/inscricoes');
    return response.data;
  },
  listUsers: async () => {
    const response = await http.get<ApiListResponse<User>>('/usuarios');
    return response.data;
  },
};
