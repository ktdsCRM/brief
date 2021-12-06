<template>
  <div>
    <b-navbar toggleable="lg" type="dark" variant="info">
      <b-navbar-brand id="title" href="#" style="margin-left: 10%"
        >BRIEF</b-navbar-brand
      >
      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav type="light">
          <b-nav-item id="menu"
            ><router-link to="/textSummary">텍스트</router-link></b-nav-item
          >
          <b-nav-item id="menu"
            ><router-link to="/test">사진</router-link></b-nav-item
          >
          <b-nav-item id="menu">음성</b-nav-item>
        </b-navbar-nav>

        <!-- Right aligned nav items -->
        <!-- <b-navbar-nav class="ml-auto">
          <b-nav-item-dropdown text="Lang" right>
            <b-dropdown-item href="#">EN</b-dropdown-item>
            <b-dropdown-item href="#">ES</b-dropdown-item>
            <b-dropdown-item href="#">RU</b-dropdown-item>
            <b-dropdown-item href="#">FA</b-dropdown-item>
          </b-nav-item-dropdown>

          <b-nav-item-dropdown right>
            <template #button-content>
              <em>User</em>
            </template>
            <b-dropdown-item href="#">Profile</b-dropdown-item>
            <b-dropdown-item href="#">Sign Out</b-dropdown-item>
          </b-nav-item-dropdown>
        </b-navbar-nav> -->
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
  color: rgba(255, 255, 255, 1);
  margin: 0 10px;
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