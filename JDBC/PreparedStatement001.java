/*===================================
  	Test001.java
  	- ������ ���� �ǽ� 1
=====================================*/

package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.util.DBConn;

public class Test001
{
	public static void main(String[] args)
	{
		try
		{
			Connection conn = DBConn.getConnection();
			
			if(conn != null)
			{
				System.out.println("�����ͺ��̽� ���� ����");
				
				try
				{
					/*
					Statement stmt = conn.createStatement();
					String sql = "INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.NEXTVAL,'������','010-1212-1212')";
					
					int result  = stmt.executeUpdate(sql);
					if(result > 0)
					{
						System.out.println("������ �Է� ����");
					}
					*/
					
					/*
					String sql = "INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.NEXTVAL,'������','010-3434-3434')";
					Statement stmt = conn.createStatement();
					
					int result  = stmt.executeUpdate(sql);
					if(result > 0)
					{
						System.out.println("������ �Է� ����");
					}
					*/
					
					/*
					String sql = "INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.NEXTVAL,'������','010-3434-3434')";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					
					int result  = pstmt.executeUpdate();
					if(result > 0)
					{
						System.out.println("������ �Է� ����");
					}
					*/
					
					String sql = "INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(?,?,?)";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, 13);
					pstmt.setString(2, "������");
					pstmt.setString(3, "010-4545-4545");
					
					int result  = pstmt.executeUpdate();
					if(result > 0)
					{
						System.out.println("������ �Է� ����");
					}
					
					
				}
				catch (Exception e)
				{
					System.out.println(e.toString());
				}
			}
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}

}
