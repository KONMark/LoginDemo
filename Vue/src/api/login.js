import axios from 'axios'

export function login(param1,param2){
    return axios.post('/api/login',{username:param1,password:param2})
    
}

export function JudgePassword(param1){
    return axios.post('/api/judgePassword', param1,{
        headers: {
          "Content-Type": "text/plain",
        },
      })
}

export function JudgeUsername(param1){
    return axios.post('/api/judgeusername',param1,{
        headers: {
          "Content-Type": "text/plain",
        },
      })
}

export function register(param1,param2){
    return axios.post('/api/register',{username:param1,password:param2})
}