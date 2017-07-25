package com.avtb.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AvtbJDBCDAO implements AvtbDAO_Interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "BA102G3";
	String passwd = "123456";
	private static final String INSERT_STMT = 
			"INSERT INTO AVTB (AVTB_ID,REST_ID,AVTB_DATE_S,AVTB_DATE_E,AVTB_RESERVATION,AVTB_MAX_RESERVATION) VALUES (avtb_sq.NEXTVAL, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT * FROM AVTB";
	
	@Override
	public void insert(AvtbVO avtbVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, avtbVO.getAvtb_id());
			pstmt.setInt(2, avtbVO.getRest_id());
			pstmt.setDate(3, (Date)avtbVO.getAvtb_date_s());
			
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(AvtbVO avtbVO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer avtb_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public AvtbVO findByPrimaryKey(Integer avtb_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AvtbVO> getAll() {
		List<AvtbVO> list = new ArrayList<AvtbVO>();
		AvtbVO avtbVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				avtbVO = new AvtbVO();
				avtbVO.setAvtb_id(rs.getInt("avtb_id"));
				avtbVO.setRest_id(rs.getInt("rest_id"));
				avtbVO.setAvtb_date_s(rs.getDate("avtb_date_s"));
				avtbVO.setAvtb_date_e(rs.getDate("avtb_date_e"));
				avtbVO.setAvtb_reservation(rs.getInt("avtb_reservation"));
				avtbVO.setAvtb_max_reservation(rs.getInt("avtb_max_reservation"));
				list.add(avtbVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}
	public static void main(String[] args){
		AvtbJDBCDAO dao = new AvtbJDBCDAO();
		//查詢一筆
		AvtbVO avtbVOPK = dao.findByPrimaryKey(3500001);
//		System.out.print("訂位編號:"+avtbVOPK.getReta_id() + "\n");
//		System.out.print("時段編號:"+avtbVOPK.getAvtb_id() + ",");
//		System.out.print("使用者編號:"+avtbVOPK.getUser_id() + "。");
//		System.out.println();
		//查詢
		List<AvtbVO> list = dao.getAll();
		for (AvtbVO aavtb : list) {
			System.out.print(":"+aavtb.getAvtb_id()+ "\n");
			System.out.println();
			System.out.println("-------------");
		}
	}
}
