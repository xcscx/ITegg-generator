<html>
<head>
    <title>IT蛋官网</title>
</head>
<body>
    <h1>欢迎来到IT蛋的简单模板页面</h1>
    <ur>
        <#-- 渲染导航条 -->
        <#list menuItems as item>
            <li> <a href="${item.url}">${item?index} ${item.label}</a></li>
        </#list>
    </ur>
<#-- 底部版权信息 -->
<footer>
    ${currentYear} IT蛋官网.  All rights reserved.
</footer>
</body>
</html>
