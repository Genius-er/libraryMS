
layui.use('form', function(){
    var form = layui.form;

    // form.val("info_change", { //formTest 即 class="layui-form" 所在元素属性 lay-filter="" 对应的值
    //     "user_name":username // "name": "value"
    //     ,"sex": "女"
    //     ,"tel": 123133
    //     ,"like[Mystery]": true
    //     ,"like[Thriller]": true
    //     ,"like[Literature]": true
    //     ,"like[Art]": true
    // });
    //form.render('text', 'info_change');
    // var data1 = form.val("info_change");
    // alert(JSON.stringify(data1));

    form.on('radio(filter)', function(data){
        console.log(data.elem); //得到radio原始DOM对象
        console.log(data.value); //被点击的radio的value值
    });
    //监听提交
    form.on('submit(*)', function(data){
        console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
        console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
        console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });
});