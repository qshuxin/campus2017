<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<body>
<h2>请输入一段文字</h2>
<form action="/sendWord">
    <table>
        <tr>
            <td rowspan="2">
                <textarea rows="5" cols="20" name="word" placeholder="请在此输入文本内容"></textarea>
            </td>
            <td>
                <button type="submit">统计</button>
            </td>
        </tr>
        <tr>
            <td>
                <button type="reset">清空内容</button>
            </td>
        </tr>
    </table>
</form>
各统计内容的个数如下：
<table border="1" cellspacing="0" >
    <tr>
        <th>统计项</th>
        <th>个数</th>
    </tr>
    <tr>
        <td>英文字母</td>
        <td>${enCount}</td>
    </tr>
    <tr>
        <td>数字</td>
        <td>${numCount}</td>
    </tr>
    <tr>
        <td>中文汉字</td>
        <td>${chCount}</td>
    </tr>
    <tr>
        <td>中英文标点符号</td>
        <td>${puCount}</td>
    </tr>
</table>

文字中出现频率最高的三个字是：
<table border="1" cellspacing="0" >
    <tr>
        <th>名称</th>
        <th>个数</th>
    </tr>
    <tr>
        <td>${chaMax1}</td>
        <td>${chaMax1Count}</td>
    </tr>
    <tr>
        <td>${chaMax2}</td>
        <td>${chaMax2Count}</td>
    </tr>
    <tr>
        <td>${chaMax3}</td>
        <td>${chaMax3Count}</td>
    </tr>
</table>
</body>
</html>
