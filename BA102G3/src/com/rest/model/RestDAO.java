package com.rest.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class RestDAO implements RestDAO_Interface {

	private static final String GET_ALL_STMT = "SELECT * FROM REST";
	
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
	public void insert(RestVO restVO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(RestVO restVO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer rest_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public RestVO findByPrimaryKey(Integer rest_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestVO> getAll() {
		List<RestVO> list = new ArrayList<RestVO>();
		RestVO restVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				restVO = new RestVO();
				restVO.setRest_id(rs.getInt("rest_id"));
				restVO.setUser_id(rs.getInt("user_id"));
				restVO.setRest_name(rs.getString("rest_name"));
				restVO.setRest_address(rs.getString("rest_address"));
				restVO.setRest_phone(rs.getString("rest_phone"));
				restVO.setRest_phone(rs.getString("rest_trans"));
				restVO.setRest_detail(rs.getString("rest_detail"));
				restVO.setRest_hours(rs.getString("rest_hours"));
				restVO.setRest_ter(rs.getInt("rest_ter"));
				restVO.setRest_floor(rs.getInt("rest_floor"));
				restVO.setRest_lon(rs.getDouble("rest_lon"));
				restVO.setRest_lat(rs.getDouble("rest_lat"));
				restVO.setRest_inout(rs.getInt("rest_inout"));
				restVO.setRest_type(rs.getInt("rest_type"));
				restVO.setRest_count(rs.getInt("rest_count"));
				restVO.setRest_score(rs.getInt("rest_score"));
				list.add(restVO); // Store the row in the list
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
		RestJDBCDAO dao = new RestJDBCDAO();
		
		RestVO restin = new RestVO();
		restin.setRest_id(3000022);
		restin.setUser_id(1000047);
		restin.setRest_name("�q��");
		restin.setRest_address("");
		restin.setRest_phone("");
		restin.setRest_trans("");
		restin.setRest_detail("");
		restin.setRest_hours("");
		restin.setRest_ter(2);
		restin.setRest_floor(3);
		restin.setRest_lon(new Double(121.000));
		restin.setRest_lat(new Double(25.333));
		restin.setRest_inout(2);
		restin.setRest_type(3);
		restin.setRest_count(5);
		restin.setRest_score(1);
		dao.insert(restin);
		
		//�d�ߤ@��
		RestVO restVOPK = dao.findByPrimaryKey(3000001);
		System.out.print("�\�U�s��:"+restVOPK.getRest_id() + "\n");
		System.out.print("�\�U�W��:"+restVOPK.getRest_name() + ",");
		System.out.print("�q��:"+restVOPK.getRest_phone() + "�C");
		System.out.println();
		//�d��
		List<RestVO> list = dao.getAll();
		for (RestVO arest : list) {
			System.out.print("�\�U�s��:"+arest.getRest_id() + "\n");
			System.out.print("�|���s��"+arest.getUser_id() + ",");
			System.out.print("�\�U�W��"+arest.getRest_name() + ",");
			System.out.print("�a�}:"+arest.getRest_address() + ",");
			System.out.print("�q��:"+arest.getRest_phone() + ",");
			System.out.print("��q��T:"+arest.getRest_trans() + ",");
			System.out.println("�\�U����:"+arest.getRest_detail() + ",");
			System.out.print("��~�ɶ�:"+arest.getRest_hours() + ",");
			System.out.print("��H:"+arest.getRest_ter() + ",");
			System.out.print("�Ӽh:"+arest.getRest_floor() + ",");
			System.out.print("�g��:"+arest.getRest_lon() + ",");
			System.out.print("�n��:"+arest.getRest_lat() + ",");
			System.out.print("�X�J�Ҧ�m:"+arest.getRest_inout() + ",");
			System.out.print("�\�U����:"+arest.getRest_type() + ",");
			System.out.print("�Q��������:"+arest.getRest_count() + ",");
			System.out.print("�����`��"+arest.getRest_count() + "");
			System.out.println();
			System.out.println("-------------");
		}
	}
}
