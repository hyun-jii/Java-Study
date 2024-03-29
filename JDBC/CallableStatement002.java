/*====================================================
  Test002.java
  - CallableStatement 를 활용한 SQL 구문 전송 실습 2
 =====================================================*/
package com.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;

import com.util.DBConn;

public class Test002
{
	public static void main(String[] args)
	{
		try
		{
			Connection conn = DBConn.getConnection();
			
			if(conn != null)
			{
				System.out.println("데이터베이스 연결 성공~!!!");
				
				try
				{
					String sql = "{call PRC_MEMBERSELECT(?)}";
					CallableStatement cstmt = conn.prepareCall(sql);
					
					//check~!!!
					//프로시저 내부에서 sys_refcursor 를 사용하고 있기 때문에
					//OracleTypes.CURSOR 를 사용하기 위한 등록 과정이 필요한 상황.
					// 1. 프로젝트명 우클릭 > Build Path > Configure Build Path
					//	  『ojdbc6.jar』 파일 추가 등록
					//	   (외부 jar 파일 연결)
					// 2. 『import oracle.jdbc.OracleTypes;』 구문 추가
					
					//check~!!!
					cstmt.registerOutParameter(1, OracleTypes.CURSOR);
					cstmt.execute();
					ResultSet rs = (ResultSet)cstmt.getObject(1);
					
					while (rs.next())
					{
						String sid = rs.getString("SID");
						String name = rs.getString("NAME");
						String tel = rs.getString("TEL");
						
						String str = String.format("%3s %7s %10s", sid, name, tel);
						System.out.println(str);
						
					}
					rs.close();
					cstmt.close();

					
				}
				catch (Exception e)
				{
					System.out.println(e.toString());
				}
				
			}
			
			DBConn.close();
			System.out.println("데이터베이스 연결 닫힘~!!!");
			System.out.println("프로그램 종료됨~!!!");
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}

}
