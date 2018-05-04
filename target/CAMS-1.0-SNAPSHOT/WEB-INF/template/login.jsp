<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui, viewport-fit=cover">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <!-- Color theme for statusbar -->
    <meta name="theme-color" content="#2196f3">
    <!-- app title -->
    <title>EASY STUDENT</title>
    <link rel="stylesheet" type="text/css" href="/resources/framework7/static/framework7/css/framework7.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/framework7/static/framework7/css/framework7-icons.css">
    <link rel="stylesheet" type="text/css" href="/resources/static/css/main.css">
    <link rel="stylesheet" type="text/css" href="/resources/static/css/reset.css">
    <link rel="stylesheet" type="text/css" href="/resources/static/css/iconfont.css">
</head>
<body>
<div id="app">
    <div class="statusbar"></div>
    <div class="view view-main">
        <div class="page">
            <div class="page-content login-screen-content" style="padding: 0 20px">
                <div id="wrapper"
                     style="max-width: 400px; margin: 20px auto;border: 1px solid #c0c0c0;-webkit-box-shadow: 5px 5px 5px 5px #c0c0c0;box-shadow: 5px 5px 5px 5px #c0c0c0;border-radius: 8px;">
                    <div class="login-screen-title" style="text-align: center">
                        <img src="/resources/static/img/logo.png">
                        <div style="font-size: 24px;opacity: 0.5;">Easy Study</div>
                    </div>
                    <div>
                        <div>
                            <div>
                                <div style="width: 100%;margin: 20px 0px;">
                                    <div>
                                        <!--<input type="text" name="username" placeholder="用户名" style="border: 1px solid #c0c0c0;border-radius: 45px;padding: 10px;width: 80%;height: 36px;margin: 0 auto;display: flex;align-items: center;">-->
                                        <input class="input_focus" type="text" name="username" placeholder="用户名"
                                               style="border: 1px solid #c0c0c0;border-radius: 45px;padding: 10px;width: 80%;margin: 0 auto;display: flex;align-items: center;font-size: 16px;">
                                    </div>
                                </div>
                            </div>
                            <div>
                                <div style="width: 100%;margin: 20px 0px;">
                                    <div>
                                        <input class="input_focus" type="password" name="password" placeholder="密码"
                                               style="border: 1px solid #c0c0c0;border-radius: 45px;padding: 10px;width: 80%;margin: 0 auto;display: flex;align-items: center;font-size: 16px;">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div style="margin: 30px 0 0 0;text-align: center;">
                            <button class="col button button-fill color-blue" id="login_btn"
                                    style="height: 40px; margin: 0 auto; width: 80%; border-radius: 45px">登录
                            </button>
                            </li>
                        </div>
                        <div style="float:right;margin: 20px; font-size: 15px;">Powered by Charmen</div>
                        <div class="clear"></div>
                        <!--<div class="block-footer">-->
                        <!--<p>不记得密码，请点击<a class="link" href="/forget_password/">忘记密码</a>重置</p>-->
                        <!--</div>-->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/resources/framework7/static/framework7/js/framework7.min.js"></script>
<script type="text/javascript" src="/resources/static/js/init.js"></script>
<script type="text/javascript" src="/resources/static/js/app/login.js"></script>
<script type="text/javascript" src="/resources/static/js/app/main.js"></script>
<script type="text/javascript" src="/resources/static/js/app/contact_detail.js"></script>
<script type="text/javascript" src="/resources/static/js/app/student_information.js"></script>
<script type="text/javascript" src="/resources/static/js/app/student_information_school.js"></script>
<script type="text/javascript" src="/resources/static/js/app/student_information_grade.js"></script>
</body>
</html>