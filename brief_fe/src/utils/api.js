const SERVER_URL = process.env.VUE_APP_SERVER_URL

export default {
    URL: SERVER_URL,
    ROUTES: {
        OCR: "https://dapi.kakao.com/v2/vision/text/ocr",
    }
}