<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../checkLogin.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>负责人列表</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
</head>
<body>
	<table border="1" align="center" width="900px" cellspacing="0">
		<tr>
			<th>名称</th>
			<th>性别</th>
			<th>出生日期</th>
			<th>联系电话</th>
			<th>操作
				<button onclick="addPrincipal()">增加负责人</button>
			</th>
		</tr>
		<c:forEach items="${principalList }" var="principal" >
			<tr align="center">
				<td><input name="${principal.id}" value="${principal.name }" ></td>
				<td>
					<input name="${principal.id}" type="radio" ${principal.sex=='男'?'checked':''} value="男" >男
					&nbsp;
					<input name="${principal.id}" type="radio" ${principal.sex=='女'?'cjiuhecked':''} value="女" >女
				</td>
				<td><input name="${principal.id}" type="text" name="birthday" readonly="readonly" onclick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})" value="${principal.birthday }"  class="Wdate"/></td>
				<td><input name="${principal.id}" value="${principal.phone }" ></td>
				<td><button onclick="updateById('${principal.id}');">修改</button>
					&nbsp;
					<button onclick="deleteById('${principal.id}')">删除</button>
				</td>
			</tr>
			
		</c:forEach>
		
	</table>
	<script type="text/javascript">
		function addPrincipal(){
			location.href = "${pageContext.request.contextPath}/principal/add.jsp";
		}
	
		function deleteById(id){
			if(confirm("你确定要删除此条记录吗？")){
				$.ajax({
					url:"${pageContext.request.contextPath}/principal",
					data:{
						"method":"deleteById",
						"id":id
					},
					type:"post",
					dataType:"json",
					success:function(data){
						if(data){
							alert("删除成功！");
							location.href="${pageContext.request.contextPath}/principal?method=findAll"
						}else{
							alert("删除失败！");
						}
					}
				})
			}
		}
	
		function updateById(id){
			var name,sex,birthday,phone;
			var list = document.getElementsByName(id);
			if(list.length == 5){
				name = list[0].value;
				console.log(list[1].checked);
				if(list[1].checked){
					sex = list[1].value;
				}else{
					sex = list[2].value;
				}
				
				birthday = list[3].value;
				phone = list[4].value;
			
				$.ajax({
					url:"${pageContext.request.contextPath}/principal",
					data:{
						"method":"updateById",
						"id":id,
						"name":name,
						"sex":sex,
						"birthday":birthday,
						"phone":phone
					},
					type:"post",
					dataType:"json",
					success:function(data){
						if(data){
							alert("修改成功！");
						}else{
							alert("修改失败！");
						}
					}
				})

			}
			
		}
	</script>
</body>
</html>