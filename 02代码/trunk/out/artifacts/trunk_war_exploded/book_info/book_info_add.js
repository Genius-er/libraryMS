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
        }
    })
});

function bookInfoAdd() {
    let title = $("#title").val();
    let author = $("#author").val();
    let isbn = $("#isbn").val();
    let publish = $("#publish").val();
    let booktype_name = $("#booktype_name").find("option:selected").text();
    // let cover = $('.inp_file_name').text(fileName);

    let data = {
        title: title,
        author: author,
        isbn: isbn,
        publish: publish,
        booktype_name: booktype_name,
        // cover: cover
    };
    console.log(data);

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/ManagerAddBookServlet",
        data: data,
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        success: (e) => {
            console.log("获取的json数据：" + e);
            if (e==200) {
                window.alert("添加成功");
                window.location.href = "../manager_index/manager_index.jsp"
            }
            else {
                window.alert("添加失败，请重试")
            }
        }
    })
}

function quit() {
    window.localStorage.clear();
    window.alert("注销成功！");
    window.location.href = "../login/User_login.jsp";
}