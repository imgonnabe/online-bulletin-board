package com.poseidon.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poseidon.dao.BoardDAO;
import com.poseidon.dto.BoardDTO;

@WebServlet("/board")
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Board() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// 리스트 타입에 DTO타입을 넣어서 10개 보낸다.
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> list = dao.boardList();

		RequestDispatcher rd = request.getRequestDispatcher("board.jsp");
		request.setAttribute("Sdata", "전달합니다.");
		request.setAttribute("list", list);
		rd.forward(request, response);
	}

}
