import api from "./api";

export const login = (loginData) => {
  // later: POST /auth/login
  return api.post("/auth/login", loginData);
};

export const signup = (signupData) => {
  // later: POST /auth/signup
  return api.post("/auth/signup", signupData);
};
