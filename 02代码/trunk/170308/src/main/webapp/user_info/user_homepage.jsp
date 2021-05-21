﻿<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>图书管理系统 - 170308</title>
    <link rel="stylesheet" href="user_index.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">layui 后台布局</div>
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
        <div style="padding: 15px;">

            <div class="container">
                <div class="content">
                    <div class="part1">
                        <input class="layui-input mr10" type="text" placeholder="请输入要查询的书名或作者名">
                        <button class="layui-btn" type="button">查询</button>
                    </div>
                    <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
                        <ul class="layui-tab-title">
                            <li class="layui-this">热门推荐</li>
                            <li>喜好推荐</li>
                        </ul>
                        <div>
                            <table width="100%">
                                <tbody>
                                <tr align="center">
                                    <td>
                                        <div>
                                            <img alt="book" src="../images/1.jpg">
                                        </div>
                                        <div>
                                            <span>书名:xxx</span>
                                            <br>
                                            <span>书名作者:xxx</span>
                                        </div>
                                    </td>
                                    <td>
                                        <div>
                                            <img alt="book" src="../images/2.jpg">
                                        </div>
                                        <div>
                                            <span>书名:xxx</span>
                                            <br>
                                            <span>书名作者:xxx</span>
                                        </div>
                                    </td>
                                    <td>
                                        <div>
                                            <img alt="book" src="../images/3.jpg">
                                        </div>
                                        <div>
                                            <span>书名:xxx</span>
                                            <br>
                                            <span>书名作者:xxx</span>
                                        </div>
                                    </td>

                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="layui-tab-content"></div>
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


</div>
</div>

<div class="layui-footer">
    <!-- 底部固定区域 -->
    © layui.com - 底部固定区域
</div>
</div>
<script src="../layui/layui.js"></script>
<script src="../js/jquery-3.4.1.js"></script>
<script src="user_homepage.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>
