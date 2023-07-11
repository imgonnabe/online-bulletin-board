package com.poseidon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.poseidon.db.DBConnection;
import com.poseidon.dto.BoardDTO;

// 게시판의 글읽기, 쓰기, 지우기, 수정하기를 담당하는 DAO
// MVC패턴
public class BoardDAO {
	// 게시판 글 읽어오는 메소드
	public List<BoardDTO> boardList() {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		String sql = "SELECT * FROM boardview";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		conn = DBConnection.getInstance().getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			// execute = 실행 = 참/거짓
			// executeUpdate = 실행 = 영향 받은 행
			// executeQuery = select = 결과 반환
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBwrite(rs.getString("bwrite"));
				dto.setBdate(rs.getString("bdate"));
				dto.setBlike(rs.getInt("blike"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	public BoardDTO detail(int bno) {
		BoardDTO dto = new BoardDTO();
		Connection conn = null;
		String sql = "select * from board where bno = " + bno;
		Statement stmt = null;
		ResultSet rs = null;

		conn = DBConnection.getInstance().getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				dto.setBno(rs.getInt("bno"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBcontent(rs.getString("bcontent"));
				dto.setBwrite(rs.getString("bwrite"));
				dto.setBdate(rs.getString("bdate"));
				dto.setBlike(rs.getInt("blike"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	// 글쓰기
//	public int write(BoardDTO dto) {
//		int result = 0;
//		Connection con = null;
//		Statement stmt = null;// > pstmt
//		String sql = "insert into board(btitle, bcontent, bwrite) VALUES('" + dto.getBtitle() + "', '"
//				+ dto.getBcontent() + " ','" + dto.getBwrite() + "')";
//		con = DBConnection.getInstance().getConnection();
//		
//		try {
//			stmt = con.createStatement();
//			result = stmt.executeUpdate(sql);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				stmt.close();
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return result;
	
	// java > sevlet > jsp > struts(거의 안씀) > mvc패턴 > spring
	public int write(BoardDTO dto) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into board(btitle, bcontent, bwrite) values(?, ?, ?)";
		
		con = DBConnection.getInstance().getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			// 물음표에 값 세팅
			pstmt.setString(1, dto.getBtitle());
			pstmt.setString(2, dto.getBcontent());
			pstmt.setString(3, dto.getBwrite());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(con != null) {con.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public int delete(int converBno) {
		return 0;
	}
}
