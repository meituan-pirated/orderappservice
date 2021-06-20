
function hideShowPsw(){
    // 这里使用最原始的js语法实现，可对应换成jquery语法进行逻辑控制
    var demoImg = document.getElementById("demo-img");
    var demoInput = document.getElementById("demo-input");
    //隐藏text block，显示password block
    if (demoInput.type == "password") {
        demoInput.type = "text";
        demoImg.src = "../img/visible.png";
    }else {
        demoInput.type = "password";
        demoImg.src="../img/invisible.png";
    }
}