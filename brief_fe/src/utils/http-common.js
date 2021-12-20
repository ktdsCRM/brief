import axios from 'axios';

// axios 객체 생성
export default axios.create({
    // Spring Server로 접근한다.
    baseURL: 'http://localhost:9090/',
    headers: {
        'Access-Control-Allow-Origin': '*',
        'Content-type': 'application/json',
    },
});