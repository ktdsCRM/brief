<template>
  <div class="STTSummary">
    <div class="inputText">
      <div>
        <div class="infoText">
          <font-awesome-icon
            :icon="['fas', 'volume-down']"
            size="2x"
            style="vertical-align: middle"
          />
          <span>&nbsp;&nbsp;음성 파일을 첨부해주세요.</span>
          <br />
        </div>
        <div class="typeInfo">* 재생시간 30초 / 1MB 이하만 가능합니다.</div>
        <div>
          <input
            type="file"
            class="soundFileInput"
            ref="soundFileInput"
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
      <div v-else-if="extract === 'waiting'" class="outputTextBox">
        <p style="color: #808080" align="justify">
          {{ "... 음성에서 텍스트를 추출하는 중입니다." }}
        </p>
      </div>
      <div v-else class="outputTextBox">
        <p style="color: #808080" align="justify">
          {{ "추출된 내용이 없습니다." }}
        </p>
      </div>
      <div class="sentenceLength" style="margin-top: 4pt">
        <span v-if="extract === 'result'"> {{ this.export.length }}자 </span>
      </div>
    </div>
    <div class="topIcon">
      <font-awesome-icon icon="caret-down" />
    </div>
    <button class="summaryBtn" @click="check">요약하기</button>
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
      <div v-else-if="show === 'waiting'" class="outputTextBox">
        <p style="color: #808080" align="justify">
          {{ "... 입력된 내용을 요약하는 중입니다." }}
        </p>
      </div>
      <div v-else class="outputTextBox">
        <p style="color: #808080" align="justify">
          {{ "요약된 내용이 없습니다." }}
        </p>
      </div>
      <div class="sentenceLength" style="margin-top: 4pt">
        <span v-if="show === 'result'"> {{ this.output.length }}자 </span>
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
      //2. 파일 오디오 기능
      const audioSrc = window.URL.createObjectURL(uploadSound);
      this.$refs.source.src = audioSrc;
      this.$refs.playWav.load();

      //1. 파일 확장자 알림 기능
      //파일명
      let fileName = uploadSound["name"];
      //파일의 확장자 추출
      var fileDot = fileName.split(".").pop();
      //가능한 확장자
      var dotArray = [
        "opus",
        "flac",
        "webm",
        "weba",
        "wav",
        "ogg",
        "m4a",
        "mp3",
        "oga",
        "mid",
        "amr",
        "aiff",
        "wma",
        "au",
        "aa",
      ];
      if (dotArray.includes(fileDot) == false) {
        alert(fileDot + " 파일은 업로드 하실 수 없습니다.");
        this.$refs.soundFileInput.value = "";
      }
    },
    //추출
    fileUpload() {
      (this.output = ""), (this.show = "");
      var formData = new FormData();
      var soundFile = document.getElementById("soundFileInput");
      if (soundFile.files[0] === undefined) {
        alert("파일을 첨부해주세요.");
      } else {
        this.extract = "waiting";
        formData.append("soundFile", soundFile.files[0]);
        axios
          .post("http://localhost:9090/stt/export", formData, {
            headers: {
              "Content-Type": "multipart/form-data",
            },
          })
          .then((response) => {
            (this.export = response.data), (this.extract = "result");
          });
      }
    },
    //입력체크
    check() {
      let err = true;
      let msg = "";
      err &&
        !this.export &&
        ((msg = "추출하기를 먼저 진행해주세요."), (err = false));
      if (!err) alert(msg);
      else (this.show = "waiting"), this.send();
    },
    //요약
    send() {
      http
        .post("stt/sum", {
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
      this.$refs.soundFileInput.value = "";
      this.$refs.source.src = "";
      this.$refs.playWav.load();
    },
  },
};
</script>


<style>
.STTSummary {
  height: 70%;
  margin-top: 3%;
}
.typeInfo {
  padding-bottom: 20px;
  font-size: 9pt;
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
  margin-bottom: 10px;
}
.inputTextBox,
.outputTextBox {
  font-family: "NanumSquareRound";
  font-size: 11pt;
  resize: none;
  width: 600px;
  height: 200px;
  border-radius: 8px;
  padding: 8px 12px;
  font-size: 11pt;
  margin: auto;
  border: 1px solid black;
}
.exportBtn,
.summaryBtn {
  font-family: "NanumSquareRound";
  font-size: 12pt;
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