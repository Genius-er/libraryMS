function match() {
    var user_id = document.getElementById("user_id").value;  //user_id 为用户名文本框的id；
    var password = document.getElementById("password").value;  //user_id 为用户密码文本框的id；
    var myurl = "../user_info/user_homepage.jsp" + "?" + "user_id=" + user_id + "&password=" + password;
    window.location.assign(encodeURI(myurl));
    // if userId&userPw in tb
    window.alert("登陆成功！");
}

function pass() {
    let data = {
        user_id: document.getElementById("user_id").value,//user_id 为用户名文本框的id；
        password: document.getElementById("password").value,  //user_id 为用户密码文本框的id；
        // user_id: window.localStorage.getItem('user_id'),
    };
    console.log(data);
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/UserLoginServlet",
         data: data,
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        success: (e) => {
            console.log("获取的json数据：" + e);

            let flag = e.split(":")[0];
            let username = e.split(":")[1];
            if (flag == 11) {
                window.localStorage.setItem("user_id", data.user_id);
                window.localStorage.setItem("username", username);
                window.alert("登录成功！");
                // let myurl = "../user_info/user_homepage.jsp" + "?" + "user_id=" + user_id + "&password=" + password;
                window.location.href="../user_info/user_homepage.jsp";// "?" + "user_id=" + user_id;

            }
            else if (flag == 12) {
                window.localStorage.setItem("user_id", data.user_id);
                window.localStorage.setItem("username", username);
                window.alert("登录成功！");
                // let myurl = "../manager_index/manager_index.jsp" + "?" + "user_id=" + user_id + "&password=" + password;
                window.location.href="../manager_index/manager_index.jsp";
            }
            else {
                window.alert("身份检测失败，请重新登录！");
            }
        }
    });
}

