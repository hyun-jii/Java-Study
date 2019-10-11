/*========================================
 * MemberMain.java
 * - main() �޼ҵ带 �����ϰ� �ִ� Ŭ����
 =========================================*/


//�� TBL_MEMBER ���̺��� Ȱ���Ͽ�
//   �̸��� ��ȭ��ȣ�� ���� �� �Է¹ް�,
//   ��ü ����ϴ� ����� ���� ���α׷��� �����Ѵ�.
//   ��, �����ͺ��̽� ������ �̷������ �ϰ�,
//   MemberDAO, MemberDTO Ŭ������ Ȱ���ؾ� �Ѵ�.

/*���� ��)

�̸� ��ȭ��ȣ �Է�(1) : ���ʷ� 010-1111-1111
>> ȸ�� ���� �Է� �Ϸ�~!!!
�̸� ��ȭ��ȣ �Է�(2) : ������ 010-2222-2222
>> ȸ�� ���� �Է� �Ϸ�~!!!
�̸� ��ȭ��ȣ �Է�(3) : �赿�� 010-3333-3333
>> ȸ�� ���� �Է� �Ϸ�~!!!
�̸� ��ȭ��ȣ �Է�(4) : .

---------------------------------------
��ü ȸ�� �� : 3��
---------------------------------------
��ȣ	�̸�		��ȭ��ȣ
1		���ʷ�		010-1111-1111
2		������		010-2222-2222
3		�赿��		010-3333-3333
---------------------------------------
*/

// TBL_MEMBER ���̺� ���� ���� ������ ���� �� ������ ��ü ����


package com.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.util.DBConn;

public class MemberMain
{

	public static void main(String[] args) throws SQLException, ClassNotFoundException 
	{
		MemberDAO dao = new MemberDAO();
		
		
		
		Scanner sc = new Scanner(System.in);
		int i = dao.count();
		
		
		 do 
		 { 
			 System.out.printf("�̸� ��ȭ��ȣ �Է�(%d)", (i+1));
			 
			 MemberDTO dto = new MemberDTO();
		 
			 dto.setName(sc.next());
			  
			 if(dto.getName().equals(".")) 
			 {
				 break;
			 }
			  
			 dto.setTel(sc.next());
			 
			 int result = dao.add(dto);
			 
			 if(result > 0)
				 System.out.println(">> ȸ�� ���� �Է� �Ϸ�~!!!");
			 
			 i++;
			 
		
		 } while (true);
		  	
		
		System.out.println("-------------------------------------");
		int count = dao.count();
		System.out.println("��ü ȸ�� �� :" + count);
	
		System.out.println("-------------------------------------");
		System.out.println("��ȣ       �̸�        ��ȭ��ȣ");
		
		for (MemberDTO obj : dao.lists())
		{
			System.out.printf("%3s %7s %12s", obj.getSid(), obj.getName(), obj.getTel());
			System.out.println();
			
		}
		
		
		/*
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		list = dao.lists();
		
		Iterator<MemberDTO> it = dao.lists().iterator();
		
		while (it.hasNext())
		{
			MemberDTO memberDTO = (MemberDTO) it.next();
			System.out.printf("%3s   %5s   %12s", memberDTO.getSid(), memberDTO.getName(), memberDTO.getTel());
			System.out.println();
			
		}
		*/
		

	} 

}
