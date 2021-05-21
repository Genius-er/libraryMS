<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/4
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>增加用户</title>
    <link rel="stylesheet" href="manager_AddUpdateUser.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">图书管理系统管理员端</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="../manager_index/manager_index.jsp">首页</a></li>
            <li class="layui-nav-item"><a href="../manager_UserManage/manager_UserManage.jsp">用户管理</a></li>
        </ul>

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;" id="user-name">
                    <img src="../images/qiezi.png" class="layui-nav-img">
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="#" onclick="quit()">注销</a></li>
        </ul>
    </div>

    <div class="layui-body">
        <!-- 主体在这里 -->
        <!-- 内容主体区域 -->
        <div style="padding: 15px">

            <div class="container">
                <div class="content">
                    <div style="margin-bottom: 50px">
                        <h1>增加用户</h1>
                    </div>
                    <div class="list">
                        <div class="addlabel">
                            <label>用户ID：</label>
                        </div>
                        <div class="">
                            <input id="user_id" style="width: 300px" placeholder="请输入ID" class="layui-input">
                        </div>
                    </div>
                    <div class="list">
                        <div class="addlabel">
                            <label>用户密码：</label>
                        </div>
                        <div class="">
                            <input id="password" style="width: 300px" placeholder="请输入密码" class="layui-input">
                        </div>
                    </div>
                    <div class="list">
                        <div class="addlabel">
                            <label>用户姓名：</label>
                        </div>
                        <div class="">
                            <input id="china_name" style="width: 300px" placeholder="请输入姓名" class="layui-input">
                        </div>
                    </div>
                    <div class="list">
                        <div class="addlabel">
                            <label>联系方式：</label>
                        </div>
                        <div class="">
                            <input id="tel" style="width: 300px" placeholder="请输入联系方式" class="layui-input">
                        </div>
                    </div>
                    <div class="list">
                        <div class="addlabel">
                            <label>性别：</label>
                        </div>
                        <div class="addinput">
                            <input type="radio" name="sex" checked="checked" style="font-size: 20px; margin: 0 5px" value="0">男
                            <input type="radio" name="sex" style="font-size: 20px; margin: 0 5px" value="1">女
                        </div>
                    </div>
                    <div class="list">
                        <div class="addlabel">
                            <label>角色：</label>
                        </div>
                        <div class="addinput">
                            <input type="radio" name="character" checked="checked" style="font-size: 20px; margin: 0 5px" value="用户">用户
                            <input type="radio" name="character" style="font-size: 20px; margin: 0 5px" value="管理员">管理员
                        </div>
                    </div>
                    <div class="listbottom">
                        <button class="layui-btn layui-btn-primary"><a href="../manager_UserManage/manager_UserManage.jsp">返回</a></button>
                        <button id="addUser" class="layui-btn" onclick="addUser()">添加</button>
                    </div>

                </div>
            </div>

        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script src="../layui/layui.js"></script>
<script src="../js/jquery-3.4.1.js"></script>
<script src="manager_AddUser.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
    });
</script>
</body>
</html>