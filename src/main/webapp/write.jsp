<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<script type="text/javascript">
	// alert("경고창"); // 메소드 호출
	// var let const(상수)

	// alert(m);
	// var m = "선언을 나중에";// 호이스팅 문제
	// 선언된 변수들이 코드상 실제로 이동하지 않지만 최상위로 올려진다.

	// == 값비교
	// === 값비교 + 자료형태 비교

	// 배열
	let arr = [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 ];
</script>
<link rel="stylesheet" type="text/css" href="./css/write.css">
<!-- include libraries(jQuery, bootstrap) -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script type="text/javascript">
	// 자바스크립트 = ECMAscript -> JQuery -> TypeScript -> 바닐라 스크립트
	function check() {
		let title = document.getElementById("title");
		let textarea = document.getElementById("summernote");
		if (title.value.length < 5) {
			let div = document.getElementsByClassName("writeDiv")[0];
			div.setAttribute("style", "background-color:red");
			
			// alert("제목은 다섯글자 이상이어야 합니다.");
			let span = document.getElementById("span");
			span.innerText = "제목은 다섯글자 이상이어야 합니다.";
			// span.innerHTML = "<input value = 'what?'>";
			span.style.border = "5px aquamarine solid";
			
			title.style.border = "3px red solid";
			title.focus();
			return false;
		}
		if (textarea.value.length < 15) {// <p><br></p>
			alert("본문 내용을 입력하세요.");
			textarea.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<jsp:include page="./menu.jsp" />
	<h1>글쓰기</h1>
	<span id = "span"></span>
	<div class="writeDiv">
		<form action="./write" method="post">
			<input type="text" id="title" name="title" placeholder="제목을 입력하세요."
				maxlength="30">
			<textarea id="summernote" name="content"></textarea>
			<button onclick="return check()">저장하기</button>
		</form>
	</div>
	<script type="text/javascript">
		// JQuery
		$(document).ready(function() {
			$('#summernote').summernote({
				height : 400
			});
		});
	</script>
</body>
</html>