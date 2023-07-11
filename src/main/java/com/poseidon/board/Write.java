package com.poseidon.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poseidon.dao.BoardDAO;
import com.poseidon.dto.BoardDTO;

@WebServlet("/write")
public class Write extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Write() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("get으로 들어옵니다.");
		// 글쓰기 화면 불러오기
		// 로그인 여부를 검사하는 if문
		
		RequestDispatcher rd = request.getRequestDispatcher("write.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doGet(request, response);
		// 실제 글쓰기 > 글저장하기
		// 한글
		request.setCharacterEncoding("utf-8");
		
		// 제목 글자수 5개 이상
		// 본문내용 글자수 5글자 이상
		if (request.getParameter("title").length() > 5 && request.getParameter("content").length() > 5) {
			
			BoardDTO dto = new BoardDTO();
			dto.setBtitle(request.getParameter("title"));
			
			// 엔터키 처리: \n > <br>
			String content = request.getParameter("content");
			content = content.replaceAll("\n", "<br>");
			// replace 모두 바꿔준다.
			// replaceAll 동일 + 정규식
			// replaceFirst 처음것만
			dto.setBcontent(content);
			
			dto.setBwrite("poseidon");
			
			// DAO
			BoardDAO dao = new BoardDAO();
			int result = dao.write(dto);
			
			System.out.println(result);
			
			// 저장 완료되면 페이지 이동
			response.sendRedirect("./board");
			
		} else {
			response.sendRedirect("./write");
		}
		
	}

}
