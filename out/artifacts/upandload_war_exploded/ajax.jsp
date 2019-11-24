<%--
  Created by IntelliJ IDEA.
  User: 杨本胜
  Date: 2019/11/3
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.4.1.js"></script>
</head>
<body>
    手机: <input name="mobile" type="text" id="mobile" /><br />
    <input type="submit" value="注册" id="submit"/>
    <script>
            $("#submit").click(function () {
                var $value = $("#mobile").val();
                $.ajax({
                    url: "MobileServlet",
                    type: "post",
                    data: "mobile="+$value,
                    dataType:"script",
                    success:function (result ) {
                        if (result=="false"){
                            alert("此号码已经存在，注册失败");
                        }else{
                            alert("注册成功")
                        }
                    },
                    error:function (errorMessage,e) {
                        alert(e.responseText)
                    }
                })
            })

    </script>

</body> 
</html>
