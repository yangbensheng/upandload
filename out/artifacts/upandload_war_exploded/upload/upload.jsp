<%--
  Created by IntelliJ IDEA.
  User: 杨本胜
  Date: 2019/11/2
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <form action="UploadServlet" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>上传者</td>
                <td><input name="name" type="text" /></td>
            </tr>
            <tr>
                <td>上传文件</td>
                <td> <input type="file" name="myfile"> </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="上传"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
