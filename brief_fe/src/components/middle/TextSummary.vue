<template>
    <div class="TextSummary">
        <div class="inputText">
            <div>
                <p>텍스트 입력</p>
                <button class="refreshBtn">
                    <i class="refreshIcon">
                    <font-awesome-icon icon="sync-alt"/>
                    </i> 
                </button>
            </div>
            <div>
            <textarea class="inputTextBox" placeholder="텍스트를 입력해주세요."></textarea>
            </div>
        </div>
        <div class="topIcon">
            <font-awesome-icon icon="caret-down"/>
        </div>
        <button class="summaryBtn">요약</button>
        <div class="bottomIcon">
            <font-awesome-icon icon="caret-down" />
        </div>
        <div class="outputText">
            <p>요약된 내용</p>
            <p class="outputTextBox" align="justify">안녕하세요. 테스트 중입니다.</p>
        </div>
    </div>
</template>


<script>
    export default {};
</script>


<style>
.TextSummary {
    height: 70%;
    margin-top: 4%;
    position: absolute;
    text-align: center;
    
}
.inputText {
   
}
.refreshBtn{
    border: none;
    background-color:transparent;
}
.refreshIcon{
    color: #51E3CC;
}
.inputTextBox {
    resize: none;
    width:600px; 
    height:200px;   
    border-radius: 8px; 
}
.summaryBtn{
    margin-top: 0.1%;
    border: none;
    background-color: #51E3CC;
    width: 125px;
    height: 35px;
    border-radius: 8px; 
}
.outputText{
   
}
.outputTextBox{
    width:600px; 
    height:200px;   
    border : 1px solid black;
    border-radius : 8px;
} 
.topIcon {
    font-size:3rem;
    color: #CACACA;
}
.bottomIcon {
    margin-top:0.5%;
    font-size:3rem;
    color: #CACACA;
}

</style>