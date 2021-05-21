(function ($) {
    $.getUrlParam = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    }
})(jQuery);

$(document).ready(function () {
    $("#user-name").append(window.localStorage.getItem("username"));
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
                $("#booktype_name").append('<option value="' + bookType.booktype_name[i] + '">' + bookType.booktype_name[i] + '</option>');
            }

            //根据跳转得到的id查找信息并显示到页面
            // var url=location.href;
            // var tmp1=url.split("?")[1];
            // var tmp2=tmp1.split("=")[1];
            let bookId = $.getUrlParam("book_id");
            let data = {
                book_id: bookId
            };
            console.log(data);

            $.ajax({
                type: "POST",
                url: "http://localhost:8080/GetBookInfoByIdServlet",
                data: data,
                contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                success: (e) => {
                    console.log("获取的json数据：" + e);
                    let bookInfo = JSON.parse(e);
                    $("input[name='title']").val(bookInfo.title);
                    $("input[name='author']").val(bookInfo.author);
                    $("input[name='isbn']").val(bookInfo.isbn);
                    $("input[name='publish']").val(bookInfo.publish);
                    // $("input[name='cover']").val(bookInfo.cover);
                    var opList = document.getElementById("booktype_name").childNodes;
                    for (let i = 0; i < opList.length; i++) {
                        if (opList[i].value == bookInfo.booktype_name) {
                            opList[i].selected = true;
                            break;
                        }
                    }
                }
            })
        }
    });
});

function bookInfoModify() {
    let title = $("#title").val();
    let author = $("#author").val();
    let isbn = $("#isbn").val();
    let publish = $("#publish").val();
    let booktype_name = $("#booktype_name").find("option:selected").text();
    let book_id = 3;//todo:改成页面传过来的book_id
    // let cover = $('.inp_file_name').text(fileName);

    let data = {
        title: title,
        author: author,
        isbn: isbn,
        publish: publish,
        booktype_name: booktype_name,
        book_id: book_id
        // cover: cover
    };
    console.log(data);

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/ManagerModifyBookServlet",
        data: data,
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        success: (e) => {
            console.log("获取的json数据：" + e);
            if (e == 200) {
                window.alert("修改成功");
                window.location.href = "../manager_index/manager_index.jsp"
            } else {
                window.alert("修改失败，请重试")
            }
        }
    })
}

function quit() {
    window.localStorage.clear();
    window.alert("注销成功！");
    window.location.href = "../login/User_login.jsp";
}