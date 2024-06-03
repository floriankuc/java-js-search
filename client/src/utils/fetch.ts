import axios, { AxiosRequestConfig } from 'axios';

const configAxios: AxiosRequestConfig = {
    // In the real world this would be in an .env
  baseURL: "http://localhost:8443/rest/intern",
  timeout: 10 * 1000,
};

export const AxiosInstance = axios.create(configAxios);

export const fetcher = {
  async get<T>(url: string, params?: Record<string, unknown>): Promise<T> {
    const res = await AxiosInstance.get<T>(url, { params });
    return res.data;
  },
};
