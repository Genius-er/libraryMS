function regis() {
    var user_id = document.getElementById("user_id").value;
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var china_name = document.getElementById("china_name").value;
    var tel = document.getElementById("tel").value;
    let sex = $('input:radio[name="sex"]:checked').val();
    if (user_id==""||username==""||password==""||china_name==""||tel==""){
        window.alert("没填完！快去填，不填打你！")
        return;
    }
    let data = {
        user_id: user_id,
        username: username,
        password: password,
        china_name: china_name,
        sex: sex,
        tel: tel,
        user_type: "用户",
        favorite: ""
    };
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/RegisterUserServlet",
        data: data,
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        success:(e) => {
            console.log(url);
            console.log("获取的json数据：" + e);
            if (e == "success???????") {
                window.alert("注册成功啦！开不开心？激不激动？刺不刺激？惊不惊喜？去个人信息中添加喜好吧~")
                var myurl = "../login/User_login.jsp";
                window.location.assign(encodeURI(myurl));
            }
            else {
                window.alert("注册失败！ID已用！回家做作业吧。")
            }
        }
    });
};
