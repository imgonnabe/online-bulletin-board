<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>톺아보기</title>
	<link rel="stylesheet" type="text/css" href="./css/detail.css">
<script type="text/javascript">
	function update(num){
		if(confirm("수정하시겠습니까?")){
			// alert("확인");
			// location.href="./update?bno=${detail.bno }";
			location.href="./update?bno=" + num;
		}
	}
	
	function dele(num){
		if(confirm(num + "번 글을 삭제하시겠습니까?")){
			location.href="./delete?bno=${detail.bno }&k=&no=" + num;
			//                     key    value
		}
	}
</script>
</head>
<body>
	<jsp:include page="./menu.jsp" />
	<h1>톺아보기</h1>
	<div class = "content">
		<div class = "title">
			${detail.btitle }
			<img alt="수정" src="./img/update.png" title="수정하기" onclick="update(${detail.bno })">
			<img alt="삭제" src="./img/delete.png" title="삭제하기" onclick="dele(${detail.bno })">
		</div>
		<div class = "write">
			<div class = "bwrite">
			${detail.bwrite }
			</div>
			<div class = "blike">
			${detail.blike }
			</div>
		</div>
		<div class = "date">
		${detail.bdate }
		</div>
		<div class = "bcontent">
		${detail.bcontent }
		</div>
	</div>
</body>
</html>