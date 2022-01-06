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
        <div class="sumItem">
          <div class="sumTitle">
            <div id="sumTitleIcon">
              <font-awesome-icon :icon="['far', 'file-image']" size="2x" />
              <!-- 
                현재 해야하는 것 : 왼쪽 사이드 연결~!, css 수정
                음성 아이콘   <font-awesome-icon :icon="['far', 'file-audio']" size="2x" />
                텍스트 아이콘 <font-awesome-icon :icon="['fas', 'font']" size="2x" /> 
              -->
            </div>
            <div id="sumTitleText">
              <p>파일이름</p>
            </div>
            <div id="sumTitleDate">
              <p>2022.01.01</p>
            </div>
          </div>
          <div>
            <p>음<br />오<br />아<br />예<br /></p>
          </div>
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