layui.use(['form', 'layedit', 'laydate','jquery','layer'], function(){
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate;
        layer = layui.layer,
        $= layui.jquery;

    form.render();//这句一定要加，占坑
    //监听提交
    $("#denglu").click(function () {
        //alert("登录");
        var $1 = $.trim($('#loginusername').val());
        var $2 = $.trim($("#loginpassword").val());
        //打印一下内容
        if($1 == ''){
            layer.msg('用户名不能为空',function() {time:2000});
            return false;
        }
        if($2 == ''){
            layer.msg('密码不能为空',function() {time:2000});
            return false;
        }
        $.ajax({
            url: '/loginServlet',//发出请求
            type: 'post',
            data: {"username": $1, "password": $2},
            success: function (data) {
                console.log(data);
                if (data == "ok") {//ok说明登录成功
                    /*显示一个弹出成功的弹窗*/
                    layer.msg('登入成功', {
                        time: 20000, //20s后自动关闭
                        btn: ['确定']
                    });
                    window.location.href = "../pages/background.jsp"; //然后跳转到你系统的主界面
                } else if (data == "error") {
                    layer.msg('登入失败', {
                        time: 20000, //20s后自动关闭
                        btn: ['确定']
                    });
                }
            },
            error:function () {
                alert("网络繁忙");
            },
            complete:function () {

            }
        })
        return  false;
    });
});