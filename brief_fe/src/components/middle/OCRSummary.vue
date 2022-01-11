<template>
  <div class="OCRSummary">
    <div class="inputText">
      <div>
        <div class="infoText">
          <font-awesome-icon :icon="['fas', 'file-image']" size="2x" style="vertical-align:middle;" />
          <span>&nbsp;&nbsp;사진 파일을 첨부해주세요.</span>
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
          <div>
            <img id="preview" class="preview" />
          </div>
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
        <p style="color:#808080" align="justify">
          {{"... 사진에서 텍스트를 추출하는 중입니다."}}
        </p>
      </div>
      <div v-else class="outputTextBox">
        <p style="color:#808080" align="justify">
          {{"추출된 내용이 없습니다."}}
        </p>
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
      <div>
        <div v-if="show === 'result'" class="outputTextBox">
          <p align="justify">
            {{ this.output }}
          </p>
        </div>
        <div v-else-if="show === 'waiting'" class="outputTextBox">
        <p style="color:#808080" align="justify">
          {{"... 입력된 내용을 요약하는 중입니다."}}
        </p>
      </div>
      <div v-else class="outputTextBox">
        <p style="color:#808080" align="justify">
          {{"요약된 내용이 없습니다."}}
        </p>
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
      fileName: "",
    };
  },
  methods: {
    //사진선택
    selectFile(e) {
      const file = e.target.files[0];
      const imageSrc = window.URL.createObjectURL(file)
      console.log(imageSrc)
      //1. 파일 확장자 alert
      this.fileName = file['name'];
      //파일의 확장자 추출
      var fileDot = this.fileName.split('.').pop()
      //가능한 확장자
      var dotArray = ["bmp", "dib", "jpeg", "jpg", "jpe", "jp2", "png", "webp", "pbm", "pgm", "ppm", "sr", "ras", "tiff", "tif"];
      if(dotArray.includes(fileDot)==false){
        alert(fileDot+' 파일은 업로드 하실 수 없습니다.');
        this.$refs.imageFileInput.value = '';
      }
      //2. 파일 미리 보기
      var reader = new FileReader();
      document.getElementById('preview').src = imageSrc;
      reader.readAsDataURL(e.target.files[0]);
    },
    //추출
    fileUpload() {
      this.output = "",
      this.show = "";
      let formData = new FormData();
      let imgFile = document.getElementById("imageFileInput");
      if(imgFile.files[0]===undefined){
        alert("파일을 첨부해주세요.");
      }else{
        this.extract = "waiting";
        formData.append("image", imgFile.files[0]);
      axios
        .post(`${SERVER.ROUTES.OCR}`, formData, {
          headers: {
            "Content-Type": "multipart/form-data",
            Authorization: `KakaoAK ${process.env.VUE_APP_OCR_REST_API_KEY}`,
          },
        })
        .then((response) => {
          this.export = "";
          this.extract = "result";
          for (var i = 0; i < response.data["result"].length; i++) {
            this.export += response.data["result"][i]["recognition_words"][0];
          }
        });
      }
    },
    //새로고침
    reload() {
      (this.input = ""),
      (this.output = ""),
      (this.show = ""),
      (this.export = ""),
      (this.extract = "");
      (this.$refs.imageFileInput.value = '');
      (document.getElementById('preview').src = '');
    },

    check() {
      let err = true;
      let msg = "";
      err && !this.export && (
        (msg = "추출하기를 먼저 진행해주세요."),
        (err = false)
      );
      if(!err) alert(msg);
      else(this.show = "waiting"), this.send();
    },
    //요약
    send() {
      http
        .post("ocr/sum", {
          input: this.export,
          filename: this.fileName
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
.preview { 
  width: 200px; 
  height: auto;
  max-width: 200px;
  max-height: 200px;
  border:1px solid #eaeaea; 
  padding: 0px; 
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
  font-size: 11pt;
  resize: none;
  width: 600px;
  height: 200px;
  border-radius: 8px;
  padding: 8px 12px;
  font-size: 11pt;
  margin: auto;
  border: 1px solid black;
  overflow: scroll;
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
  border-radius: 8px !important;
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