<%--
  Created by IntelliJ IDEA.
  User: liu
  Date: 2020/12/2
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <script type="text/javascript" src="../layui/layui.all.js"></script>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <script src="../js/jquery-3.5.1.js" type="text/javascript" charset="UTF-8"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">传一网盘</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">欢迎您：</a></li>
            <li class="layui-nav-item"><a href="">当前积分：</a></li>
            <li class="layui-nav-item"><a href="">个人信息</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item"><a href="">我要上传</a></li>
            <li class="layui-nav-item"><a href="">我要下载</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:">用户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="../pages/userSelect.html">用户查询</a></dd>
                        <dd><a href="../pages/userContorl.html">用户管控</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">文档管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="../pages/fileAU.html">文档审核</a></dd>
                        <dd><a href="../pages/fileDeploy.html">文档配置</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="fileAU.html">日志管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">日志列表</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">系统配置</a>
                    <dl class="layui-nav-child">
                        <dd><a href="../pages/rightsAllotment.html">权限分配</a></dd>
                        <dd><a href="javascript:;">注册奖励配置</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <iframe id="iframeMain" src="" style="width: 100%"; height="100%";></iframe>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>

<script>

    $(document).ready(function(){
        $("dd>a").click(function (e) {
            e.preventDefault();
            $("#iframeMain").attr("src",$(this).attr("href"));
        });
    });

    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;


    });
</script>
</body>
</html>
