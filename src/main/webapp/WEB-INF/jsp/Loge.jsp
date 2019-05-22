<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js" charset="UTF-8"></script>
    <script src="${pageContext.request.contextPath}js/jquery.cookie.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>图书信息管理系统</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        html {
            height: 100%;
        }

        body {
            height: 100%;
            background: #fff url(../../images/backgroud.png) 50% 50% no-repeat;
            background-size: cover;
        }

        .dowebok {
            position: absolute;
            left: 50%;
            top: 50%;
            width: 430px;
            height: 550px;
            margin: -300px 0 0 -215px;
            border: 1px solid #fff;
            border-radius: 20px;
            overflow: hidden;
        }

        .logo {
            width: 104px;
            height: 104px;
            margin: 50px auto 40px;
            background: url(../../images/login.png) 0 0 no-repeat;
        }

        .form-item {
            position: relative;
            width: 360px;
            margin: 0 auto;
            padding-bottom: 30px;
        }

        .form-item img {
            position: absolute;
            left: 250px;
            bottom: 45px;
        }

        .form-item input {
            width: 288px;
            height: 48px;
            padding-left: 70px;
            border: 1px solid #fff;
            border-radius: 25px;
            font-size: 18px;
            color: #fff;
            background-color: transparent;
            outline: none;
        }

        .form-item button {
            width: 360px;
            height: 50px;
            border: 0;
            border-radius: 25px;
            font-size: 18px;
            color: #1f6f4a;
            outline: none;
            cursor: pointer;
            background-color: #fff;
        }

        #user_code {
            background: url(../../images/emil.png) 20px 14px no-repeat;
        }

        #password {
            background: url(../../images/password.png) 23px 11px no-repeat;
        }

        .tip {
            display: none;
            position: absolute;
            left: 20px;
            top: 52px;
            font-size: 14px;
            color: #f50;
        }

        .reg-bar {
            width: 360px;
            margin: 20px auto 0;
            font-size: 14px;
            overflow: hidden;
        }

        .reg-bar a {
            color: #fff;
            text-decoration: none;
        }

        .reg-bar a:hover {
            text-decoration: underline;
        }

        .reg-bar .reg {
            float: left;
        }

        .reg-bar .forget {
            float: right;
        }

        .dowebok ::-webkit-input-placeholder {
            font-size: 18px;
            line-height: 1.4;
            color: #fff;
        }

        .dowebok :-moz-placeholder {
            font-size: 18px;
            line-height: 1.4;
            color: #fff;
        }

        .dowebok ::-moz-placeholder {
            font-size: 18px;
            line-height: 1.4;
            color: #fff;
        }

        .dowebok :-ms-input-placeholder {
            font-size: 18px;
            line-height: 1.4;
            color: #fff;
        }

        @media screen and (max-width: 500px) {
            * {
                box-sizing: border-box;
            }

            .dowebok {
                position: static;
                width: auto;
                height: auto;
                margin: 0 30px;
                border: 0;
                border-radius: 0;
            }

            .logo {
                margin: 50px auto;
            }

            .form-item {
                width: auto;
            }

            .form-item input, .form-item button, .reg-bar {
                width: 100%;
            }
        }
    </style>
    <%--<script type="text/javascript">
    function refresh(){
        var img=document.getElementById("img");
        img.src="Validate?id="+Math.random();
    }
    </script>--%>
</head>
<body>
<div class="dowebok">
    <div class="logo"></div>
    <%--提交后的位置：/WEB-INF/jsp/customer.jsp--%>
    <%--  <form action="" method="post" onsubmit="return click()">--%>
    <div class="form-item">
        <input id="user_code" name="user_code" type="text" autocomplete="off" placeholder="用户名">
        <p class="tip">请输入合法的用户名</p>
    </div>
    <div class="form-item">
        <input id="password" name="password" type="password" autocomplete="off" placeholder="登录密码">
        <p class="tip">用户名或密码不正确</p>
    </div>
    <div class="form-item">
        <input id="code" name="code" autocomplete="off" placeholder="验证码" type="text">
        <img src="Validate" onclick="" id="img">
        <p class="tip">验证码不正确</p>
    </div>
    <div class="form-item">
        <button id="submit" type="button" onclick="go()">登 录</button>
    </div>
    </form>
    <div class="reg-bar" style="margin-top: 0px">
        <a class="reg" href="register.jsp" target="_self">立即注册</a>
        <a class="forget" href="searchPassword.jsp" target="_self">忘记密码</a>
    </div>
</div>
<script>
    go = function () {
        var userCode = $('#user_code').val();
        var userPassword = $('#password').val();
        //var code=$('#code').val();
        if (userCode == "" || userPassword == "") {
            alert("用户名或密码不能为空！");
            return false;
        } else {
            var user = JSON.stringify({userCode: userCode, userPassword: userPassword});
            $.ajax({
                type: "post",
                contentType: "application/json",
                url: "${pageContext.request.contextPath}/long.action",
                dataType: "json",
                data: user,
                success: function (data) {
                    if (data == null) {
                        alert("没有用户");
                    } else {
                        alert("登录成功");
                        Location.href="customer.jsp";
                    }
                }
            });
        }
    }
</script>
</body>
</html>
