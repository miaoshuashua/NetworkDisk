<%--
  Created by IntelliJ IDEA.
  User: liu
  Date: 2020/12/2
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <script src="../js/jquery-3.5.1.js" type="text/javascript" charset="UTF-8"></script>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <script type="text/javascript" src="../layui/layui.all.js"></script>
    <link rel="stylesheet" href="../css/login.css">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body style="background-color: white">
<div class="layui-inline">
    <label class="layui-form-label">注册时间</label>
    <div class="layui-input-inline">
        <input type="date" name="registerTime1" lay-verify="required|phone" autocomplete="off" class="layui-input" style="color: black;margin-bottom: 0px;">
    </div>
</div>
<div class="layui-inline">
    <label class="layui-form-label" style="width: 10px">至</label>
    <div class="layui-input-inline">
        <input type="date" name="registerTime2" lay-verify="required|phone" autocomplete="off" class="layui-input" style="color: black;margin-bottom: 0px;">
    </div>
</div>
<div class="layui-inline">
    <label class="layui-form-label">用户名</label>
    <div class="layui-input-inline">
        <input type="tel" name="phone" lay-verify="required|phone" autocomplete="off" class="layui-input" style="color: black;margin-bottom: 0px;">
    </div>
</div>
<div class="layui-btn-group demoTable">
    <button class="layui-btn" data-type="SelectData">查询</button>
</div>
<table class="layui-hide" id="test"></table>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->


<%--<script type="text/html" id="barDemo">--%>
<%--    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>--%>
<%--    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>--%>
<%--</script>--%>
<script>

    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#test'
            ,url:'/persInfoServlet?methodName=firstSelect'
            ,cellMinWidth: 120 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols:
                [[
                {field:'username', title: '用户名', sort: true}
                ,{field:'registrationTime', title: '注册时间'} //width 支持：数字、百分比和不填写。你还可以通过 minWidth 参数局部定义当前单元格的最小宽度，layui 2.2.1 新增
                ,{field:'integral', title: '积分', sort: true}
                ,{field:'downloadNumer', title: '上传文档数'}
                ,{field:'upload', title: '下载文档数'}
                ,{field:'userStatus', title: '用户状态', align: 'center'} //单元格内容水平居中
                // ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
            ]]
            ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                count:11
                ,limit:5
                ,layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                //,curr: 5 //设定初始在第 5 页
                ,groups: 1 //只显示 1 个连续页码
                ,first: false //不显示首页
                ,last: false //不显示尾页
            }
        });
        /*执行数据的回写*/
    });

</script>
</body>
</html>