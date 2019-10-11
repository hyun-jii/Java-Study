/*========================================
   			ScoreDAO.java 
==========================================*/
package com.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.DBConn;

public class ScoreDAO
{
	private Connection conn;
	
	public ScoreDAO()
	{
		conn = DBConn.getConnection();
	}
	
	// 데이터 삽입
	public int add(ScoreDTO dto) throws SQLException
	{
		Statement stmt = conn.createStatement();
		
		String sql = String.format("INSERT INTO TBL_SCORE VALUES(%d, '%s', %d, %d, %d)", dto.getSid(), dto.getName(), dto.getKor(), dto.getEng(),dto.getMat());
	
		int result = stmt.executeUpdate(sql);
		
		
		stmt.close();
				
		return result;
	
	}
	
	//카운트
	public int count() throws SQLException
	{
		Statement stmt = conn.createStatement();
		int result = 0;
		
		String sql = "SELECT COUNT(*) AS COUNT FROM TBL_SCORE";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next())
		{
			result = rs.getInt("COUNT");
		}
		
		rs.close();
		stmt.close();

		return result;
		
		
	}
	
	//데이터 출력
	public ArrayList<ScoreDTO> lists() throws SQLException
	{
		Statement stmt = conn.createStatement();
		
		String sql = "SELECT SID, NAME, KOR, ENG, MAT, KOR+ENG+MAT AS TOT, TRUNC(((KOR+ENG+MAT)/3.0),1) AS AVG FROM TBL_SCORE";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		ArrayList<ScoreDTO> list = new ArrayList<ScoreDTO>();
		
		while (rs.next())
		{
			ScoreDTO dto = new ScoreDTO();
			
			dto.setSid(rs.getInt("SID"));
			dto.setName(rs.getString("NAME"));
			dto.setKor(rs.getInt("KOR"));
			dto.setEng(rs.getInt("ENG"));
			dto.setMat(rs.getInt("MAT"));
			dto.setTot(rs.getInt("TOT"));
			dto.setAvg(rs.getDouble("AVG"));
			
			list.add(dto);
			
		}
		
		rs.close();
		stmt.close();
		
		return list;
	}
	
	public void close()
	{
		DBConn.close();
	}

}















