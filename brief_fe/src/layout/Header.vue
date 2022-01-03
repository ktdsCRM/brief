<template>
  <div>
    <b-navbar toggleable="lg" type="dark" variant="info">
      <b-navbar-brand id="title" href="#" style="margin-left: 10%">
        <router-link to="/">BRIEF</router-link>
      </b-navbar-brand>
      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav type="light">
          <b-nav-item id="menu"
            ><router-link to="/textSummary">텍스트</router-link></b-nav-item
          >
          <b-nav-item id="menu"
            ><router-link to="/ocrSummary">사진</router-link></b-nav-item
          >
          <b-nav-item id="menu"
            ><router-link to="/sttSummary">음성</router-link></b-nav-item
          >
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
export default {
  name: "Header",
  components: {},
};
</script>

<style>
#title {
  font-family: "SDSamliphopangche_Outline";
  font-size: 23pt;
}
#nav-collapse {
  font-family: "GongGothicLight";
  font-size: 15pt;
  padding-left: 5%;
  margin-left: 5%;
}
#menu {
  margin: 0 10px;
}
a {
  text-decoration: none !important;
  color: rgba(255, 255, 255, 1) !important;
}
a:hover {
  color: rgb(255, 255, 255, 0.5) !important;
}

@font-face {
  font-family: "SDSamliphopangche_Outline";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts-20-12@1.0/SDSamliphopangche_Outline.woff")
    format("woff");
  font-weight: normal;
  font-style: normal;
}
@font-face {
  font-family: "GongGothicLight";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-10@1.0/GongGothicLight.woff")
    format("woff");
  font-weight: normal;
  font-style: normal;
}
</style>