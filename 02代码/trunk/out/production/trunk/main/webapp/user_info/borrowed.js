$(document).ready(function () {
    $("#user-name").append(window.localStorage.getItem("username"));

    var l = location.href;
    l = l.split("?")[1];
    l = l.split("=");
    let data = {
        user_id: l[1],
    };
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/Borrowed_RecordServlet",
        data: data,
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        success:(e) => {
        console.log("获取的json数据：" + e);
    if (e != "null"||e!=null) {
        user_info= JSON.parse(e);
        document.getElementById("book_id").innerHTML = user_info.book_id;
        document.getElementById("title").innerHTML = user_info.title;
        document.getElementById("author").innerHTML = user_info.author;
        document.getElementById("bb_date").innerHTML = user_info.bb_date;
        document.getElementById("peality_date").innerHTML = user_info.peality_date;
        document.getElementById("return_date").innerHTML = user_info.return_date;
    }
    else {
        window.alert("身份检测失败，请重新登录！")
    }
}
});
});

function pass() {
    var l = window.localStorage.getItem("user_id");
    var myurl = "../user_info/borrowed_record.jsp" + "?" + "user_id=" + user_id[1];
    window.location.assign(encodeURI(myurl));
}

function quit() {
    window.localStorage.clear();
    window.alert("注销成功！");
    window.location.href = "../login/User_login.jsp";
}