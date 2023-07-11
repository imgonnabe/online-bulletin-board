package com.poseidon.team;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/team")
public class Team extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Team() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("team.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글처리 utf-8
		request.setCharacterEncoding("utf-8");
		
		// 콤마 유무 검사
		// System.out.println(request.getParameter("names").contains(","));
		if(request.getParameter("names").contains(",")) {
			String names = request.getParameter("names");
			// System.out.println("names 길이 : " + names.length());
			
			// 공백 홍길동, 홍길동
			String[] namesArr = names.split(",");
			// System.out.println("배열 길이 : " + namesArr.length);
			List<String> list = new ArrayList<String>();
			list.addAll(Arrays.asList(namesArr));
			
			// 무작위
			Collections.shuffle(list);
			
			RequestDispatcher rd = request.getRequestDispatcher("team.jsp");
			request.setAttribute("list", list);
			rd.forward(request, response);
			
		} else {
			// 리다이렉트 = get
			response.sendRedirect("./team");
		}
	}

}
