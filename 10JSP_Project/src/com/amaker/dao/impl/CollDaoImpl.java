package com.amaker.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amaker.bean.CollectionBean;
import com.amaker.dao.CollDao;
import com.amaker.util.Dbutil;

public class CollDaoImpl implements CollDao {

	public void save(CollectionBean bean) {

		String sql = "insert into CollectionTb1(name,url)values(?,?)";

		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getUrl());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.closeConnection(conn);
		}

	}

	public void update(CollectionBean bean) {

		String sql = "update CollectionTb1 set name=?,url=? where id=?";

		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getUrl());
			pstmt.setInt(3, bean.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.closeConnection(conn);
		}
	}

	public void delete(String[] s) {

		String sql = "delete from CollectionTb1 where id =?";

		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			if (s != null && s.length > 0) {
				for (int i = 0; i < s.length; i++) {
					int id = new Integer(s[i]).intValue();
					pstmt.setInt(1, id);
					pstmt.executeUpdate();
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.closeConnection(conn);
		}
	}

	public List list() {
		String sql = "select id ,name,url from CollectionTb1";

		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			List list = new ArrayList();

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String url = rs.getString(3);
				CollectionBean bean = new CollectionBean();
				bean.setId(id);
				;
				bean.setName(name);
				bean.setUrl(url);
				list.add(bean);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.closeConnection(conn);
		}
		return null;

	}

	public CollectionBean get(int id) {
		String sql = "select id ,name,url from CollectionTb1 where id=?";

		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString(2);
				String url = rs.getString(3);
				CollectionBean bean = new CollectionBean();
				bean.setId(id);
				;
				bean.setName(name);
				bean.setUrl(url);
				return bean;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.closeConnection(conn);
		}
		return null;
	}

}
