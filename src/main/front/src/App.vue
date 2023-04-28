<template>
  <PageHeader/> <!--헤더 컴포넌트-->
  <nav>
    <b-button @click="test">Test Button</b-button>
  </nav>
  <router-view/>
  <PageFooter/> <!--푸터 컴포넌트-->
</template>

<script>
  import PageHeader from '@/components/common/PageHeader.vue';
  import PageFooter from '@/components/common/PageFooter.vue';

  export default {
    name: 'App',
    components: {
      PageFooter,
      PageHeader
    },
    methods: {
      test(){
        this.axios.get("/api/hello").
        then((result)=>{
          console.log(result.data)
        });
      }
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
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
