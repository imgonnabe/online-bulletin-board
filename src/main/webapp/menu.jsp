<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
body {
	margin: 0;
	padding: 0;
}

nav {
	width: 100%;
	height: 50px;
	background-color: black;
	overflow: hidden;
	text-align: center;
}

#menu {
	margin: 0 auto; /*가운데 정렬*/
	width: 700px;
	height: 100%;
}

ul {
	margin: 0;
	padding: 0;
}

li {
	float: left;
	min-width: 50px;
	height: 50px;
	list-style: none;
	line-height: 50px;
	background-color: black;
	color: white;
	margin: 0 20px;
}

li:hover {
	font-weight: bolder;
	cursor: pointer;
}

li img {
	vertical-align: middle;
}


li a{
	text-decoration: none;
	color: white; 
}
</style>

	<nav>
		<div id="menu">
			<ul>
				<li onclick="location.href='./'"><img src="./apple.png" alt="HOME"></li>
				<li><a href="./main.jsp">Main</a></li>
				<li onclick="location.href='./team'">팀뽑기</li>
				<li onclick="location.href='./board'">게시판</li>
				<li onclick="location.href='./semantic.jsp'">semantic</li>
				<li>Watch</li>
				<li>Vision</li>
			</ul>
		</div>
	</nav>
