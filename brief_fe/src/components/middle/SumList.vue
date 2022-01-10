<template>
  <div class="sumList">
    <!-- 왼쪽 기록 항목 -->
    <div class="list">
      <div id="subTitle">
        <p>요약 기록</p>
      </div>
      <hr />
      <!--  -->
      <button v-for="(record, idx) in sendList" v-bind:key="idx" class="sumItem" id="sumItem" @click="boardSelect(record)">
        <div class="sumTitle">
          <div v-if="record.type === 'text'" id="sumTitleIcon">
            <font-awesome-icon :icon="['far', 'file-image']" size="2x" style="vertical-align:middle;" />
            <span><strong>&nbsp;&nbsp;Text</strong></span>
          </div>
          <div v-else-if="record.type === 'ocr'" id="sumTitleIcon">
            <font-awesome-icon :icon="['fas', 'font']" size="2x" style="vertical-align:middle;" />
            <span><strong>&nbsp;&nbsp;{{record.fileName}}</strong></span>
          </div>
          <div v-else id="sumTitleIcon">
            <font-awesome-icon :icon="['far', 'file-audio']" size="2x" style="vertical-align:middle;" />
            <span><strong>&nbsp;&nbsp;{{record.fileName}}</strong></span>
          </div>
          <div id="sumTitleDate">
            <p>{{record.createDate}}</p>
          </div>
        </div>
        <div class="sumTitleSummary">
          <p>{{record.sumText.substring(0,31) + "..."}}</p>
        </div>
      </button>
    </div>

    <!-- 오른쪽 내용 -->
    <div class="right">
      <div class="sumListHeader">
        <div v-if="this.type === 'text'" id="sumListTitleIcon">
          <font-awesome-icon :icon="['far', 'file-image']" size="3x" style="vertical-align:middle;"/>
          <span> &nbsp;&nbsp;{{this.createDate}} </span>
          <p> 원본파일명 : Text </p>
        </div>
        <div v-else-if="this.type === 'ocr'" id="sumListTitleIcon">
          <font-awesome-icon :icon="['fas', 'font']" size="3x" style="vertical-align:middle;"/>
          <span> &nbsp;&nbsp;{{this.createDate}} </span>
          <p> 원본파일명 : {{this.fileName}} </p>
        </div>
        <div v-else id="sumListTitleIcon">
          <font-awesome-icon :icon="['far', 'file-audio']" size="3x" style="vertical-align:middle;"/>
          <span> &nbsp;&nbsp;{{this.createDate}} </span>
          <p> 원본파일명 : {{this.fileName}} </p>
        </div>
      </div>  

      <div class="infoText">
        <p class="summaryInfoText"><strong>추출된 텍스트</strong></p>
      </div>
      <p class="inputTextBox" id="input" ref="input">
        {{this.text}}
      </p>
      <div></div>
      <div class="topIcon" style="float:center">
      
      <font-awesome-icon icon="caret-down" />
    </div>
      <div class="infoText">
        <p class="summaryInfoText"><strong>요약된 텍스트</strong></p>
      </div>
      <p class="inputTextBox" id="input" ref="input">
        {{this.sumText}}
      </p>
    </div>
  </div>
</template>


<script>
import "@/fontAwesomeIcon.js";
import http from "@/utils/http-common";

export default {
  data() {
    return {
      sendList: '',
      text:'',
      sumText:'',
      type:'',
      fileName:'',
      createDate:'',
    }
  },
  mounted(){
    http
      .get("board/info")
      .then(response => (this.sendList = response.data));
  },
  methods: {
    boardSelect(index) {
      this.text = index.text;
      this.sumText = index.sumText;
      this.type = index.type;
      this.fileName = index.fileName;
      this.createDate = index.createDate;
    }
  }
};
</script>

<style>
.summaryInfoText {
  text-align:center;
  /* width: 600px; */
  /* text-indent:20%; */
}
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
  margin: 10px 10px 3px 10px;
  padding: 5px;
  height : 100px;
  width : 92% ;
}
.sumItem:hover {
  border-color: rgb(90, 216, 197);
  border: 5px solid rgb(90, 216, 197);
  margin: 6.5px;
  border-radius:10px;
}
.sumTitle {
  margin: 6pt 10pt 2pt 10pt;
  height: 25pt;
  align-items: flex-start;
}
#sumTitleIcon {
  float: left;
  vertical-align: middle;
}
#sumTitleDate {
  vertical-align: middle;
  float: right;
  font-size:10pt;
}
.sumTitleSummary{
  margin: 6pt 10pt 4pt 10pt;
  height: 50px;
  align-items: flex-end;
  font-size: 12pt;
  text-align: left;
}
.right {
  float: right;
  width: 70%;
  height: 92vh;
}
.sumListHeader{
  margin: 5% 0px 0px 20%;
  text-align: left;
}
#sumListTitleIcon {
  float: center;
  vertical-align: middle;
}

</style>