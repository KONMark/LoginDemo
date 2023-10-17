<template>
    <div class="center">
        <center><h1>{{msg}} </h1></center>
        <form class="center">
            <center><input type="text" name="username" v-model.trim.lazy="username" placeholder="请输入用户名"/></center>

            <br>
            <center>
                        <input type="submit" value="登录" @click.prevent="login()"/>&nbsp;&nbsp;&nbsp;
            </center>
        </form>
        <p>{{state}}</p>
    </div>
</template>

<script>
    import axios from 'axios'
    export default{
        name:"test",
        data(){
            console.log("访问test.vue")
            return{
                msg:"用户登录",
                username:"",
                state:""
            }
        },
        methods:{
            login(){
                axios.post('http://localhost:8080/testvue', this.username)
                            .then((response)=>{
                                this.state=response.data
                            })
                            .catch(function (error) {
                                console.log("报错")
                                console.log(error.response.data);
                            });
            }
        }

    }
</script>

<style>
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