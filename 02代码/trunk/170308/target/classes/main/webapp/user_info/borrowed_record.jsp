<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <title>图书管理系统_170308</title>

    <title>图书管理系统 - 170308</title>

    <link rel="stylesheet" href="../layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">图书管理系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="../user_info/user_homepage.jsp">首页</a></li>
            <li class="layui-nav-item"><a href="../user_info/borrowed_record.jsp">借还记录</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="user.jsp" id="user-name">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                </a>
            </li>
            <li class="layui-nav-item"><a href="#" onclick="quit()">注销</a></li>
        </ul>
    </div>
    <div class="layui-body">    <%--TODO:主体在这里--%>
        <!-- 内容主体区域 -->
        <div style="padding: 15px">

            <div class="container">
                <div class="content">
                    <div class="part1">
                        <select name="city" lay-verify="">
                            <option value="010">图书编号</option>
                            <option value="021" >图书名称</option>
                            <option value="0571">图书作者</option>
                        </select>
                        <input class="layui-input mr10" type="text" placeholder="请输入要查询的书名或作者名">
                        <button class="layui-btn" type="button">查询</button>
                    </div>

                    <div class="part2">

                        <table class="layui-table"　lay-even　 lay-size="lg">
                            <colgroup>
                                <col width="50px">
                                <col width="200px">
                                <col>
                            </colgroup>

                            <thead>
                            <tr>
                                <th scope="col">借书编号</th>
                                <th scope="col">图书名称</th>
                                <th scope="col">图书作者</th>
                                <th scope="col">借书时间</th>
                                <th scope="col">最迟还书时间</th>
                                <th scope="col">还书时间</th>
                            </tr>
                            </thead>
                            <%

                                ArrayList list = (ArrayList) request.getAttribute("result");

                            %>
                            <%
                                for(int i = 0; i < list.size(); i++) {
                                    Map map = (Map) list.get(i);
                            %>
                            <tr>
                                <td><%=(String)map.get("td1")%></td>
                                <td><%=(String)map.get("td2")%></td>
                                <td><%=(String)map.get("td3")%></td>
                                <td><%=(String)map.get("td4")%></td>
                                <td><%=(String)map.get("td5")%></td>
                                <td><%=(String)map.get("td6")%></td>
                            </tr>



                        </table>
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
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
    });
</script>
<script src="get_info.js"></script>
<script src="user_info.js"></script>
<script src="borrowed.js"></script>

</body>
</html>