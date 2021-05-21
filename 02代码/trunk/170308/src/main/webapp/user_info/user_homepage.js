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
    $("#user-name").append(window.localStorage.getItem("username"));

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
                    '<button class="layui-btn" id="' + books[i].book_id + '" onclick="borrow(this)">借书</button>' +
                    '<button class="layui-btn del-btn" id="' + books[i].book_id + '" onclick="returnValueBook(this)">还书</button>' +
                    '</li>');
            }
        }
    })
});

function borrow() {
    //
    // let user_id = $("#user_id").val();
    // let bb_id = $("#bb_id").val();
    // let book_id = $("#book_id").val();
    // let bb_date = $("#bb_date").val();
    // let peality_date = $('#peality_date').val();
    // let return_date = $('#return_date').val();
    // let state ="0";

    let data = {
        user_id: 1,//window.localStorage.getItem('user_id'), //TODO:改成storage的user_id
        bb_id:1,
        book_id:1,
        bb_date:1,
        title:1,
        author:1,
        peality_date:1,
        return_date:1,
        state:0

    };
    //
    // let data = {
    //     user_id: user_id,
    //     bb_id:bb_id,
    //     book_id:book_id,
    //     bb_date,bb_date,
    //     peality_date:peality_date,
    //     return_date:return_date,
    //     state:state
    // };
    console.log(data);

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/BorrowBookServlet",
        data: data,
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        success: (e) => {
            console.log("获取的json数据：" + e);
            if (e==200) {
                window.alert("借书成功")
            }
            else {
                window.alert("借书失败")
            }
        }
    })
}

function quit() {
    window.localStorage.clear();
    window.alert("注销成功！");
    window.location.href = "../login/User_login.jsp";
}