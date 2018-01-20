<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta content="text/html;charset=utf-8"></meta>
    <title>用户列表</title>
    <script sec="/static/js/common/jquery/jquery1.8.3.min.js"></script>
</head>
<body>
<div>
    <table>
        <caption>${currentUser}</caption>
        <thead>
        <tr>
            <th>用户名</th>
            <th>姓名</th>
            <th>身份证</th>
            <th>手机</th>
        </tr>
        </thead>
        <tbody>
            <#list userList as user>
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.userName}</td>
                    <td>${user.idCard}</td>
                    <td>${user.phone}</td>
                </tr>
            </#list>
        </tbody>
    </table>
</div>
</body>
</html>