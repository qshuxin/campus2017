<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</body>
</html>
