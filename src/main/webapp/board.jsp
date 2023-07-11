<%@page import="java.util.List"%>
<%@page import="com.poseidon.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#tableDiv {
	margin: 0 auto;
	width: 800px;
	height: 500px;
	background-color: gray;
	padding: 10px;
	box-sizing: border-box;
}

table {
	width: 100%;
	height: 100%;
	border-collapse: collapse; /* td 사이 선 없앰 */
}

th {
	background-color: #c0c0c0;
}

td {
	border-bottom: 1px solid green;
	text-align: center;
}

.td1 {
	width: 10%
}

.td2 {
	width: 20%
}

.title {
	text-align: left;
}

.title a {
	text-decoration: none;
	color: black;
}

tr:hover, tr:hover a {
	background-color: #c0c0c0;
	color: white;
}
</style>
</head>
<body>
	<%
	String sdata = (String) request.getAttribute("Sdata");
	List<BoardDTO> list = (List<BoardDTO>) request.getAttribute("list");
	%>
	<jsp:include page="./menu.jsp" />
	<h1>index</h1>
	${Sdata } = EL태그
	<br> 변환한 값:
	<%=sdata%>
	<hr>
	<div id="tableDiv">
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>조회수</th>
				<th>쓴날짜</th>
			</tr>
			<%
			for (int i = 0; i < list.size(); i++) {
			%>
			<tr>
				<td class="td1"><%=list.get(i).getBno()%></td>
				<td class="title"><a
					href="./detail?bno=<%=list.get(i).getBno()%>"><%=list.get(i).getBtitle()%></a>
				</td>
				<td class="td1"><%=list.get(i).getBwrite()%></td>
				<td class="td1"><%=list.get(i).getBlike()%></td>
				<td class="td2"><%=list.get(i).getBdate()%></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
	<!-- 글쓰기 버튼 : 로그인 한 사용자만 쓸 수 있음 -->
	<button onclick="location.href='./write'">글쓰기</button>

</body>
</html>