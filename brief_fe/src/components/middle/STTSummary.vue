<template>
  <div class="STTSummary">
    <div class="inputText">
      <div>
        <p>음성 파일을 첨부해주세요.</p>
        <!-- <div>
          <button class="inputFileBtn">음성파일</button>
        </div> -->
        <div>
          <input
            type="file"
            class="soundFileInput"
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
        <button class="exportBtn">추출하기</button>
        <div>
          <button class="refreshBtn">
            <i class="refreshIcon">
              <font-awesome-icon icon="sync-alt" />
            </i>
          </button>
        </div>
      </div>
      <div>
        <textarea
          class="inputTextBox"
          readonly
          placeholder="추출된 결과입니다."
        ></textarea>
      </div>
    </div>
    <div class="topIcon">
      <font-awesome-icon icon="caret-down" />
    </div>
    <button class="summaryBtn">요약</button>
    <div class="bottomIcon">
      <font-awesome-icon icon="caret-down" />
    </div>
    <div class="outputText">
      <p>요약된 내용</p>
      <div>
        <textarea
          class="outputTextBox"
          readonly
          placeholder="요약된 결과입니다."
        ></textarea>
      </div>
    </div>
  </div>
</template>


<script>
export default {
  methods: {
    onAudioSelected(event) {
      const uploadSound = event.target.files[0];
      const audioSrc = window.URL.createObjectURL(uploadSound);
      this.$refs.source.src = audioSrc;
      this.$refs.playWav.load();
    },
  },
};
</script>


<style>
.STTSummary {
  height: 60%;
  margin-top: 2%;
}
.inputText {
  font-family: "NanumSquareRound";
  font-size: 12pt;
}
.soundFileInput {
  height: 45px;
  font-size: 11pt;
  margin-left: 110px;
}
/* .inputFileBtn {
  border: none;
  height: 35px;
  width: 100px;
  font-size: 11pt;
  border-radius: 8px;
} */
.arrowIcon {
  font-size: 2.5rem;
  color: #cacaca;
}
.exportBtn {
  font-family: "NanumSquareRound";
  font-size: 11pt;
  border: none;
  background-color: #51e3cc;
  width: 125px;
  height: 35px;
  border-radius: 8px;
}
.exportBtn:hover {
  background-color: rgb(90, 216, 197);
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
  font-size: 11pt;
  resize: none;
  width: 600px;
  height: 200px;
  border-radius: 8px;
  padding: 8px 12px;
}
.summaryBtn {
  font-family: "NanumSquareRound";
  font-size: 11pt;
  border: none;
  background-color: #51e3cc;
  width: 125px;
  height: 35px;
  border-radius: 8px;
}
.summaryBtn:hover {
  background-color: rgb(90, 216, 197);
}
.outputText {
  font-family: "NanumSquareRound";
  font-size: 11pt;
}
.outputTextBox {
  width: 600px;
  height: 200px;
  border: 1px solid black;
  border-radius: 8px;
  padding: 8px 12px;
  margin: auto;
}
.topIcon {
  font-size: 2.5rem;
  color: #cacaca;
}
.bottomIcon {
  font-size: 2.5rem;
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