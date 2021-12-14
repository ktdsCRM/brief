<template>
  <div id="app">
    <div>
      <Header />
    </div>
    <div>
      <Middle />
    </div>
    <div>
      <Footer />
    </div>
  </div>
</template>

<script>
import Header from "@/layout/Header.vue";
import Footer from "./layout/Footer.vue";
import Middle from "./layout/Middle.vue";
// export default defineComponent({
//   setup() {},
// });

export default {
  name: "App",
  components: {
    Header,
    Footer,
    Middle,
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center !important;
  color: #2c3e50;
  min-height: 100%;
  position: relative !important;
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

/* 스크롤바 설정*/
::-webkit-scrollbar {
  width: 9px;
}

/* 스크롤바 막대 설정*/
::-webkit-scrollbar-thumb {
  height: 17%;
  background-color: rgb(168, 234, 243);
  /* 스크롤바 둥글게 설정 */
  border-radius: 10px;
}
</style>
