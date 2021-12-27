<template>
  <div class="OCRSummary">
    <div class="inputText">
      <div>
        <div class="infoText">
          <p>사진 파일을 첨부해주세요.</p>
        </div>
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

    <b-button class="summaryBtn" @click="send">요약하기</b-button>
    <div class="bottomIcon">
      <font-awesome-icon icon="caret-down" />
    </div>
    <div class="outputText">
      <div class="infoText">
        <p>요약된 내용</p>
      </div>
      <div>
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
  </div>
</template>


<script>
import http from "@/utils/http-common";
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
    // onImageSelected() {
    //   let image = this.$refs.imageFileInput.files[0];
    //   this.formData = new FormData();
    //   this.formData.append("image", image);
    // },
    //사진선택
    selectFile(e) {
      const file = e.target.files[0];
      this.image = URL.createObjectURL(file);
      // console.log(process.env);
    },
    //추출
    fileUpload() {
      this.extract = "waiting";
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
          (this.extract = "result");
          for (var i=0; i < response.data['result'].length; i++) {
            this.export += response.data['result'][i]['recognition_words'][0]
          }
        });
    },
    //새로고침
    reload() {
      (this.input = ""),
        (this.output = ""),
        (this.extract = ""),
        (this.show = "");
    },

    //요약
    send() {
      this.show = "waiting";
      http
        .post("ocr/sum", {
          input: this.export,
        })
        .then((response) => {
          (this.show = "result"), (this.output = response.data);
        });
    },

  },
};
</script>

<style>
.OCRSummary {
  height: 70%;
  margin-top: 3%;
}
.imageFileInput {
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
  border: 1px solid black;
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