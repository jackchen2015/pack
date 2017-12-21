package com.cw.pack.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DB2Access {

	private String drv = "org.sqlite.JDBC";

	private String url = "jdbc:sqlite:F:\\person\\pack\\pack.db";

	private Connection conn = null;

	private Statement stm = null;

	private ResultSet rs = null;

	public boolean createConn() {
		boolean b = false;
		try {
			Class.forName(drv).newInstance();
			conn = DriverManager.getConnection(url);
			System.out.println("connect db");
			b = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}
		return b;
	}

	public boolean update(String sql) {
		boolean b = false;
		try {
			stm = conn.createStatement();
			stm.execute(sql);
			b = true;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return b;
	}
	
	public int insert(String sql){
		try{
			stm = conn.createStatement();
			stm.execute(sql);
			ResultSet tmpRs = stm.getGeneratedKeys();
			return tmpRs.getInt(1);
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;	
	}

	public void query(String sql) {
		try {
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
		} catch (Exception e) {
		}
	}
	
	public boolean next() {
		boolean b = false;
		try {
			if(rs.next())b = true;
		} catch (Exception e) {
		}
		return b;		
	}
	
	public String getValue(String field) {
		String value = null;
		try {
			if(rs!=null)value = rs.getString(field);
		} catch (Exception e) {
		}
		return value;
	}
	
	public String getString(String field){
		return getValue(field);
	}
	
	public int getIntVal(String field){
		int value = 0;
		try{
			if(rs!=null)value = rs.getInt(field);
		}catch(Exception e){			
		}
		return value;
	}
	
	public Date getDate(String field){
		Date d = null;
		try{
			if(rs!=null)d = rs.getDate(field);
		}catch(Exception e){			
		}
		return d;
	}

	public void closeConn() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
		}
	}

	public void closeStm() {
		try {
			if (stm != null)
				stm.close();
		} catch (SQLException e) {
		}
	}

	public void closeRs() {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
		}
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public String getDrv() {
		return drv;
	}

	public void setDrv(String drv) {
		this.drv = drv;
	}


	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public Statement getStm() {
		return stm;
	}

	public void setStm(Statement stm) {
		this.stm = stm;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
