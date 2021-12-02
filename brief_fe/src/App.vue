<template>
  <div id="app">
    <div>
      <Header />
    </div>
    <div>
      <Footer />
    </div>
  </div>
</template>

<script>
import Header from "@/layout/Header.vue";
import Footer from "./layout/Footer.vue";
// export default defineComponent({
//   setup() {},
// });

export default {
  name: "App",
  components: {
    Header,
    Footer,
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  min-height: 100%;
  position: relative;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
