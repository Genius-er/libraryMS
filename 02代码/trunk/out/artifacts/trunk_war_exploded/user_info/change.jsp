<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>图书管理系统 - 170308</title>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <link rel="stylesheet" href="info.css">

</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">图书管理系统</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
        <li class="layui-nav-item"><a href="">首页</a></li>
        <li class="layui-nav-item"><a href="">借还记录</a></li>
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
        <div style="padding: 15px; width: 800px">
            <form class="layui-form" action="" lay-filter="info_change">
                <div class="layui-form-item">
                    <label class="layui-form-label">用户姓名：</label>
                    <div class="layui-input-block">
                        <label class="layui-form-label1" id="china_name">吴权清</label>
                        <!--input type="text" name="china_name" lay-verify="title" autocomplete="off" placeholder="***（不可修改）" class="layui-input"-->
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">用户密码：</label>
                    <div class="layui-input-block">
                        <input type="password" id="password" name="password" lay-verify="number" autocomplete="off" placeholder="请输入密码" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">用户昵称：</label>
                    <div class="layui-input-block">
                        <input type="text" id="username" name="username" lay-verify="china_name" autocomplete="off" placeholder="请输入用户昵称" class="layui-input" >
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">联系方式：</label>
                    <div class="layui-input-block">
                        <input type="text" name="tel"  id="tel" lay-verify="tel" autocomplete="off" placeholder="请输入联系方式" class="layui-input">
                    </div>
                </div>

                <%--<div class="layui-form-item">--%>
                    <%--<label class="layui-form-label">性别：</label>--%>
                    <%--<div class="layui-input-block">--%>
                        <%--<input type="radio" name="sex" value="0" title="男" checked="" id="man">--%>
                        <%--<div id="sexman" class="layui-unselect layui-form-radio layui-form-radioed">--%>
                            <%--<i class="layui-anim layui-icon layui-anim-scaleSpring"></i>--%>
                            <%--<div>男</div>--%>
                        <%--</div>--%>
                        <%--<input type="radio" name="sex" value="1" title="女" id="woman">--%>
                        <%--<div id="sexwoman" class="layui-unselect layui-form-radio">--%>
                            <%--<i class="layui-anim layui-icon"></i>--%>
                            <%--<div>女</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <div class="list">
                    <div class="addlabel">
                        <label class="layui-form-label">性别：</label>
                    </div>
                    <div class="addinput">
                        <input type="radio" name="sex" style="font-size: 20px; margin: 0 5px" value="0">男
                        <input type="radio" name="sex" style="font-size: 20px; margin: 0 5px" value="1">女
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">喜好：</label>
                    <div class="layui-input-block">
                        <input type="checkbox" name="Mystery" title="悬疑" id="Mystery"><div class="layui-unselect layui-form-checkbox"><span>悬疑</span><i class="layui-icon layui-icon-ok"></i></div>
                        <input type="checkbox" name="Thriller" title="惊悚"><div class="layui-unselect layui-form-checkbox"><span>惊悚</span><i class="layui-icon layui-icon-ok"></i></div>
                        <input type="checkbox" name="Literature" title="文学"><div class="layui-unselect layui-form-checkbox"><span>文学</span><i class="layui-icon layui-icon-ok"></i></div>
                        <input type="checkbox" name="Art" title="艺术"><div class="layui-unselect layui-form-checkbox"><span>艺术</span><i class="layui-icon layui-icon-ok"></i></div>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button type="button" onclick="update()" class="layui-btn" lay-submit="" lay-filter="demo1">确定</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script src="../layui/layui.js"></script>
<script src="../js/jquery-3.4.1.js"></script>
<script>
    //JavaScript代码区域
    var form = layui.form;
    layui.use('element', function(){
        var element = layui.element;

    });
    //form.render('radio', 'info_change');
</script>
<script src="get_info.js"></script>
<script src="user_info.js"></script>
</body>
</html>
