<template>
  <div class="TextSummary">
    <div class="inputText">
      <div class="infoText">
        <p>요약할 원문을 하단에 입력해주세요.</p>
        <button class="refreshBtn" @click="reload">
          <i class="refreshIcon">
            <font-awesome-icon icon="sync-alt" />
          </i>
        </button>
      </div>
      <div>
        <textarea
          class="inputTextBox"
          id="input"
          v-model="input"
          ref="input"
          placeholder="텍스트를 입력해주세요."
        ></textarea>
      </div>
    </div>
    <div class="topIcon">
      <font-awesome-icon icon="caret-down" />
    </div>
    <b-button class="summaryBtn" @click="check">요약하기</b-button>
    <div class="bottomIcon">
      <font-awesome-icon icon="caret-down" />
    </div>
    <div class="outputText">
      <div class="infoText">
        <p>요약된 내용</p>
      </div>
      <div v-if="show === 'result'" class="outputTextBox">
        <p align="justify">
          {{ this.output }}
        </p>
      </div>
      <div v-else-if="show === 'waiting'">
        <textarea
          class="outputTextBox"
          readonly
          placeholder="... 입력된 내용을 요약하는 중입니다."
        ></textarea>
      </div>
      <div v-else>
        <textarea
          class="outputTextBox"
          readonly
          placeholder="요약된 내용이 없습니다."
        ></textarea>
      </div>
    </div>
  </div>
</template>


<script>
import http from "@/utils/http-common";

export default {
  data() {
    return {
      input: "",
      output: "",
      show: "",
    };
  },
  methods: {
    //입력 체크
    check() {
      let err = true;
      let msg = "";
      err &&
        !this.input &&
        ((msg = "텍스트를 입력해주세요."),
        (err = false),
        this.$refs.input.focus());
      if (!err) alert(msg);
      else (this.show = "waiting"), this.send();
    },
    //요약
    send() {
      http
        .post("text/sum", {
          input: this.input,
          type:"TEXT"
        })
        .then((response) => {
          (this.show = "result"), (this.output = response.data);
        });
    },
    //새로고침
    reload() {
      (this.input = ""), (this.output = ""), (this.show = "");
    },
  },
};
</script>


<style>
.TextSummary {
  height: 70%;
  margin-top: 4%;
}
.inputText,
.outputText {
  font-family: "NanumSquareRound";
  font-size: 11pt;
}
.infoText {
  font-size: 13pt;
}
.inputTextBox,
.outputTextBox {
  font-family: "NanumSquareRound";
  resize: none;
  width: 600px;
  height: 200px;
  border-radius: 8px;
  padding: 8px 12px;
  font-size: 11pt;
  margin: auto;
  border: 1px solid black;
}
.summaryBtn {
  font-family: "NanumSquareRound";
  color: #fff !important;
  border: none;
  background-color: rgb(81, 227, 204) !important;
  border-color: rgb(81, 227, 204) !important;
  width: 125px;
  height: 35px;
  border-radius: 8px !important;
}
.summaryBtn:hover {
  background-color: rgb(90, 216, 197) !important;
  border-color: rgb(90, 216, 197) !important;
}
.topIcon,
.bottomIcon {
  font-size: 2.5rem;
  color: #cacaca;
}
.refreshBtn {
  border: none;
  background-color: transparent;
  margin-left: 550px;
}
.refreshIcon {
  color: #51e3cc;
}

@import url(//fonts.googleapis.com/earlyaccess/jejumyeongjo.css);

@font-face {
  font-family: "NanumSquareRound";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_two@1.0/NanumSquareRound.woff")
    format("woff");
  font-weight: normal;
  font-style: normal;
}
</style>