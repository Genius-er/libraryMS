$(document).ready(function () {
    $("#user-name").append(window.localStorage.getItem("username"));
    let data = {
        user_id: 1,
    };
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/ManagerGetAllUsersServlet",
        data: data,
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        success:(e) => {
            console.log("获取的json数据：" + e);
            if (e != "null"||e!=null) {
                user_info= JSON.parse(e);
                var tb = document.getElementById("tb");
                console.log(tb.rows.length);
                for (var i = 0; i < user_info.length; i++) {
                    var row = tb.insertRow(tb.rows.length);
                    var c1 = row.insertCell(0);
                    c1.innerHTML = user_info[i].user_id;
                    var c2 = row.insertCell(1);
                    c2.innerHTML = user_info[i].username;
                    var c3 = row.insertCell(2);
                    c3.innerHTML = user_info[i].china_name;
                    var c4 = row.insertCell(3);
                    c4.innerHTML = user_info[i].tel;
                    var c5 = row.insertCell(4);
                    c5.innerHTML = user_info[i].sex;
                    var c6 = row.insertCell(5);
                    c6.innerHTML = user_info[i].user_type;
                    var c7 = row.insertCell(6);
                    var html = "<tr><td><a href=\"../manager_AddUpdateUser/manager_UpdateUser.jsp?user_id="+user_info[i].user_id+"\">修改</a>&emsp;<a href=\"http://localhost:8080/ManagerDeleteUserServlet?user_id="+user_info[i].user_id+"\">删除</a></td></tr>";
                    c7.innerHTML = html;
                }
            }
            else {
                window.alert("身份检测失败，请重新登录！")
            }
        }
    });
});

function quit() {
    window.localStorage.clear();
    window.alert("注销成功！");
    window.location.href = "../login/User_login.jsp";
}
