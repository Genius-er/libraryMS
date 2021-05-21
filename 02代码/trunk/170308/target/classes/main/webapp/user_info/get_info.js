$(document).ready(function () {
    var id = window.localStorage.getItem("user_id");
    let data = {
        user_id: id
    };
    // window.alert(l);
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/SelectUserServlet",
        data: data,
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        success: (e) => {
            console.log("获取的json数据：" + e);
            if (e != "null" || e != null) {
                user_info = JSON.parse(e);
                // console.log(user_info);
                document.getElementById("china_name").innerHTML = user_info.china_name;
                document.getElementById("password").value = user_info.password;
                document.getElementById("username").value = user_info.username;
                document.getElementById("tel").value = user_info.tel;
                if(user_info.sex == 0){
                    $("[name='sex'][value='0']").prop("checked", "checked");
                }
                else {
                    $("[name='sex'][value='1']").prop("checked", "checked");
                }
                document.getElementById('Mystery').checked=true;
                console.log("获取的sex：" +  user_info.sex);
                // $("#woman").attr("checked","checked");
                // document.getElementById('Mystery').checked = true;
                // document.getElementById("Mystery").checked = "checked";
                // document.getElementById("sex").innerHTML = user_info.sex;
                // document.getElementById("favorite").innerHTML = user_info.favorite;
                // window.username = user_info.username;
                // console.log("获取的username：" + username);
            }
            else {
                window.alert("身份检测失败，请重新登录！")
            }
        }
    });
});


function update() {
    // var password=document.getElementById('password').value;
    var id = window.localStorage.getItem("user_id");
    // let user_id = $("#user_id").val();
    let username = $("#username").val();
    let password = $("#password").val();
    let china_name = $("#china_name").val();
    let tel = $("#tel").val();
    let sex = $('input:radio[name="sex"]:checked').val();
    let favorite = '';
    // let favorite = $('input:checkbox[name="Mystery"]:checked').val();
    if($('input:checkbox[name="Mystery"]:checked').val() == 'on'){
        favorite = favorite + '悬疑，'
    }
    if($('input:checkbox[name="Thriller"]:checked').val() == 'on'){
        favorite = favorite + '惊悚，'
    }
    if($('input:checkbox[name="Literature"]:checked').val() == 'on'){
        favorite = favorite + '文学，'
    }
    if($('input:checkbox[name="Art"]:checked').val() == 'on'){
        favorite = favorite + '艺术，'
    }

    let data = {
        user_id: id,
        username: username,
        password: password,
        china_name: china_name,
        tel: tel,
        sex: sex,
        favorite: favorite
    };
    console.log(data);

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/UpdateUserServlet",
        data: data,
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        success: (e) => {
            console.log("获取的返回数据：" + e);
            if (e == 200) {
                window.alert("修改成功");
                // var myurl = "user.jsp" + "?" + "user_id=" + l[1];
                window.location.href = "http://localhost:8080/user_info/user.jsp";
            }
            else {
                window.alert("修改失败，请重试");
            }
        }
    })
}

function quit() {
    window.localStorage.clear();
    window.location.href = "../login/User_login.jsp";
}