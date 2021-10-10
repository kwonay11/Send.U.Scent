import axios from "axios";
import { API_BASE_URL } from "../utils/config.js";
// axios 객체 생성

export default axios.create({
  baseURL: API_BASE_URL,
  headers: {
    "Content-type": 'application/json;charset=utf-8',
    'Access-Control-Allow-Origin' : '*',
    'Access-Control-Allow-Methods' : 'GET, POST, PATCH, PUT, DELETE, OPTIONS',
    "Access-Control-Allow-Headers": "Origin, Content-Type",
  }
});
