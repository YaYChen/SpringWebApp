<template>
  <div id="app" class="layout_main">
    <app-header></app-header>
    <router-view/>
    <app-footer></app-footer>
  </div>
</template>

<script>

import Header from './components/public/Header'
import Footer from './components/public/Footer'

export default {
  name: 'App',
  data(){
    return {
 
    }
  },
  components: {
        'app-header':Header,
        'app-footer':Footer,
  },
  methods:{
    
  }


}
</script>

<style>
.layout_main{
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  width: 100%;
  margin: 0 auto;
  height: 100%;
}

</style>
