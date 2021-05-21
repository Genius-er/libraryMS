$(document).ready(function () {
    $("#user-name").append(window.localStorage.getItem("username"));

    var id = window.localStorage.getItem("user_id");
    let data = {
        user_id: id,
    };
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/SelectUserServlet",
        data: data,
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        success:(e) => {
            console.log("获取的json数据：" + e);
            if (e != "null"||e!=null) {
                user_info= JSON.parse(e);
                document.getElementById("user_id").innerHTML = user_info.user_id;
                document.getElementById("username").innerHTML = user_info.username;
                document.getElementById("password").innerHTML = user_info.password;
                document.getElementById("tel").innerHTML = user_info.tel;
                document.getElementById("sex").innerHTML = user_info.sex;
                document.getElementById("favorite").innerHTML = user_info.favorite;
            }
            else {
                window.alert("身份检测失败，请重新登录！")
            }
        }
    });
});

function pass() {
    var l = window.localStorage.getItem("user_id");
    var myurl = "change.jsp";
    window.location.assign(encodeURI(myurl));
}


function quit() {
    window.localStorage.clear();
    window.alert("注销成功！");
    window.location.href = "../login/User_login.jsp";
}