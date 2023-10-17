<template>
    <div>
        <div class="center"><h2 class="text-center">用户注册</h2></div>
        <hr/>
        <form class="center">
            <center>账号：&nbsp;<input type="text" name="username" v-model.trim.lazy="username" placeholder="请输入用户名" @blur="judgeusername()"/></center>
            <br/>
            <center>密码：&nbsp;<input type="password" name="password" v-model.trim="password" placeholder="请输入密码" @input="judgepassword()"/>
            </center>
            <br/>
            <center>
                <input type="submit" value="注册" @click.prevent="login()"/>&nbsp;&nbsp;&nbsp;
                <input type="reset" value="取消" @click="cancel()"/>
            </center>
            <br><br>
            <center>账号状态检测：<span :class="stateclass2">{{state2}}</span></center>
            <br>
            <center>密码状态检测：<span :class="stateclass">{{state}}</span></center>
        </form>
    </div>
</template>

<script>

    import { JudgePassword,register,JudgeUsername } from '@/api/login'

    export default{
        name:"register",
        data(){
            return{
                username:'',
                password:'',
                state:'请输入密码',
                state2:'请输入账号',
                stateclass:'',     //可替换为 warn success
                stateclass2:''
            }
        },
        methods:{
            login(){
                if(this.username.length === 0 || this.password.length === 0){
                    alert("请输入用户名和密码！")
                    this.cancel()
                }else if (this.stateclass=="success" && this.stateclass2=="success"){
                    register(this.username,this.password)
                        .then((response)=>{
                            if(response.data) {
                                alert("注册成功")
                                this.cancel()
                            }
                            else{
                                alert("注册失败，用户名或密码不符合规范！")
                                this.cancel()
                            }
                        })
                        .catch(function (error) {
                            console.log(error);
                        });
                }else{
                    alert("注册失败，请输入符合要求的账号和密码")
                    this.cancel()
                }
            },
            cancel(){
                this.username=this.password=''
                this.state="请输入密码"
                this.state2="请输入账号"
            },
            judgepassword(){
                if(this.password.length!=0){
                    JudgePassword(this.password)
                        .then((response)=>{
                            this.state=response.data;
                        })
                        .catch(function (error) {
                            console.log(error);
                        });
                }else{
                    this.state="请输入密码"
                }
            },
            judgeusername(){
                if(this.username.length!=0){
                    JudgeUsername(this.username)
                        .then((response)=>{
                            this.state2=response.data;
                        })
                        .catch(function (error) {
                            console.log(error);
                        });
                }else{
                    this.state2='请输入账号'
                }
            }
        },
            watch:{
                state(val){
                    if(val=="请输入密码")
                        this.stateclass=""
                    else if(val=="密码合规!")
                        this.stateclass="success"
                    else
                        this.stateclass="warn"
                },
                state2(val){
                    if(val=="请输入账号")
                        this.stateclass2=""
                    else if(val=="账号合规！")
                        this.stateclass2="success"
                    else
                        this.stateclass2="warn"
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
    .warn{
        color:red;
        font-weight: bold;
    }
    .success{
        color:green;
        font-weight: bold;
        font-size:25px;
    }
</style>