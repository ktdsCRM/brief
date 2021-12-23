<template>
  <div class="OCRSummary">
    <div class="inputText">
      <div>
        <p>사진 파일을 첨부해주세요.</p>
        <div>
          <input
            type="file"
            class="imageFileInput"
            id="imageFileInput"
            ref="imageFileInput"
            accept="image/*"
            @change="selectFile"
          />
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
          placeholder="... 사진에서 텍스트를 추출하는 중입니다."
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
import axios from "axios";
import SERVER from "@/utils/api.js";

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
    onImageSelected() {
      let image = this.$refs.imageFileInput.files[0];
      this.formData = new FormData();
      this.formData.append("image", image);
    },
    //사진선택
    selectFile(e) {
      const file = e.target.files[0];
      this.image = URL.createObjectURL(file);
      console.log(this.image);
      console.log(process.env);
    },
    //추출
    fileUpload() {
      console.log("come"), (this.extract = "waiting");
      let formData = new FormData();
      let imgFile = document.getElementById("imageFileInput");
      formData.append("image", imgFile.files[0]);
      axios
        .post(`${SERVER.ROUTES.OCR}`, formData, {
          headers: {
            "Content-Type": "multipart/form-data",
            Authorization: `KakaoAK ${process.env.VUE_APP_OCR_REST_API_KEY}`,
          },
        })
        .then((response) => {
          (this.export = response.data), (this.extract = "result");
        });
      console.log("come2");
    },
    //새로고침
    reload() {
      (this.input = ""),
        (this.output = ""),
        (this.extract = ""),
        (this.show = "");
    },
  },
};
</script>

<style>
.OCRSummary {
  height: 60%;
  margin-top: 2%;
}
.inputText {
  font-family: "NanumSquareRound";
  font-size: 12pt;
}
.imageFileInput {
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
  font-size: 14pt;
  resize: none;
  padding: 8px 12px;
  width: 600px;
  height: 200px;
  border: 1px solid black;
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
.exportBtn:hover {
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