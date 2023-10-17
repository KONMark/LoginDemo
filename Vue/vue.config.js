const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,  
  devServer: {
    port: 8000,
    proxy:{
      "/api":{
        target:"http://localhost:8050",   //代理
        changeOrigin: true,
        pathRewrite: {    //代替
          '^/api': ''
        }
      }
    }
  },

})

//nginx