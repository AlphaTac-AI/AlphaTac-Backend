

$(function(){
    $("#tianhui-radio").click(function () {
        $("#tianhui-radio").prop("checked",true);
        $("#yeyan-radio").prop("checked",false);
    });
});

$(function(){
    $("#yeyan-radio").click(function () {
        $("#yeyan-radio").prop("checked",true);
        $("#tianhui-radio").prop("checked",false);
    });
});

$(function () {
    $("#submit_form_button").click(function () {
        submitGamePreData();
    });
});

function submitGamePreData(){
    var reqBody = JSON.stringify($('#game_predata').serializeJSON());
    $.ajax({
        type: "POST",
        url: "/game_predata.do",
        data: reqBody,
        dataType: "json",
        contentType:"application/json",
        success: function(data){
            alert(data.message);
            console.log(data);
        }
    });
}