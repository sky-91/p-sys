<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>登录页</title>
</head>
<body>
<div>
  <form id="_form" action="" method="post">
    <input type="text" name="username" class="username" placeholder="用户名">
    <input type="password" name="password" class="password" placeholder="密码">
    <button type="button" id="login">登录</button>
    <div class="error"></div>
  </form>
</div>
<script src="/static/js/common/jquery/jquery1.8.3.min.js"></script>
<script src="/static/js/common/util/MD5.js"></script>
<script src="/static/js/common/login/login.js"></script>
</body>
</html>