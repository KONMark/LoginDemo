<template>
  <div id="app">
    <index></index>
    <register></register>
  </div>
</template>

<script>
import index from './components/index.vue'
import register from './components/register.vue'

export default {
  name: 'App',
  components: {
    index,
    register,
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

