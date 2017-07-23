package com.avtb.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.reta.model.RetaJDBCDAO;
import com.reta.model.RetaVO;



public class AvtbDAO implements AvtbDAO_Interface {

	private static final String GET_ALL_STMT = "SELECT * FROM AVTB";
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/BA102G3DB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void insert(AvtbVO avtbVO) {
		// TODO Auto-generated method stub

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

			con = ds.getConnection();
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
		}catch (SQLException se) {
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
		RetaJDBCDAO dao = new RetaJDBCDAO();
		//查詢一筆
		RetaVO retaVOPK = dao.findByPrimaryKey(3400001);
		System.out.print("訂位編號:"+retaVOPK.getReta_id() + "\n");
		System.out.print("時段編號:"+retaVOPK.getAvtb_id() + ",");
		System.out.print("使用者編號:"+retaVOPK.getUser_id() + "。");
		System.out.println();
		//查詢
		List<RetaVO> list = dao.getAll();
		for (RetaVO areta : list) {
			System.out.print("訂位編號:"+areta.getReta_id()+ "\n");
			System.out.print(""+areta.getAvtb_id()+ ",");
			System.out.println();
			System.out.println("-------------");
		}
	}
}
