/*===============================
 		Test001.java
 		- Database ���� �׽�Ʈ
 ================================*/

package com.test;

import java.sql.Connection;

import com.util.DBConn;

public class Test001
{

	public static void main(String[] args)
	{
		Connection conn = DBConn.getConnection();
		// �� DB ���� ������ ���ϰ� ũ�� ������ 
		//    �� �� ����� ��ü�� ��� ����� �� �ֵ��� Singleton ���� ����
		
		if(conn != null)
		{
			System.out.println("�����ͺ��̽� ���� ����~!!!");
		}
		
		DBConn.close();

	}

}
