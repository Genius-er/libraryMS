(function ($) {
    $.getUrlParam = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    }
})(jQuery);

$(document).ready(function ManagerSelectUser() {
    $("#user-name").append(window.localStorage.getItem("username"));
    // var url=location.href;
    // var tmp1=url.split("?")[1];
    // var tmp2=tmp1.split("=")[1];
    // var user_id = tmp2;
    let userId = $.getUrlParam("user_id");
    let data = {
        user_id: userId,
    };
    console.log(data);

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/ManagerSelectUserServlet",
        data: data,
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        success: (e) => {
            console.log("获取的json数据：" + e);
            let userInfo = JSON.parse(e);
            console.log(userInfo);
            $("#user_id").attr("value", userInfo[0].user_id);
            $("#username").attr("value", userInfo[0].username);
            $("#password").attr("value", userInfo[0].password);
            $("#china_name").attr("value", userInfo[0].china_name);
            $("#tel").attr("value", userInfo[0].tel);
            if(userInfo[0].sex == 0){
                $("[name='sex'][value='0']").prop("checked", "checked");
            }
            else {
                $("[name='sex'][value='1']").prop("checked", "checked");
            }
            if(userInfo[0].user_type == "用户"){
                $("[name='character'][value='用户']").prop("checked", "checked");
            }
            else {
                $("[name='character'][value='管理员']").prop("checked", "checked");
            }
        }
    })
});

function updateUser() {
    let user_id = $("#user_id").val();
    let username = $("#username").val();
    let password = $("#password").val();
    let china_name = $("#china_name").val();
    let tel = $("#tel").val();
    let sex = $('input:radio[name="sex"]:checked').val();
    let character = $('input:radio[name="character"]:checked').val();

    let data = {
        user_id: user_id,
        username: username,
        password: password,
        china_name: china_name,
        tel: tel,
        sex: sex,
        user_type: character
    };
    console.log(data);

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/ManagerUpdateUserServlet",
        data: data,
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        success: (e) => {
            console.log("获取的json数据：" + e);
            if (e==200) {
                window.alert("修改成功")
                window.location.href = "../manager_UserManage/manager_UserManage.jsp"
            }
            else {
                window.alert("修改失败，请重试")
            }
        }
    })
}

function quit() {
    window.localStorage.clear();
    window.alert("注销成功！");
    window.location.href = "../login/User_login.jsp";
}
