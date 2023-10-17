<template>
    <div>
        <div class="center"><h2 class="text-center">用户登录</h2></div>
        <hr/>
        <form class="center">
            <center>账号：&nbsp;<input type="text" name="username" v-model.trim.lazy="username" placeholder="请输入用户名"/></center>
            <br/>
            <center>密码：&nbsp;<input type="password" name="password" v-model.trim="password" placeholder="请输入密码"/></center>
            <br/>
            <center>
                    <input type="submit" value="登录" @click.prevent="login1()"/>&nbsp;&nbsp;&nbsp;
                    <input type="reset" value="取消" @click="cancel()"/>
            </center><br/>
            <center>{{state}}</center>
        </form>
    </div>
</template>

<script>
    import {login} from '../api/login' 

    export default{
        name:"index",
        data(){
            return{
                username:'',
                password:'',
                state:''
            }
        },
        methods:{
            login1(){
                if(this.username.length === 0 || this.password.length === 0){
                    alert("请输入用户名和密码！")
                    this.cancel()
                }else{
                    login(this.username,this.password)
                        .then((response)=>{
                            console.log(response.data);
                            this.state=response.data;
                            this.username=this.password='';
                        })
                        .catch(function (error) {
                            console.log(error);
                        });
                    console.log(123)
                    // axios.interceptors.request.use(()=>)
                }
            },
            cancel(){
                this.username=this.password=this.state=''
            }
        }
    }
</script>

<style scoped>
    .center{
        margin:auto;
        width:50%;		/*反正就是要设置一个width*/
    }
    form.center{
        margin-top:2%;
        margin-bottom:2%;
    }
    .text-center{
        text-align: center;
    }
</style>