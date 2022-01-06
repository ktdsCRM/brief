<template>
  <div class="sumList">
    <div class="list">
      <div id="subTitle">
        <p>요약 기록</p>
      </div>
      <hr />
      <div>
        <div class="sumItem">
          <div class="sumTitle">
            <div id="sumTitleIcon">
              <font-awesome-icon :icon="['far', 'file-image']" size="2x" />
              <!-- 
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
        <div class="sumItem">
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
import "@/fontAwesomeIcon.js";

export default {
  data: function () {
    return {
      sumData: [],
    };
  },
};
</script>

<style>
.sumlist {
  height: 100%;
}
.list {
  float: left;
  width: 30%;
  min-height: 92vh;
  background-color: rgb(199, 235, 240);
  font-family: "NanumSquareRound";
  overflow: scroll;
}

.detail {
  float: right;
  height: 92vh;
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
.sumItem {
  border: 1px solid white;
  border-radius: 8px;
  background-color: white;
  margin: 10px;
  padding: 5px;
}
.sumTitle {
  margin: 7pt 10pt 0 10pt;
}
#sumTitleIcon {
  float: left;
  vertical-align: middle;
}
#sumTitleText {
  /* display: inline-block; */
  float: left;
  vertical-align: middle;
  margin-left: 10pt;
}
#sumTitleDate {
  vertical-align: middle;
  float: right;
}
.right {
  min-height: 92vh;
  text-align: right !important;
}
</style>