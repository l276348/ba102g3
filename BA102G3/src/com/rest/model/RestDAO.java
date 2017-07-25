package com.rest.model;

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

public class RestDAO implements RestDAO_Interface {
	
	private static final String INSERT_STMT = 
			"INSERT INTO rest (rest_id,user_id,rest_name,rest_address,rest_phone,rest_trans,rest_detail,rest_hours,"
			+ "rest_ter,rest_floor,rest_lon,rest_lat,rest_inout,rest_type,rest_count,rest_score) VALUES (rest_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = 
			"UPDATE REST set REST_PHONE=?, REST_DETAIL=? where USER_ID = ?";
	private static final String DELETE = 
			"DELETE FROM REST where REST_ID = ?";
	private static final String GET_ONE_STMT = "SELECT rest_id,rest_name,rest_phone FROM rest where rest_id = ?";
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
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, restVO.getUser_id());
			pstmt.setString(2, restVO.getRest_name());
			pstmt.setString(3, restVO.getRest_address());
			pstmt.setString(4, restVO.getRest_phone());
			pstmt.setString(5, restVO.getRest_trans());
			pstmt.setString(6, restVO.getRest_detail());
			pstmt.setString(7, restVO.getRest_hours());
			pstmt.setInt(8, restVO.getRest_ter());
			pstmt.setInt(9,restVO.getRest_floor());
			pstmt.setDouble(10, restVO.getRest_lon());
			pstmt.setDouble(11, restVO.getRest_lat());
			pstmt.setInt(12, restVO.getRest_inout());
			pstmt.setInt(13, restVO.getRest_type());
			pstmt.setInt(14,restVO.getRest_count());
			pstmt.setInt(15, restVO.getRest_score());

			pstmt.executeUpdate();

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
	public void update(RestVO restVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, restVO.getRest_phone());
			pstmt.setString(2, restVO.getRest_detail());
			pstmt.setInt(3, restVO.getUser_id());

			pstmt.executeUpdate();

			// Handle any driver errors
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
	public void delete(Integer rest_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setInt(1, rest_id);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		}  finally {
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
	public RestVO findByPrimaryKey(Integer rest_id) {
		RestVO restVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, rest_id);

			rs = pstmt.executeQuery();
			

			while (rs.next()) {
				restVO = new RestVO();
				restVO.setRest_id(rs.getInt("rest_id"));
				restVO.setRest_name(rs.getString("rest_name"));
				restVO.setRest_phone(rs.getString("rest_phone"));
			}

			// Handle any driver errors
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
		return restVO;
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
		
		//新增
//			RestVO restin = new RestVO();
//			restin.setUser_id(1000047);
//			restin.setRest_name("秀梅");
//			restin.setRest_address("中大");
//			restin.setRest_phone("03-3932819");
//			restin.setRest_trans("");
//			restin.setRest_detail("5555");
//			restin.setRest_hours("10:00~22:00");
//			restin.setRest_ter(2);
//			restin.setRest_floor(3);
//			restin.setRest_lon(new Double(121.000));
//			restin.setRest_lat(new Double(25.333));
//			restin.setRest_inout(2);
//			restin.setRest_type(3);
//			restin.setRest_count(5);
//			restin.setRest_score(1);
//			dao.insert(restin);
			
		//刪除
//			dao.delete(3000023);
//			dao.delete(3000024);
		
		//更新
//			RestVO restup = new RestVO();
//			restup.setRest_phone("9527");
//			restup.setRest_detail("測試");
//			restup.setUser_id(1000047);
//			dao.update(restup);
		//查詢一筆
			RestVO restVOPK = dao.findByPrimaryKey(3000001);
			System.out.print("餐廳編號:"+restVOPK.getRest_id() + "\n");
			System.out.print("餐廳名稱:"+restVOPK.getRest_name() + ",");
			System.out.print("電話:"+restVOPK.getRest_phone() + "。");
			System.out.println();
		//查詢
//		List<RestVO> list = dao.getAll();
//		for (RestVO arest : list) {
//			System.out.print("餐廳編號:"+arest.getRest_id() + "\n");
//			System.out.print("會員編號"+arest.getUser_id() + ",");
//			System.out.print("餐廳名稱"+arest.getRest_name() + ",");
//			System.out.print("地址:"+arest.getRest_address() + ",");
//			System.out.print("電話:"+arest.getRest_phone() + ",");
//			System.out.print("交通資訊:"+arest.getRest_trans() + ",");
//			System.out.println("餐廳介紹:"+arest.getRest_detail() + ",");
//			System.out.print("營業時間:"+arest.getRest_hours() + ",");
//			System.out.print("航廈:"+arest.getRest_ter() + ",");
//			System.out.print("樓層:"+arest.getRest_floor() + ",");
//			System.out.print("經度:"+arest.getRest_lon() + ",");
//			System.out.print("緯度:"+arest.getRest_lat() + ",");
//			System.out.print("出入境位置:"+arest.getRest_inout() + ",");
//			System.out.print("餐廳種類:"+arest.getRest_type() + ",");
//			System.out.print("被評分次數:"+arest.getRest_count() + ",");
//			System.out.print("評分總分"+arest.getRest_count() + "");
//			System.out.println();
//			System.out.println("-------------");
//		}
	}
}
