<template>
  <div class="STTSummary">
    <div class="inputText">
      <div>
        <div class="infoText">
          <p>음성 파일을 첨부해주세요.</p>
        </div>
        <div>
          <input
            type="file"
            class="soundFileInput"
            id="soundFileInput"
            accept="audio/*"
            @change="onAudioSelected"
          />
        </div>
        <div>
          <audio class="playWav" controls ref="playWav">
            <source src="" ref="source" />
          </audio>
        </div>
        <div class="arrowIcon">
          <font-awesome-icon icon="caret-down" />
        </div>
        <button class="exportBtn" ref="fileUpload" @click="fileUpload()">
          추출하기
        </button>
        <div>
          <button class="refreshBtn" @click="reload">
            <i class="refreshIcon">
              <font-awesome-icon icon="sync-alt" />
            </i>
          </button>
        </div>
      </div>
      <div v-if="extract === 'result'" class="outputTextBox">
        <p align="justify">
          {{ this.export }}
        </p>
      </div>
      <div v-else-if="extract === 'waiting'">
        <textarea
          class="outputTextBox"
          readonly
          placeholder="... 음성에서 텍스트를 추출하는 중입니다."
        ></textarea>
      </div>
      <div v-else>
        <textarea
          class="outputTextBox"
          readonly
          placeholder="추출된 내용이 없습니다."
        ></textarea>
      </div>
    </div>
    <div class="topIcon">
      <font-awesome-icon icon="caret-down" />
    </div>
    <button class="summaryBtn" @click="send">요약하기</button>
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
import axios from "axios";
import http from "@/utils/http-common";

export default {
  data: function () {
    return {
      output: "",
      show: "",
      export: "",
      extract: "",
    };
  },
  methods: {
    //음성선택
    onAudioSelected(event) {
      const uploadSound = event.target.files[0];
      const audioSrc = window.URL.createObjectURL(uploadSound);
      this.$refs.source.src = audioSrc;
      this.$refs.playWav.load();
    },
    //추출
    fileUpload() {
      this.extract = "waiting";
      var formData = new FormData();
      var soundFile = document.getElementById("soundFileInput");
      console.log(soundFile);
      formData.append("soundFile", soundFile.files[0]);
      for (var value of formData.values()) {
        console.log(value);
      }
      axios
        .post("http://localhost:9090/stt/export", formData, {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        })
        .then((response) => {
          (this.export = response.data), (this.extract = "result");
        });
    },
    //요약
    send() {
      this.show = "waiting";
      http
        .post("text/sum", {
          input: this.export,
        })
        .then((response) => {
          (this.show = "result"), (this.output = response.data);
        });
    },
    //새로고침
    reload() {
      (this.input = ""),
        (this.output = ""),
        (this.show = ""),
        (this.export = ""),
        (this.extract = "");
    },
  },
};
</script>


<style>
.STTSummary {
  height: 70%;
  margin-top: 3%;
}
.soundFileInput {
  height: 45px;
  font-size: 12pt;
  margin-left: 110px;
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
}
.exportBtn,
.summaryBtn {
  font-family: "NanumSquareRound";
  color: #fff !important;
  border: none;
  background-color: rgb(81, 227, 204) !important;
  border-color: rgb(81, 227, 204) !important;
  width: 125px;
  height: 35px;
  border-radius: 8px;
}
.exportBtn:hover,
.summaryBtn:hover {
  background-color: rgb(90, 216, 197) !important;
  border-color: rgb(90, 216, 197) !important;
}
.topIcon,
.bottomIcon,
.arrowIcon {
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