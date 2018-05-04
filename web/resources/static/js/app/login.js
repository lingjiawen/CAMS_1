function loginBtn() {
    $$('#login_btn').click(function () {
        loginAct($$("input[name='username']").val(), $$("input[name='password']").val())
    })
}

function loginAct(username, password) {

    app.preloader.show();
    app.request.post('/api/login_auth', {
        username: username,
        password: password,
    }, function (data) {
        var jsonResult = JSON.parse(data)
        if (jsonResult.code) {
            app.preloader.hide();
            app.router.navigate("/main/", {
                ignoreCache: true,
            })
        } else {
            app.preloader.hide();
            app.dialog.alert('账号/密码错误', jsonResult.msg);
        }
    }, function () {
        app.preloader.hide();
        app.dialog.alert('', '服务器验证错误！请重试')
    })
}

loginBtn();