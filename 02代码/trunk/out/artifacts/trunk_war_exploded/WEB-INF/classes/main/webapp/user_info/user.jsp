<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>图书管理系统_170308</title>
    <link rel="stylesheet" href="../layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">图书管理系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="user_homepage.jsp">首页</a></li>
            <li class="layui-nav-item"><a href="borrowed_record.jsp">借还记录</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="user.jsp" id="user-name">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                </a>
            </li>
            <li class="layui-nav-item"><a href="#" onclick="quit()">退出登录</a></li>
        </ul>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px; width: 900px">
            <table class="layui-table">
                <colgroup>
                    <col width="50px">
                    <col width="200px">
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>个人信息</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>用户姓名：</td>
                    <td id="user_id"></td>
                </tr>
                <tr>
                    <td>用户密码：</td>
                    <td id="password"></td>
                </tr>
                <tr>
                    <td>用户昵称：</td>
                    <td id="username"></td>
                </tr>
                <tr>
                    <td>联系方式：</td>
                    <td id="tel"></td>
                </tr>
                <tr>
                    <td>性别：</td>
                    <td id="sex"></td>
                </tr>
                <tr>
                    <td>喜好：</td>
                    <td id="favorite"></td>
                </tr>

                </tbody>
            </table>

            <a href="#" onclick="pass()" class="layui-btn layui-btn-radius">修改</a>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script src="../layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
    form.render(null, 'test1');
</script>
<script src="../js/jquery-3.4.1.js"></script>
<script src="user.js"></script>
</body>
</html>
