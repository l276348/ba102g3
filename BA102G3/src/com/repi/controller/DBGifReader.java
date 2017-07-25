package com.repi.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class DBGifReader {

	private static final String GET_ONE_STMT = "SELECT * FROM REPI WHERE REPI_ID";
	
	Connection con = null;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();
		Integer dipi_id = new Integer(req.getParameter("repi_id"));

		try {
			
			PreparedStatement pstmt = null;
			
				pstmt = con.prepareStatement(GET_ONE_STMT);
				
				pstmt.setInt(1, dipi_id);
				
				ResultSet rs= pstmt.executeQuery();
			
			
			if(rs.next()) {
				BufferedInputStream in = new BufferedInputStream(rs.getBinaryStream("repi_img"));
				byte[] buf = new byte[4 * 1024]; // 4K buffer
				int len;
				while ((len = in.read(buf)) != -1) {
					out.write(buf, 0, len);
				}
				in.close();
			} 
			
			 else {
					res.sendError(HttpServletResponse.SC_NOT_FOUND);
				}
			
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void init() throws ServletException {
		try {
			Context ctx = new javax.naming.InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/BA102G3DB");
			con= ds.getConnection();
		
		} catch (Exception e) {
			throw new UnavailableException("Couldn't get db connection");
		}
	}

	public void destroy() {
		try {
			if (con != null) con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
