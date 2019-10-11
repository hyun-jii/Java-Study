/*=============================================
 	MemberDAO.java
 	- �����ͺ��̽� �׼� ó�� ���� ��ü ����
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
	// �ֿ� ���� ���� -> DB ���� ��ü
	private Connection conn;
	
	// ������ ���� ->  ����� ���� ������
	public MemberDAO() throws ClassNotFoundException, SQLException
	{
		conn = DBConn.getConnection();
	}
	
	// ��� -> �޼ҵ� ���� -> �����͸� �Է��ϴ� ��� -> insert ������ ����
	public int add(MemberDTO dto) throws SQLException
	{
		
		  //��ȯ�� ������� ���� ���� (����� ���� ����) 
		  int result =0;
		  
		  //�۾� ��ü ���� 
		  Statement stmt = conn.createStatement();
		 
		/*
		 �� Statement �� ����
		    - Statement 
		      �ϳ��� ������ ����ϰ��� �� �̻� ����� �� ����.
		    - PreparedStatement
		      �ϳ��� PreparedStatement �� ������ ���� �� ó���� �� �ִ�.
		    - CallableStatement
		      �����ͺ��̽� ���� ������ ���ν����� �Լ� ���� ȣ���� �� �ִ�.
		      
		 �� Statement �� �ǹ�
		    �ڹٿ��� ���Ǵ� 3���� ������ �۾� ��ü����
		    �����ͺ��̽��� ������ ��Ƽ� ������ �׸� ������ ��������.
		    ��, �۾� ��ü�� ������ �Ǿ� �����ͺ��̽��� ����������
		    �� ������ �����ͺ��̽� ������ ó���Ǵ� ���̴�.
		    �� ��, �� �� ����ϰ� ������ �׸��� Statement �̸�,
		    �� ����� ������ �׸��� PreparedStatement �̴�.
		*/
	
		  
		  //������ �غ� 
		  String sql = String.format("INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.NEXTVAL, '%s','%s')", dto.getName(), dto.getTel());
		  
		  // �׽�Ʈ 
		  System.out.println(sql);
		  
		  // ������ ���� 
		  result = stmt.executeUpdate(sql);
		  
		  //����� ��ȯ
		  return result;
		 
		
		/*
		 * Scanner sc = new Scanner(System.in); int result=0;
		 * 
		 * do { System.out.println("�̸� ��ȭ��ȣ �Է�(1)");
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
	
	//��� -> �޼ҵ� ����  -> �ο� ���� �ľ��ϴ� ��� -> select ������ ����
	public int count() throws SQLException
	{
		
		  //��������� ��ȯ�ϰ� �� ���� ���� �� �ʱ�ȭ 
		  int result=0;
		  
		  //�۾� ��ü ���� 
		  Statement stmt = conn.createStatement();
		  
		  //������ �غ� 
		  String sql = "SELECT COUNT(*) AS COUNT FROM TBL_MEMBER";
		  
		  //�׽�Ʈ 
		  System.out.println(sql);
		  
		  //������ ���� -> select ������ -> ResultSet ��ȯ 
		  ResultSet rs = stmt.executeQuery(sql);
		  
		  //ResultSet ó�� -> �ݺ��� ���� 
		  while (rs.next()) // if(rs.next()) 
		  {
			  result = rs.getInt("COUNT");
		  } 
		  rs.close(); stmt.close();
		  
		  //���� ����� ��ȯ 
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
	
	//��� -> �޼ҵ� ���� -> ������ ��ü ��ȸ�ϴ� ��� -> select ������ ����
	public ArrayList<MemberDTO> lists() throws SQLException
	{
		
		ArrayList<MemberDTO> result = new ArrayList<MemberDTO>();
		
		Statement stmt = conn.createStatement();
		
		String sql = "SELECT SID, NAME, TEL FROM TBL_MEMBER ORDER BY SID";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next())
		{
			//MemberDTO �ν��Ͻ� ���� (�ݺ��ؼ�...)
			MemberDTO dto = new MemberDTO();
			dto.setSid(rs.getString("SID"));	// to.setSid(rs.getString(1));
			dto.setName(rs.getString("NAME"));	// to.setSid(rs.getString(2));
			dto.setTel(rs.getString("TEL"));	// to.setSid(rs.getString(3));
												// �� �÷� �ε����� 1����...
			
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
	
	//�����ͺ��̽� ���� ����
	public void close() throws SQLException
	{
		DBConn.close();
	}
	
}
