import axios from 'axios';

axios.defaults.withCredentials = true

const baseURL= 'http://localhost:8080/'

const api = axios.create({
    baseURL: baseURL,
    timeout: 5000,
});

// 添加请求拦截器
api.interceptors.request.use(
    config => {
        // 在请求发送前进行处理
        // 可以添加认证信息、请求头部等
        return config;
    },
    error => {
        // 处理请求错误
        return Promise.reject(error);
    }
);

// 添加响应拦截器
api.interceptors.response.use(
    response => {
        // 在响应返回后进行处理
        // 可以处理响应数据、错误信息等
        return response.data;
    },
    error => {
        // 处理响应错误
        // 可以根据错误状态码进行特定处理
        return Promise.reject(error);
    }
);

// 封装HTTP请求方法
export default {
    get: (url, config) => api.get(url, config),
    post: (url, data, config) => api.post(url, data, config),
    put: (url, data, config) => api.put(url, data, config),
    delete: (url, config) => api.delete(url, config),
    patch: (url, data, config) => api.patch(url, data, config),
    baseURL
};