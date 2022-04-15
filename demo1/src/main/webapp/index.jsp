<%--
  Created by IntelliJ IDEA.
  User: dragonone
  Date: 2021/11/15
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册登录界面</title>
    <link rel="stylesheet" href="./static/css/style.css">
    <link rel="stylesheet" href="./static/css/normalize.min.css">
</head>
<body>
<div class="container right-panel-active">

    <!-- 注册 -->
    <div class="container_form container--signin">
        <form action="${pageContext.request.contextPath}/register" class="form" method="post">
            <!-- form标签中的 id="form1" 阻止了数据提交，故删除了。此id在script.js文件有用到。-->
            <h2>数据可视化展示平台</h2>
            <h2 class="form_title">注 册</h2>
<%--            <input type="text" placeholder="用户名" name="username" class="input" />--%>
<%--            <input type="password" placeholder="密码" name="password" class="input" />--%>
            <input type="text" placeholder="手机号" name="telephone" class="input" />
<%--            <a href="./static/jsp/getCode.jsp" target="_blank" style="text-decoration: none;color: black">获取验证码</a>--%>
<%--            <span style="color:red;">sf${requestScope.errMsg}</span>--%>
            <button class="btn" type="submit">注 册</button>
        </form>
    </div>


    <!-- 登录 /demo1_war/hs-->
    <div class="container_form container--signup">
        <form action="${pageContext.request.contextPath}/login" class="form" method="post">
            <!-- form标签中的 id="form2" 阻止了数据提交，故删除了。此id在script.js文件有用到。 -->
            <h2>数据可视化展示平台</h2>
            <h2 class="form_title">登 录</h2>
            <input type="text" placeholder="用户名" name="username" class="input" />
            <input type="password" placeholder="密码" name="password" class="input" />
            <span style="color: red"> ${requestScope.errMsg} </span>
            <button class="btn" type="submit">登 录</button>
            <a href="./static/html/index.html" class="link">忘记密码？</a>
        </form>
    </div>

    <!-- 浮层 -->
    <div class="container_overlay">
        <div class="overlay">
            <div class="overlay_panel overlay--left">
<%--                删除了属性 id="signIn" --%>
                <button class="btn" id="signIn">注 册</button>
            </div>
            <div class="overlay_panel overlay--right">
                <button class="btn" id="signUp">登 录</button>
            </div>
        </div>
    </div>
</div>

<!-- 背景 -->
<div class="slidershow">
    <div class="slidershow--image" style="background-image: url('static/img/1.jpg')"></div>
    <div class="slidershow--image" style="background-image: url('static/img/2.jpg')"></div>
    <div class="slidershow--image" style="background-image: url('static/img/3.jpg')"></div>
    <div class="slidershow--image" style="background-image: url('static/img/4.jpg')"></div>
</div>

<script src="static/js/script.js"></script>
</body>
</html>
