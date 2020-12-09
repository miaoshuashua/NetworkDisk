//首先是注册表单的检验
// function checkForm() {
//     //判断用户名格式是正确
//     var value = $("#userName").val();
//     //写一个正则表达式
//     var userModel =/^[a-zA-Z0-9]{4,16}$/;
//     if(value==""){
//         alert("账户不能为空");
//         return false;
//     }else if(!userModel.test(value)){
//         //用正则表达式判断用户名是否格式正确
//         alert("您输入的用户格式不正确,请至少输入4~16为字符或数字,不支持特殊字符！");
//         return false;
//     }
//
//     //判断密码格式是否正确的
//     var passwordvalue = $("#password").val();
//     //写一个正则表达式
//     var passwordModel = /^.*(?=.{6,16})(?=.*\d)(?=.*[A-Z])(?=.*[a-z]).*$/;
//     if(value==""){
//         alert("账户不能为空");
//         return false;
//     }else if(!passwordModel.test(passwordvalue)){
//         //用正则表达式判断用户名是否格式正确
//         alert("您输入的密码格式不正确,请至少输入6~16为大小写字母都需要和数字的组合,不支持特殊字符！");
//         return false;
//     }
//
//     //确认密码
//     var VerificationCode = $("#VerificationCode").val();
//     if(VerificationCode==null){
//         alert("输入的验证码为空");
//         return false;
//     }
// }

function checkForm() {
    var account = $("#loginusername").val();
    var pwd = $("#loginpassword").val();
    console.log(account+"&"+pwd);
    // var admin = {"account":account,"aPwd":pwd};
    // var adminJson = JSON.stringify(admin);
    var vCode = $("#vCode").val();
    $.ajax({
        url:"/loginServlet",
        async:true,
        type:"post",
        data:"account="+account+"&pwd="+pwd,
        dataType:"text",
        beforeSend:function(){

        },
        success:function (data) {

        },
        error:function () {
            alert("网络繁忙");
        },
        complete:function () {

        }
    });


}
//刷新页面的验证码
function changImg() {
    path =$("#path").val();
    var date =new Date().toLocaleString();
    var $img =$("#imgvCode");
    //设置img的src属性的值
    $img.attr("src",path+"/SmartCardverifyCodeServlet?date="+date);
}