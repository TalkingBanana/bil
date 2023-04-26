<template>
  <nav>
    <b-button @click="test">Test Button</b-button>
  </nav>
  <router-view/>
</template>

<script>
export default{

  methods: {
    test(){
      this.axios.get("/hello").
      then((result)=>{
        console.log(result.data)
      });
      
    },
  },
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
