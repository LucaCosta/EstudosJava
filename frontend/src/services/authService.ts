import { http } from './http';
import type { Credentials } from '../types';

export const authService = {
  login: async (credentials: Credentials) => {
    const response = await http.post('/auth/login', credentials);
    return response.data;
  },
};
