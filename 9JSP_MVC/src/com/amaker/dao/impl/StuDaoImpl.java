package com.amaker.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amaker.bean.Stu;
import com.amaker.dao.StuDao;
import com.amaker.util.Dbutil;

public class StuDaoImpl implements StuDao {

	public void save(Stu s) {
		String sql = "insert into StuTb1(name,age) values(?,?)";
		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getName());
			pstmt.setInt(2, s.getAge());
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			util.closeConnection(conn);
		}
	}


	public List list() {
		String sql = "select id,name,age from StuTb1";
		Dbutil util = new Dbutil();
		Connection conn = util.getConnection();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			List list = new ArrayList();

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);

				Stu s = new Stu();
				s.setAge(age);
				s.setId(id);

				s.setName(name);

				list.add(s);

			}
			return list;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			util.closeConnection(conn);
		}
		return null;
	}

}
