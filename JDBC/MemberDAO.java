/*=============================================
 	MemberDAO.java
 	- 데이터베이스 액션 처리 전용 객체 구성
 ==============================================*/

package com.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.util.DBConn;

public class MemberDAO
{
	// 주요 변수 선언 -> DB 연결 객체
	private Connection conn;
	
	// 생성자 정의 ->  사용자 정의 생성자
	public MemberDAO() throws ClassNotFoundException, SQLException
	{
		conn = DBConn.getConnection();
	}
	
	// 기능 -> 메소드 정의 -> 데이터를 입력하는 기능 -> insert 쿼리문 수행
	public int add(MemberDTO dto) throws SQLException
	{
		
		  //반환할 결과값을 담을 변수 (적용된 행의 개수) 
		  int result =0;
		  
		  //작업 객체 생성 
		  Statement stmt = conn.createStatement();
		 
		/*
		 ※ Statement 의 종류
		    - Statement 
		      하나의 쿼리를 사용하고나면 더 이상 사용할 수 없다.
		    - PreparedStatement
		      하나의 PreparedStatement 로 쿼리를 여러 번 처리할 수 있다.
		    - CallableStatement
		      데이터베이스 내의 스토어드 프로시저나 함수 등을 호출할 수 있다.
		      
		 ※ Statement 의 의미
		    자바에서 사용되는 3가지 종류의 작업 객체들은
		    데이터베이스로 쿼리를 담아서 보내는 그릇 정도로 생각하자.
		    즉, 작업 객체에 쿼리를 실어 데이터베이스로 보내버리면
		    그 내용이 데이터베이스 내에서 처리되는 것이다.
		    이 때, 한 번 사용하고 버리는 그릇은 Statement 이며,
		    재 사용이 가능한 그릇은 PreparedStatement 이다.
		*/
	
		  
		  //쿼리문 준비 
		  String sql = String.format("INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.NEXTVAL, '%s','%s')", dto.getName(), dto.getTel());
		  
		  // 테스트 
		  System.out.println(sql);
		  
		  // 쿼리문 실행 
		  result = stmt.executeUpdate(sql);
		  
		  //결과값 반환
		  return result;
		 
		
		/*
		 * Scanner sc = new Scanner(System.in); int result=0;
		 * 
		 * do { System.out.println("이름 전화번호 입력(1)");
		 * 
		 * dto.setName(sc.next());
		 * 
		 * if(dto.getName().equals(".")) break;
		 * 
		 * dto.setTel(sc.next());
		 * 
		 * Statement stmt = conn.createStatement(); String sql = String.
		 * format("INSERT INTO TBL_MEMBER VALUES(MEMBERSEQ.NEXTVAL, '%s', '%s')" ,
		 * dto.getName(), dto.getTel());
		 * 
		 * result = stmt.executeUpdate(sql);
		 * 
		 * stmt.close();
		 * 
		 * } while (true);
		 * 
		 * return result;
		 */
		 
	}
	
	//기능 -> 메소드 정의  -> 인원 수를 파악하는 기능 -> select 쿼리문 수행
	public int count() throws SQLException
	{
		
		  //결과값으로 반환하게 될 변수 선언 및 초기화 
		  int result=0;
		  
		  //작업 객체 생성 
		  Statement stmt = conn.createStatement();
		  
		  //쿼리문 준비 
		  String sql = "SELECT COUNT(*) AS COUNT FROM TBL_MEMBER";
		  
		  //테스트 
		  System.out.println(sql);
		  
		  //쿼리문 실행 -> select 쿼리문 -> ResultSet 반환 
		  ResultSet rs = stmt.executeQuery(sql);
		  
		  //ResultSet 처리 -> 반복문 구성 
		  while (rs.next()) // if(rs.next()) 
		  {
			  result = rs.getInt("COUNT");
		  } 
		  rs.close(); stmt.close();
		  
		  //최종 결과값 반환 
		  return result;
		 
		
		
		/*
		 * Statement stmt = conn.createStatement();
		 * 
		 * String sql = "SELECT COUNT(*) AS COUNT FORM TBL_MEMBER";
		 * 
		 * ResultSet rs = stmt.executeQuery(sql);
		 * 
		 * int result = rs.getInt("COUNT");
		 * 
		 * 
		 * stmt.close();
		 * 
		 * return result;
		 */
		 	
		
	} // end count()
	
	//기능 -> 메소드 정의 -> 데이터 전체 조회하는 기능 -> select 쿼리문 수행
	public ArrayList<MemberDTO> lists() throws SQLException
	{
		
		ArrayList<MemberDTO> result = new ArrayList<MemberDTO>();
		
		Statement stmt = conn.createStatement();
		
		String sql = "SELECT SID, NAME, TEL FROM TBL_MEMBER ORDER BY SID";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next())
		{
			//MemberDTO 인스턴스 생성 (반복해서...)
			MemberDTO dto = new MemberDTO();
			dto.setSid(rs.getString("SID"));	// to.setSid(rs.getString(1));
			dto.setName(rs.getString("NAME"));	// to.setSid(rs.getString(2));
			dto.setTel(rs.getString("TEL"));	// to.setSid(rs.getString(3));
												// ※ 컬럼 인덱스는 1부터...
			
			result.add(dto);
		}
		rs.close();
		stmt.close();
		
		return result;
		/*
		 * Statement stmt = conn.createStatement();
		 * 
		 * MemberDTO dto = new MemberDTO();
		 * 
		 * String sql = "SELECT SID, NAME, TEL FROM TBL_MEMBER";
		 * 
		 * ResultSet rs = stmt.executeQuery(sql);
		 * 
		 * ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		 * 
		 * while (rs.next()) { String sid = rs.getString("SID"); String name =
		 * rs.getString("NAME"); String tel = rs.getString("TEL");
		 * 
		 * dto.setSid(sid); dto.setName(name); dto.setTel(tel);
		 * 
		 * //String str = String.format("%3s %8s %12s", sid, name, tel);
		 * 
		 * list.add(dto);
		 * 
		 * System.out.println(list);
		 * 
		 * }
		 * 
		 * rs.close(); stmt.close();
		 * 
		 * return list;
		 */
		
	}
	
	//데이터베이스 연결 종료
	public void close() throws SQLException
	{
		DBConn.close();
	}
	
}
