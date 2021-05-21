<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>修改图书</title>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <link rel="stylesheet" href="book_info.css">
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
            </li>
            <li class="layui-nav-item"><a href="" onclick="quit()">注销</a></li>
        </ul>
    </div>

    <div class="layui-body">    <%--TODO:主体在这里--%>
        <!-- 内容主体区域 -->
        <div style="padding: 15px; width: 800px">
            <form class="layui-form" action="" lay-filter="example">
                <div class="layui-form-item">
                    <label class="layui-form-label">书名：</label>
                    <div class="layui-input-block">
                        <input id="title" type="text" name="title" lay-verify="title" autocomplete="off" placeholder="原书名" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">作者：</label>
                    <div class="layui-input-block">
                        <input id="author" type="text" name="author" lay-verify="title" autocomplete="off" placeholder="原作者" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">isbn：</label>
                    <div class="layui-input-block">
                        <input id="isbn" type="text" name="isbn" lay-verify="title" autocomplete="off" placeholder="原isbn" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">出版社：</label>
                    <div class="layui-input-block">
                        <input id="publish" type="text" name="publish" lay-verify="title" autocomplete="off" placeholder="原出版社" class="layui-input">
                    </div>
                </div>


                <div class="layui-form-item">
                    <label class="layui-form-label">分类：</label>
                    <div class="layui-input-block">

                        <!--根据文档读题目-->
                        <select id="booktype_name" name="classification" class="select-box layui-select">
                            <option value="全部">全部</option>

                        </select>


                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">图片封面：</label>
                    <input  id="cover" type="file" accept="image/png, image/jpeg, image/gif, image/jpg" >
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button id="book_info_modify" type="button" class="layui-btn" lay-submit="" lay-filter="demo1" onclick="bookInfoModify()">保存</button>
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
<script src="../js/jquery-3.4.1.js"></script>
<script src="../layui/layui.js"></script>
<script src="book_info_modify.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
    });

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
</body>
</html>
