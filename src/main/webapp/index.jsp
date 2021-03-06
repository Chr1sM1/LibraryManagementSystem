<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>登录界面</title>
    <link rel="stylesheet" href="./layui/css/layui.css">
    <style type="text/css">
        .layui-layout-login {
            width: 350px;
            height: auto;
            overflow: hidden;
            margin: 10% auto 0 auto;
            box-shadow: 2px 1px 10px 10px #eeeeee;
            border-radius: 8px;
            z-index: 10;
        }
    </style>
</head>
<body>

<%@include file="window.jsp" %>

<form class="layui-form layui-layout layui-layout-login" action="login" method="post">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>图书馆</legend>
    </fieldset>
    <div class="layui-form-item">
        <label class="layui-form-label">账号</label>
        <div class="layui-input-inline">
            <input type="text" name="username" required lay-verify="required" placeholder="请输入账号"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input type="password" name="password" required lay-verify="required" placeholder="请输入密码"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">用户权限</label>
            <div class="layui-input-block">
                <input type="radio" name="role" value="0"
                       title="管理员">
                <input type="radio" name="role" value="1"
                       title="用户" checked>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <div class="layui-btn-group">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即登录</button>
                <button type="reset" class="layui-btn layui-btn-primary">忘记密码</button>
            </div>
        </div>
    </div>
    <div class="layui-form-item" >
        <a style="padding-left: 200px;color: #2D93CA" href="register.jsp" >没有账号？立即注册</a>
    </div>
</form>

<script src="/layui/layui.js"></script>
<script>
    layui.use('form', function () {
        var form = layui.form;

        //各种基于事件的操作，下面会有进一步介绍
    });
</script>

</body>
</html>
