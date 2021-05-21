<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>图书管理系统管理员端</title>
    <link rel="stylesheet" href="manager_index.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">图书管理系统管理员端</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="manager_index.jsp">首页</a></li>
            <li class="layui-nav-item"><a href="../manager_UserManage/manager_UserManage.jsp">用户管理</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;" id="user-name">
                    <img src="../images/qiezi.png" class="layui-nav-img">

                </a>
            </li>
            <li class="layui-nav-item"><a href="#" onclick="quit()">注销</a></li>
        </ul>
    </div>

    <div class="layui-body">    <!--TODO:主体在这里-->
        <!-- 内容主体区域 -->
        <div style="padding: 15px">

            <div class="container">
                <div class="content">
                    <div class="part1">
                        <input class="layui-input mr10" type="text" id="search-text" placeholder="请输入要查询的书名或作者名">
                        <button class="layui-btn" type="button" id="search">查询</button>
                    </div>
                    <div class="part2">
                        <button class="layui-btn" type="button" id="add-btn">增加</button>
                    </div>
                    <div class="part3">
                        <label class="select-box-container">
                            <!--根据文档读题目-->
                            <select name="classification" id="classification" class="select-box">
                                <option value="全部">全部</option>
                            </select>
                        </label>

                        <div class="book-list-container">
                            <ul id="book-list">

                            </ul>
                            <div class="button-container">
                                <button type="button" class="layui-btn" id="first-page">首页</button>
                                <button type="button" class="layui-btn" id="previous-page">上一页</button>
                                <button type="button" class="layui-btn" id="next-page">下一页</button>
                                <button type="button" class="layui-btn" id="last-page">尾页</button>
                                <div class="jump-container">
                                    <input class="layui-input ml10 mr10" id="jump-to" type="text">
                                    <button class="layui-btn" type="button" id="jump-page">跳转</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="layui-footer footer">
        <!-- 底部固定区域 -->
        Copyright © 2020 layui.com 我带你们打
    </div>
</div>

<script src="../js/jquery-3.4.1.js"></script>
<script src="manager_index.js"></script>
<script src="../layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
    });
</script>
</body>
</html>
