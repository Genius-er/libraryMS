<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../login/login.css"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<script src="../login/login.js"></script>   <%--使用外部脚本--%>
<script src="../js/jquery-3.4.1.js"></script>

<div style="text-align: center">
<div class="box">
    <div class="layui-header">
   <h1>图书管理系统登录界面</h1>

    </div>

<%--<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">--%>
    <%--<legend>表单集合演示</legend>--%>
<%--</fieldset>--%>
<div class="child">
<form class=".layui-layout-body" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">用户ID：</label>
        <div class="layui-input-block">
            <input name="title" class="layui-input" type="text" placeholder="请输入你的ID" autocomplete="off" lay-verify="title" id="user_id" value="">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">用户密码：</label>
        <div class="layui-input-block">
            <input name="username" class="layui-input" type="text" placeholder="请输入你的密码" autocomplete="off" lay-verify="required" lay-reqtext="用户名是必填项，岂能为空？"id="password"value="">
        </div>
    </div>
    <div align="center"><button class="layui-btn layui-btn-primary" type="button" onclick="pass()">登录</button>
        <a href="../register/register.jsp" class="layui-btn">注册</a></div>
          <%--链接地址待修改。--%>
</form>
<p></p>
<p></p>


</div>
</div>
</div>
</body>
</html>