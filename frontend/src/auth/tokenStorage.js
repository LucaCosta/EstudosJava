const TOKEN_KEY = 'estudosjava.auth';

export const tokenStorage = {
  save(session) {
    sessionStorage.setItem(TOKEN_KEY, JSON.stringify(session));
  },
  load() {
    const raw = sessionStorage.getItem(TOKEN_KEY);
    return raw ? JSON.parse(raw) : null;
  },
  clear() {
    sessionStorage.removeItem(TOKEN_KEY);
  }
};
