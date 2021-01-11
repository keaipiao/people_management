<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../checkLogin.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加负责人</title>
<script type="text/javascript" src="../My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
</head>
<body>
	<form>
		<input type="hidden" name="method" value="add">
		负责人名称：<input type="text" name="name" /><br/>
		性别：<input type="radio" name="sex" value="男" checked="checked" />男&nbsp;&nbsp;<input type="radio" name="sex" value="女">女<br/>
		出生日期：<input type="text" name="birthday" readonly="readonly" onclick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})" class="Wdate"/><br/>
		联系方式：<input type="text" name="phone" /><br/>
		<input type="button" id="commit" value="添加负责人" />&nbsp;&nbsp;<input type="reset" value="清空" />
	</form>
	<script type="text/javascript">
		
		$("#commit").click(function(){
			$.ajax({
				url:"${pageContext.request.contextPath}/principal",
				data:$("form").serialize(),
				type:"post",
				dataType:"json",
				success:function(data){
					if(data){
						if(confirm("添加成功，是否继续添加")){
							location.reload();
						}else{
							location.href = "${pageContext.request.contextPath}/principal?method=findAll";
						}
						
					}else{
						alert("添加失败！");
					}
				}
			})
		})
	</script>
</body>
</html>