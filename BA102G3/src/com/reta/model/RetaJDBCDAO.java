package com.reta.model;

import java.util.ArrayList;
import java.util.List;

import com.rest.model.RestJDBCDAO;
import com.rest.model.RestVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetaJDBCDAO implements RetaDAO_Interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "BA102G3";
	String passwd = "123456";
	
	private static final String GET_ALL_STMT = "SELECT * FROM RETA";
	private static final String GET_ONE_STMT = "SELECT rest_id,rest_name,rest_phone FROM rest where rest_id = ?";
		
	@Override
	public void insert(RetaVO retaVO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(RetaVO retaVO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer reta_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public RetaVO findByPrimaryKey(Integer reta_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RetaVO> getAll() {
		List<RetaVO> list = new ArrayList<RetaVO>();
		RetaVO retaVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				retaVO = new RetaVO();
				retaVO.setReta_id(rs.getInt("reta_id"));
				retaVO.setAvtb_id(rs.getInt("avtb_id"));
				retaVO.setUser_id(rs.getInt("user_id"));
				retaVO.setReta_number(rs.getInt("reta_number"));
				retaVO.setReta_status(rs.getInt("reta_status"));
				retaVO.setReta_grant(rs.getInt("reta_grant"));
				retaVO.setReta_date(rs.getDate("reta_date"));
				retaVO.setReta_rank_res(rs.getInt("reta_rank_res"));
				retaVO.setReta_review(rs.getString("reta_review"));
				retaVO.setReta_reviewdate(rs.getDate("reta_reviewdate"));
				retaVO.setRest_rpdate(rs.getDate("rest_rpdate"));
				retaVO.setRest_rpcomm(rs.getString("rest_rpcomm"));
				retaVO.setRest_rpstatus(rs.getInt("rest_rpstatus"));
				list.add(retaVO); // Store the row in the list
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
		RetaJDBCDAO dao = new RetaJDBCDAO();
		//�d�ߤ@��
		RetaVO retaVOPK = dao.findByPrimaryKey(3400001);
		System.out.print("�q��s��:"+retaVOPK.getReta_id() + "\n");
		System.out.print("�ɬq�s��:"+retaVOPK.getAvtb_id() + ",");
		System.out.print("�ϥΪ̽s��:"+retaVOPK.getUser_id() + "�C");
		System.out.println();
		//�d��
		List<RetaVO> list = dao.getAll();
		for (RetaVO areta : list) {
			System.out.print("�q��s��:"+areta.getReta_id()+ "\n");
			System.out.print("�ɬq�s��:"+areta.getAvtb_id()+ ",");
			System.out.print("�ϥΪ̽s��:"+areta.getUser_id()+ ",");
			System.out.print("�q��H��:"+areta.getReta_number()+ ",");
			System.out.print("��쪬�p:"+areta.getReta_status()+ ",");
			System.out.print("�\�U�f�֭q�쪬�A:"+areta.getReta_grant()+ ",");
			System.out.print("�q�즨�ߤ��:"+areta.getReta_date()+ ",");
			System.out.print("���\�U����:"+areta.getReta_rank_res()+ ",");
			System.out.print("���\�P�Q:"+areta.getReta_review()+ ",");
			System.out.print("��g���\�P�Q���:"+areta.getReta_reviewdate()+ ",");
			System.out.print("�\�U���|�q����:"+areta.getRest_rpdate()+ ",");
			System.out.print("���|�q��z��:"+areta.getRest_rpcomm()+ ",");
			System.out.print("�\�U���|�q�쪬�A:"+areta.getRest_rpstatus()+ "");
			System.out.println();
			System.out.println("-------------");
		}
	}

}
