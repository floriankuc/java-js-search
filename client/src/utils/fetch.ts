import axios, { AxiosRequestConfig } from 'axios';

const configAxios: AxiosRequestConfig = {
  baseURL: import.meta.env.VITE_API_BASE_URL ?? '',
  timeout: 10 * 1000,
};

export const AxiosInstance = axios.create(configAxios);

export const fetcher = {
  async get<T>(url: string, params?: Record<string, unknown>): Promise<T> {
    const res = await AxiosInstance.get<T>(url, { params });
    return res.data;
  },
};
