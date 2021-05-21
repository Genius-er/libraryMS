$(document).ready(function () {
    $("#user-name").append(window.localStorage.getItem("username"));
});

function addUser() {
    let user_id = $("#user_id").val();
    let password = $("#password").val();
    let china_name = $("#china_name").val();
    let tel = $("#tel").val();
    let sex = $('input:radio[name="sex"]:checked').val();
    let character = $('input:radio[name="character"]:checked').val();

    let data = {
        user_id: user_id,
        password: password,
        china_name: china_name,
        tel: tel,
        sex: sex,
        user_type: character
    };
    console.log(data);

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/AddUserServlet",
        data: data,
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        success: (e) => {
            console.log("获取的json数据：" + e);
            if (e==200) {
                window.alert("添加成功");
                window.location.href = "../manager_UserManage/manager_UserManage.jsp"
            }
            else {
                window.alert("添加失败，请重试")
            }
        }
    })
}

function quit() {
    window.localStorage.clear();
    window.alert("注销成功！");
    window.location.href = "../login/User_login.jsp";
}