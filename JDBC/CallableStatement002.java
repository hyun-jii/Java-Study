/*====================================================
  Test002.java
  - CallableStatement �� Ȱ���� SQL ���� ���� �ǽ� 2
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
				System.out.println("�����ͺ��̽� ���� ����~!!!");
				
				try
				{
					String sql = "{call PRC_MEMBERSELECT(?)}";
					CallableStatement cstmt = conn.prepareCall(sql);
					
					//check~!!!
					//���ν��� ���ο��� sys_refcursor �� ����ϰ� �ֱ� ������
					//OracleTypes.CURSOR �� ����ϱ� ���� ��� ������ �ʿ��� ��Ȳ.
					// 1. ������Ʈ�� ��Ŭ�� > Build Path > Configure Build Path
					//	  ��ojdbc6.jar�� ���� �߰� ���
					//	   (�ܺ� jar ���� ����)
					// 2. ��import oracle.jdbc.OracleTypes;�� ���� �߰�
					
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
			System.out.println("�����ͺ��̽� ���� ����~!!!");
			System.out.println("���α׷� �����~!!!");
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}

}
