var page = 1;
var totalPage = 1;
var url = location.href;

(function ($) {
    $.getUrlParam = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(decodeURI(r[2])); return null;
    }
})(jQuery);

$(document).ready(function() {
    //console.log("测试函数："+$.getUrlParam("page"));
    //验证管理员身份
    $("#user-name").append(window.localStorage.getItem("username"));

    let data = {
        user_id: window.localStorage.getItem('user_id'), //TODO:改成storage的user_id
    };
    console.log(data);
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/CheckManagerServlet",
        data: data,
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        success: (e) => {
            console.log("获取的json数据：" + e);
            if (e == 200) { //身份验证成功

                //获取图书类型
                let bookTypeName = $.getUrlParam("booktype_name");

                $.ajax({
                    type: "POST",
                    url: "http://localhost:8080/ManagerGetBookTypeServlet",

                    //data: data,
                    //contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                    success: (e) => {
                        console.log("获取的json数据：" + e);
                        let bookType = JSON.parse(e);
                        console.log(bookType);

                        console.log(bookType.booktype_name[0]);
                        console.log(Object.keys(bookType.booktype_name).length);

                        for (let i = 0; i < Object.keys(bookType.booktype_name).length; i++) {
                            $("#classification").append('<option value="'+ bookType.booktype_name[i] + '">' + bookType.booktype_name[i] + '</option>');
                        }

                        if (bookTypeName != null) {
                            $("#classification").val(bookTypeName);
                        }
                        else {
                            $("#classification").val("全部");
                        }
                    }
                });

                //获取所有图书
                let urlPage = $.getUrlParam("page");
                if (urlPage != null) {
                    page = urlPage;
                }
                let data = {
                    page: page,
                    booktype_name: bookTypeName
                };
                $.ajax({
                    type: "POST",
                    url: "http://localhost:8080/ManagerGetAllBooksServlet",
                    data: data,
                    contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                    success: (e) => {
                        let books = JSON.parse(e);
                        console.log(books);
                        console.log(Object.keys(books).length);

                        totalPage = books[0].total % 10 + 1;
                        console.log("总页数:" + totalPage);

                        for (let i = 1; i < Object.keys(books).length; i++) {
                            $("#book-list").append('<li>' +
                                '<input class="layui-input mr10" type="text" disabled value="' + books[i].title + ' ' + books[i].author + '">' +
                                '<button class="layui-btn" id="' + books[i].book_id + '" onclick="modifyBook(this)">修改</button>' +
                                '<button class="layui-btn del-btn" id="' + books[i].book_id + '" onclick="delBook(this)">删除</button>' +
                                '</li>');
                        }
                    }
                })

            } else { //身份验证失败
                window.alert("身份检测失败，请重新登录！")
            }
        }
    });
});

$("#search").click(function () {
    let name = $("#search-text").val();
    let data = {
        name: name
    };
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/ManagerSearchBookServlet",
        data: data,
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        success: (e) => {
            console.log("获取的json数据：" + e);
            let searchedBooks = JSON.parse(e);
            console.log(searchedBooks);
            console.log(Object.keys(searchedBooks).length);

            for (let i = 0; i < Object.keys(searchedBooks).length; i++) {
                $("#book-list").html('<li>' +
                    '<input class="layui-input mr10" type="text" disabled value="' + searchedBooks[i].title + ' ' + searchedBooks[i].author + '">' +
                    '<button class="layui-btn" id="' + searchedBooks[i].book_id + '" onclick="modifyBook(this)">修改</button>' +
                    '<button class="layui-btn del-btn" id="' + searchedBooks[i].book_id + '" onclick="delBook(this)">删除</button>' +
                    '</li>');
            }
        }
    })
});

function modifyBook(e) {
    window.location.href = "../book_info/book_info_modify.jsp?book_id=" + e.id;
}

function delBook(e) {
    var flag = confirm("是否确认删除?");
    if (flag == true) {
        let book_id = e.id;
        console.log(book_id);
        let data = {
            book_id: book_id
        };
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/ManagerDeleteBookServlet",
            data: data,
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            success: (e) => {
                console.log("获取的json数据：" + e);
                if (e == 200) {
                    window.alert("删除成功！");
                    window.location.reload();
                }
                else {
                    window.alert("删除失败，请重试！")
                }
            }
        })
    }
    else {

    }
}

$("#first-page").click(function () {
    window.location.href = "manager_index.jsp?page=1";
});

$("#previous-page").click(function () {
    window.location.href = "manager_index.jsp?page=" + (parseInt(page)-1)
});

$("#next-page").click(function () {
    window.location.href = "manager_index.jsp?page=" + (parseInt(page)+1)
});

$("#last-page").click(function () {
    window.location.href = "manager_index.jsp?page=" + (totalPage)
});

$("#jump-page").click(function () {
    let jumpPage = $("#jump-to").val();
    window.location.href = "manager_index.jsp?page=" + (jumpPage)
});

$("#add-btn").click(function () {
    window.location.href = "../book_info/book_info_add.jsp"
});

$('#classification').on('change',function() {
    var selectId = $('#classification option:selected');
    if (selectId.val() == "全部") {
        window.location.href = "manager_index.jsp";
    }
    else if (selectId.val() == "散文集") {
        window.location.href = "manager_index.jsp?booktype_name=散文集";
        //$("option[value='散文集']").attr('selected', true);
    }
    else if (selectId.val() == "儿童文学") {
        window.location.href = "manager_index.jsp?booktype_name=儿童文学";
    }
    else if (selectId.val() == "辅导书") {
        window.location.href = "manager_index.jsp?booktype_name=辅导书";
    }
    else if(selectId.val() == "长篇小说") {
        window.location.href = "manager_index.jsp?booktype_name=长篇小说";
    }
});

function quit() {
    window.localStorage.clear();
    window.alert("注销成功！");
    window.location.href = "../login/User_login.jsp";
}