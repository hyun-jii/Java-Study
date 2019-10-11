/*========================================
   			ScoreMain.java 
==========================================*/

//�� �ǽ�����
//	 ���� ó�� ���α׷��� �����Ѵ�. -> �����ͺ��̽� ���� -> ScoreDAO, ScoreDTO Ȱ��

//	 ���� ���� �̸�, ��������, ��������, ���������� �Է¹޾�
//   ����, ����� �����Ͽ� ����ϴ� ���α׷��� �����Ѵ�.
//   ��� �� ��ȣ(�̸�, ���� ��) �������� �����Ͽ� ����Ѵ�.

//   ���� ��)
/*
 1�� �л� ���� �Է�(�̸� ���� ���� ����) : ������ 80 75 60
 2�� �л� ���� �Է�(�̸� ���� ���� ����) : ������ 100 90 80
 3�� �л� ���� �Է�(�̸� ���� ���� ����) : ������ 80 85 80
 4�� �л� ���� �Է�(�̸� ���� ���� ����) : .
 
 -------------------------------------------------------------
 ��ȣ	�̸�	����	����	����	����	���
 -------------------------------------------------------------
 1   ������       80       75      60   xxx     xx.x
 2   ������       100      90      80   xxx     xx.x
 3   ������       80      85       80   xxx     xx.x
 -------------------------------------------------------------

 */
package com.test;

import java.sql.SQLException;
import java.util.Scanner;

public class ScoreMain
{

	public static void main(String[] args) throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		
		ScoreDAO dao = new ScoreDAO();
		
		do
		{
	
			System.out.print((dao.count()+1) +"�л� ���� �Է�(�̸� ���� ���� ����) : ");
			ScoreDTO dto = new ScoreDTO();
			
			dto.setSid(dao.count()+1);
			
			dto.setName(sc.next());
			
			if(dto.getName().equals("."))
				break;
			
			dto.setKor(sc.nextInt());
			dto.setEng(sc.nextInt());
			dto.setMat(sc.nextInt());
			dto.setTot(dto.getKor()+dto.getEng()+dto.getMat());
			dto.setAvg((dto.getKor()+dto.getEng()+dto.getMat())/3.0);
			
			dao.add(dto);
	
		} while (true);
		
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("��ȣ  �̸�  ����  ����  ����  ����  ���");
		System.out.println("----------------------------------------------------------------------------------");
		for (ScoreDTO ob : dao.lists())
		{
			System.out.printf("%4d %4s %4d %4d %4d %4d %4f",ob.getSid(),ob.getName(), ob.getKor(), ob.getEng(), ob.getMat(),  ob.getTot(),  ob.getAvg());
			
		}
		System.out.println("----------------------------------------------------------------------------------");
		
		
	}

}
