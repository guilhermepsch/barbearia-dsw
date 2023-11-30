import axios from "axios";
import { Schedule } from "../types";

const API_URL = 'http://localhost:8080';

const api = axios.create({
  baseURL: API_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

export async function getSchedulings(){
  const response = await api.get<Schedule[]>('/agendamentos');
  console.log(response.data);
  return response.data;
}