<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팀뽑기</title>
<style type="text/css">
.names {
	width: 100%;
	height: 90px;
	background-color: gray;
	margin: 5px;
	padding: 5px;
	box-sizing: border-box;
}

input, button {
	width: calc(100% - 10px);
	height: 30px;
	margin: 5px;
}
</style>
<script type="text/javascript">
function check(){
	// alert("팀 만들기를 눌렀습니다.");
	let names = document.getElementsByName("names")[0];
	// alert(names.value.length);
	// alert(names.value.indexOf(","));
	// -1일때
	if(names.value.indexOf(",") == -1){
		alert("올바른 값을 입력하세요.");
		names.value="";
		names.focus();
		return false;
	}
}
</script>
</head>
<body>
	<jsp:include page="./menu.jsp" />
	<h1>팀뽑기</h1>
	<div>
		<form action="./team" method="post" onsubmit="return check()">
			<input type="text" name="names"
				value="구관모,기상민,김민성,김수진,김요한,박지윤,배기주,송다원,송재윤,송화진,안희진,유영조,유종휘,이대원,이상화,이승현,이지선,정대규,정준식,최범식,최지은,표해현,차승리,황선우,박채아">
			<button>팀 만들기</button>
		</form>
	</div>
	<hr>
	<%--${list }  --%>
	<%
	// 서블릿에서 보내온 값 잡기
	List<String> list = (List) request.getAttribute("list");
	%>

	출력 결과 :
	<br>
	
	<table border="2">
	<%
	if (list != null) {// 에러 미리 처리
	%>
		<tr>
		<th>팀</th>
		<th colspan = "5">팀원</th>
		</tr>
		<%
		for (int i = 0; i < list.size(); i++) {
			if (i % 5 == 0) {
		%>
		<tr>
			<td><%=(i/5)+1 %>조</td>
			<td><%=list.get(i)%></td>
			<%
			} else {
			%>
			<td><%=list.get(i)%></td>
			<%
			}
		}
	}
	%>
	</tr>
	</table>
</body>
</html>