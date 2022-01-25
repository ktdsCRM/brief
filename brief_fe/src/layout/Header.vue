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
          <b-nav-item id="menu"
            ><router-link to="/sumList">기록</router-link></b-nav-item
          >
        </b-navbar-nav>
        <div class='rightTop'>
          <div class='userImg'>
            <img class="rightImogi" src="../assets/박세진.png" alt="jihye" width="50" height="50">
            <img class="rightImogi" src="../assets/오지혜.png" alt="jihye" width="50" height="50">
            <img class="rightImogi" src="../assets/조안나.png" alt="jihye" width="50" height="50">
          </div>
          <p class='userWord'>혼자서는 작은 일도 어렵지만, 함께라면 많은 것을 할 수 있어요</p>
        </div>
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
.rightTop{
  margin-left:35%;
}
.userImg {
  text-align: left;
}
.rightImogi{
  border-radius:50%;
  margin: 0 5px;
  max-width:50;
}
.userWord{
  margin-top:2pt;
  font-size:3pt;
  height:3pt;
}
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