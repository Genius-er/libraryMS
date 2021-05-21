<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/4
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../layui/css/layui.css"  media="all">
</head>
<body>
<div style="text-align: center">
<div class="box">
    <div class="layui-header"><h1 style="margin-top:100px; height: 80px; margin-left: 60px">图书管理系统注册界面</h1></div>
    <div class="child">
    <form class="layui-form" id="user_info">
        <div class="layui-form-item">
            <label class="layui-form-label">用户ID：</label>
            <div class="layui-input-block">
                <input name="user_id" id="user_id" class="layui-input" type="text" placeholder="请输入你的ID" autocomplete="off" lay-verify="required" lay-reqtext="ID是必填项，岂能为空？">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户昵称：</label>
            <div class="layui-input-block">
                <input name="username" id="username" class="layui-input" type="text" placeholder="请输入你的昵称" autocomplete="off" lay-verify="required" lay-reqtext="填他！">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户密码：</label>
            <div class="layui-input-block">
                <input name="password" id="password" class="layui-input" type="text" placeholder="请输入你的密码" autocomplete="off" lay-verify="required" lay-reqtext="密码是必填项，岂能为空？">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户姓名：</label>
            <div class="layui-input-block">
                <input name="china_name" id="china_name" class="layui-input" type="text" placeholder="请输入你的姓名" autocomplete="off" lay-verify="required" lay-reqtext="姓名是必填项，岂能为空？">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">联系方式：</label>
            <div class="layui-input-block">
                <input name="tel" id="tel" class="layui-input" type="text" placeholder="请输入你的联系方式" autocomplete="off" lay-verify="required" lay-reqtext="填他！">
            </div>
        </div>
        <div>
            <label class="layui-form-label">性别：</label>
            <div>
                <input type="radio" name="sex" value="0" title="男">
                <input type="radio" name="sex" value="1" title="女" checked>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button onclick="regis()" class="layui-btn" lay-submit lay-filter="formDemo">注册</button>
                <a href="../login/User_login.jsp" class="layui-btn layui-btn-primary">返回</a>
            </div>
        </div>
</form>
</div>
</div>
</div>
<script src="../layui/layui.js"></script>
<script src="../js/jquery-3.4.1.js"></script>
<script>
    //JavaScript代码区域
    //Demo
    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>
<script src="../register/ register.js"></script>
</body>
</html>