<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
</head>
<body>
	<form>
		<input type="hidden" name="method" value="login">
		用户名：<input type="text" name="username"/><br/>
		密码：<input type="password" name="password"/><br/>
		<input type="button" id="login" value="登录"/>&nbsp;&nbsp;<input type="reset" id="reset" value="清空"/>&nbsp;&nbsp;<a href="register.jsp">没有账号，点此注册</a>
	</form>
		<script type="text/javascript">
		$("#login").click(function(){
			$.ajax({
				url:"${pageContext.request.contextPath}/user",
				data:$("form").serialize(),
				type:"post",
				dataType:"json",
				success:function(data){
					if(data){
						alert("登录成功");
						location.href="principal?method=findAll";
					}else{
						alert("登录失败，检查您的用户名或密码是否正确");
					}
				}
			})
		})
	</script>
</body>
</html>