package com.javaex.phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDao {

	// 필드
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:#localhost:1521:xe";
	private String id = "webdb";
	private String pw = "webdb";
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 생성자

	// 메소드 g/s

	// 메소드 일반
	public void getConnection() {
		try {
			Class.forName(driver);

			conn = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

	public List<PersonVo> getSelect() {
		List<PersonVo> pList = new ArrayList<PersonVo>();
		getConnection();
		try {
			String query = "";
			query += " select  person_id, ";
			query += "         name, ";
			query += "         hp, ";
			query += "         company ";
			query += " from    person ";

			int count = pstmt.executeUpdate();

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int pId = rs.getInt(1);
				String pName = rs.getString(2);
				String pHp = rs.getString(3);
				String pCompany = rs.getString(4);

				PersonVo p00 = new PersonVo(pId, pName, pHp, pCompany);
				pList.add(p00);

			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
		return pList;
	}

	public void getInsert(PersonVo personVo) {
		getConnection();
		try {
			String query = "";
			query += " insert into person ";
			query += " values (seq_person_id.nextval, ?, ?, ?) ";

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, personVo.getName());
			pstmt.setString(2, personVo.getHp());
			pstmt.setString(3, personVo.getCompany());

			int count = pstmt.executeUpdate();

			System.out.println(count + " 건이 생성되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
	}

	public void getUpdate(PersonVo personVo) {

	}

	public void getDelete(PersonVo personVo) {

	}
	public void getSearch(String search) {
		
	}
}
