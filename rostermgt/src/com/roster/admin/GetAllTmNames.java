package com.roster.admin;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;


/**
 * Servlet implementation class GetAllTmNames
 */
@WebServlet("/GetAllTmNames")
public class GetAllTmNames extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetAllTmNames() {
		super();

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		java.sql.Connection conn = null;
		PreparedStatement st = null;
		ResultSet data = null;
		try {

			try {
				conn = DriverManager.getConnection(
						"jdbc:postgresql://10.91.22.235:5432/reporting",
						"postgres", "P0stgres");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			String sql = "select DISTINCT(a.emp_id), a.emp_name from hdpr.tbl_roster_employees a INNER JOIN hdpr.tbl_roster_emp_tm_mapping b ON b.tm_id = a.emp_id ";
			sql = sql + " WHERE a.emp_id is not NULL AND a.emp_is_hd = '1' ORDER BY a.emp_name ";
			st = conn.prepareCall(sql);
			data = st.executeQuery();

			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(
					ResultSetConverter.convert(data).toString());

			try {
				st.close();
				data.close();
			} catch (SQLException logOrIgnore) {

			}
			try {
				conn.close();

			} catch (SQLException logOrIgnore) {

			}

		} catch (SQLException e) {

			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write((e).toString() + "badtrip naman oh");
		} catch (JSONException f) {
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write((f).toString());
		} catch (NullPointerException g) {

			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write((g).toString());
		} finally{
			try { st.close(); } catch (Exception e) { /* ignored */ }
			try { data.close(); } catch (Exception e) { /* ignored */ }
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
