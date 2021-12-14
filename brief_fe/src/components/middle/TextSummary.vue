<template>
  <div class="TextSummary">
    <div class="inputText">
      <div>
        <p>요약할 원문을 하단에 입력해주세요.</p>
        <button class="refreshBtn">
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
    <b-button class="summaryBtn" @click="check">요약</b-button>
    <div class="bottomIcon">
      <font-awesome-icon icon="caret-down" />
    </div>
    <div class="outputText">
      <p>요약된 내용</p>
      <div v-if="show" class="outputTextBox">
        <p align="justify">
          {{ this.output }}
        </p>
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
      show: false,
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
      else this.send();
    },
    //요약
    send() {
      http
        .post("text/sum", {
          input: this.input,
        })
        .then((response) => {
          (this.show = true), (this.output = response.data);
        });
    },
  },
};
</script>


<style>
.TextSummary {
  height: 70%;
  margin-top: 4%;
}
.inputText {
  font-family: "NanumSquareRound";
  font-size: 14pt;
}
.refreshBtn {
  border: none;
  background-color: transparent;
  margin-left: 550px;
}
.refreshIcon {
  color: #51e3cc;
}
.inputTextBox {
  font-family: "NanumSquareRound";
  font-size: 14pt;
  resize: none;
  width: 600px;
  height: 200px;
  border-radius: 8px;
  padding: 8px 12px;
}
.summaryBtn {
  font-family: "NanumSquareRound";
  font-size: 14pt;
  margin-top: 0.1%;
  border: none;
  background-color: rgb(81, 227, 204) !important;
  width: 125px;
  height: 35px;
  border-radius: 8px;
}
.summaryBtn:hover {
  background-color: rgb(90, 216, 197) !important;
}
.outputText {
  font-family: "NanumSquareRound";
  font-size: 14pt;
}
.outputTextBox {
  width: 600px;
  height: 200px;
  border: 1px solid black;
  border-radius: 8px;
  padding: 8px 12px;
}
.topIcon {
  font-size: 3rem;
  color: #cacaca;
}
.bottomIcon {
  margin-top: 0.5%;
  font-size: 3rem;
  color: #cacaca;
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