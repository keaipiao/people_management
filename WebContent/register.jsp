<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>
<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
</head>
<body>
	<form>
		<input type="hidden" name="method" value="register">
		用户名：<input type="text" name="username"/><br/>
		密码：<input type="password" name="password"/><br/>
		<input type="button" id="regist" value="注册"/>&nbsp;&nbsp;<input type="reset" id="reset" value="清空"/>&nbsp;&nbsp;<a href="login.jsp">已有账号，点此登录</a>
	</form>
	<script type="text/javascript">
		$("#regist").click(function(){
			$.ajax({
				url:"${pageContext.request.contextPath}/user",
				data:$("form").serialize(),
				type:"post",
				dataType:"json",
				success:function(data){
					if(data){
						alert("注册成功");
						location.href = "login.jsp";
					}else{
						alert("注册失败，可能是用户名已存在或其他原因！");
					}
				}
			})
		})
	</script>
</body>
</html>