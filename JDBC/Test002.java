/*===============================
 		Test002.java
 		- ������ �Է� �ǽ� ����
 ================================*/
package com.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.util.DBConn;

public class Test002
{
	public static void main(String[] args)
	{
		Connection conn = DBConn.getConnection();
		
		if(conn == null)
		{
			System.out.println("�����ͺ��̽� ���� ����~!!!");
			System.exit(0);
		}
		
		//System.out.println("�����ͺ��̽� ���� ����~!!!");
		
		try
		{
			// �۾� ��ü �غ�
			Statement stmt = conn.createStatement();
			
			// ������ �Է� ���� ���� ����
			// �� �� �����ϸ� �ٽ� �������� ���Ѵ�.
			// �⺻Ű ���������� �����Ǿ� �����Ƿ�
			// ������ Ű ���� �ߺ��� �� �ֱ� �����̴�.
			
			
			// ������ �غ�
			String sql = "INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(2, '����ȣ','010-2222-2222')";
			//-- ����. ������ ���� ��;�� ������ �ʴ´�.
			//-- ����. �ڹٿ��� ������ DML ������ ���������� �ڵ� COMMIT �ȴ�.
			//-- ����. ����Ŭ���� Ʈ����� ó���� ������ ������
			//		   ������ �׼� ó���� �̷������ �ʴ´�.
			//		   (��, ����Ŭ���� ���� �������� �׽�Ʈ �� ���
			//		   COMMIT �Ǵ� ROLLBACK �� �ݵ�� ������ �� �ֵ��� �Ѵ�.
			
			int result = stmt.executeUpdate(sql);
			
			if(result > 0)
			{
				System.out.println("������ �Է� ����~!!!");
			}
			else
			{
				System.out.println("�Է� ����~ ��_��");
			}
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		DBConn.close();
		
	}

}
/* ���� ���
 
 ������ �Է� ����~!!!
 */
