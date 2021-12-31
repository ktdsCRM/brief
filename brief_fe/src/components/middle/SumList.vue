<template>
  <div class="sumList">
    <div class="list">
      <div id="subTitle">
        <p>요약 기록</p>
      </div>
      <hr />
      <div>
        <div class="item">
          <p>음<br />오<br />아<br />예<br /></p>
        </div>
        <div class="item">
          <p>음<br />오<br />아<br />예<br /></p>
        </div>
      </div>
    </div>
    <div class="right">
      <p>hello</p>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
.sumlist {
  height: 100%;
}
.list {
  float: left;
  width: 30%;
  height: 90vh;
  background-color: rgb(199, 235, 240);
}
.detail {
  float: right;
  height: 80vh;
}
#subTitle {
  text-align: left;
  padding: 20px 0 0 40px;
  font-family: "GongGothicLight";
  font-size: 14pt;
  color: rgb(99, 98, 98);
  /* text-shadow: -1px 0 rgb(255, 255, 255), 0 1px rgb(255, 255, 255), */
  /* 1px 0 rgb(255, 255, 255), 0 -1px rgb(255, 255, 255); */
}
.item {
  border: 1px solid white;
  border-radius: 8px;
  background-color: white;
  margin: 10px;
  padding: 5px;
}
</style>