<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<html>
<head>
    <meta charset="utf-8">
    <title>图书管理系统管理员端</title>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <style>
        .layui-footer {
            position: fixed;
            width: 100%;
            left: unset !important;
            right: unset !important;
            bottom: 0;
            height: 44px;
            line-height: 44px;
            padding: 0 15px;
            background-color: #eee
        }
        .footer {
            text-align: center;
        }
    </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">图书管理系统管理员端</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="../manager_index/manager_index.jsp">首页</a></li>
            <li class="layui-nav-item"><a href="manager_UserManage.jsp">用户管理</a></li>
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
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;"></fieldset>
    <div class="layui-btn-group">
        <a href="../manager_AddUpdateUser/manager_AddUser.jsp" class="layui-btn">新增</a>
    </div>

    <div class="layui-form">
        <table class="layui-table" id="tb">
            <colgroup>
                <col width="150">
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
            <thead>
            <tr>
                <th>用户ID</th>
                <th>用户昵称</th>
                <th>用户姓名</th>
                <th>电话</th>
                <th>性别</th>
                <th>用户角色</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>

    <div class="layui-footer footer">
        <!-- 底部固定区域 -->
        Copyright © 2020 layui.com 我带你们打
    </div>
</div>
<script src="../js/jquery-3.4.1.js"></script>
<script src="../layui/layui.js"></script>
<script src="manager_UserManage.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
    });
</script>
</body>
</html>
