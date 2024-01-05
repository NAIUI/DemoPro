function askVerifyCode () {
    $.get('/api/auth/verify-code', {
        email: $("#input-email").val()
    }, function (data) {
        if (data.code === 200){
            window.location = "/login.html"
        }else{
            alert(data.reason)
        }
    })
}

function login() {
    $.post('/api/auth/login',{
        username: $("#username").val(),
        password: $("#password").val()
    }, function (data) {
        if (data.code === 200) {
            window.location = "/index.html"
        } else {
            alert(data.reason)
        }
    })
}

function logout() {
    $.get('/api/auth/logout',function (data) {
        if (data.code === 200) {
            window.location = "/login.html"
        }
    })
}

function initUserInfo() {
    $.get('/api/user/info', function (data) {
        if (data.code === 200){
            alert("登陆成功，欢迎"+data.username+"进入图书管理系统！")
        }else{
            window.location = '/login.html'
        }
    })
}
