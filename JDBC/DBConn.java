/*================================
 		DBConn.java
 =================================*/

// �� �̱���(Singleton) ������ ������ �̿��� Database ���� ��ü ���� ���� Ŭ����
//    -> DB ���� ������ ���� ���ϰ� ũ�� ������
//       ������ �ʿ��� �� ���� ��ü�� �����ϴ� ���� �ƴ϶�
//       �� �� ����� ��ü�� ��� ����ϵ��� ó��.

package com.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConn
{
	// ���� ����
	private static Connection dbConn;
	//-- �ڵ����� null �ʱ�ȭ
	
	// �޼ҵ� ���� -> ����
	public static Connection getConnection()
	{
		// �� �� ����� ��ü�� ��� ���...
		// ��, ������� ���� ��쿡�� ������ �õ��ϰڴٴ� �ǹ�
		// -> Singleton(������ ����)
		if(dbConn == null)
		{
			try
			{
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				// localhost �� ����Ŭ ������ IP �ּҸ� �����ϴ� �κ�
				// 1521 �� ����Ŭ Port Number
				// xe �� ����Ŭ SID (Express Edition �� xe)
				
				String user = "scott";	//-- ����Ŭ ����� ���� �̸�
				String pwd = "tiger"; 	//-- ����Ŭ ����� ���� ��ȣ
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//-- OracleDriver Ŭ������ ���� ��ü ����
				//	 ����̹� �ε� -> JVM �� ����
				
				dbConn = DriverManager.getConnection(url, user, pwd);
				//-- ����Ŭ ���� ���� ����
				//   ��(line 30~40)������... ������ ���� ȯ���� �����ϴ� ����
				//   �����ִ� ���ڰ�(�Ű�����)�� ����Ŭ �ּ�, ������, �н�����
				
			} 
			catch (Exception e)	// (ClassNotFoundException, SQLException)
			{
				System.out.println(e.toString());
				//-- ����Ŭ ���� ���� ���� ��... ���� �޼��� ����ϴ� �κ�
			}
		}
		
		return dbConn;
		//-- ������ ���� ��ü ��ȯ
	
	} // end getConnection()
	
	// getConnection() �޼ҵ��� �����ε� -> ����
	public static Connection getConnection(String url, String user, String pwd)
	{
		if (dbConn == null)
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				dbConn = DriverManager.getConnection(url, user, pwd);
				
			} 
			catch (Exception e)
			{
				System.out.println(e.toString());
			}
		}
		
		
		return dbConn;
		//-- ������ ���� ��ü ��ȯ
	
	}// end getConnection()
	
	
	// �޼ҵ� ���� -> ���� ���� �޼ҵ�
	public static void close()
	{
		// dbConn ����(��� ����)��
		// Database �� ����� ������ ��� Connection�� ���´�.
		// ������� ���� ���¶�� null �� ���°� �ȴ�.
		if (dbConn != null)
		{
			try
			{
				// ���� ��ü�� isClosed() �޼ҵ带 ���� ������� Ȯ��
				//-- ������ �����ִ� ��� true ��ȯ
				//   ������ �������� ���� ��� false ��ȯ
				if(!dbConn.isClosed())
				{
					dbConn.close();
					//-- ���� ��ü�� close() �޼ҵ带 ���� ���� ����
				}
				
			} 
			catch (Exception e)
			{
				System.out.println(e.toString());
			}
		}
		dbConn = null;
		//-- ���� ��ü �ʱ�ȭ 
		
	} // end close()

}
