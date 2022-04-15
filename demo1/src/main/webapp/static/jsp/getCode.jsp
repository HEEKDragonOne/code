<%--
  Created by IntelliJ IDEA.
  User: dragonone
  Date: 2021/11/17
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/codePagestyle.css">
<%--    <link rel="stylesheet" href="/demo1_war/static/css/codePagestyle.css">--%>

    <title>获取验证码</title>
    <style>
        input::-webkit-outer-spin-button,
        input::-webkit-inner-spin-button {
            -webkit-appearance: none;
        }
        input[type="number"]{
            -moz-appearance: textfield;
        }
    </style>
</head>

<body>
<section>
    <!-- 背景颜色 -->
    <div class="color"></div>
    <div class="color"></div>
    <div class="color"></div>
    <div class="box">
        <!-- 背景圆 -->
        <div class="circle" style="--x:0"></div>
        <div class="circle" style="--x:1"></div>
        <div class="circle" style="--x:2"></div>
        <div class="circle" style="--x:3"></div>
        <div class="circle" style="--x:4"></div>
        <!-- 验证码框 -->
        <div class="container">
            <div class="form">
                <h2>验证码登录</h2>
                <form action="${pageContext.request.contextPath}/code" method="post">
                    <div class="inputBox">
                        <input type="number" placeholder="手机号" name="phone"> <br>
                    </div>
                    <div class="inputBox">
                        <input type="number" placeholder="验证码" name="code"> <br>
                    </div>
                    <br>
                    <div class="inputBox">
                        <p align="center" style="color:red;">${requestScope.code}</p>
                    </div>
                    <div class="inputBox" align="center">
                        <input type="submit" value="登录">
                    </div>
                    <div class="inputBox">
                        <p align="center" style="color:red;">${requestScope.errMsg}</p>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
</body>

</html>
