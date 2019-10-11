/*========================================
 * MemberMain.java
 * - main() 메소드를 포함하고 있는 클래스
 =========================================*/


//○ TBL_MEMBER 테이블을 활용하여
//   이름과 전화번호를 여러 건 입력받고,
//   전체 출력하는 기능을 가진 프로그램을 구현한다.
//   단, 데이터베이스 연동이 이루어져야 하고,
//   MemberDAO, MemberDTO 클래스를 활용해야 한다.

/*실행 예)

이름 전화번호 입력(1) : 강초롱 010-1111-1111
>> 회원 정보 입력 완료~!!!
이름 전화번호 입력(2) : 안준헌 010-2222-2222
>> 회원 정보 입력 완료~!!!
이름 전화번호 입력(3) : 김동현 010-3333-3333
>> 회원 정보 입력 완료~!!!
이름 전화번호 입력(4) : .

---------------------------------------
전체 회원 수 : 3명
---------------------------------------
번호	이름		전화번호
1		강초롱		010-1111-1111
2		안준헌		010-2222-2222
3		김동현		010-3333-3333
---------------------------------------
*/

// TBL_MEMBER 테이블에 대한 기존 데이터 삭제 및 시퀀스 객체 생성


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
			 System.out.printf("이름 전화번호 입력(%d)", (i+1));
			 
			 MemberDTO dto = new MemberDTO();
		 
			 dto.setName(sc.next());
			  
			 if(dto.getName().equals(".")) 
			 {
				 break;
			 }
			  
			 dto.setTel(sc.next());
			 
			 int result = dao.add(dto);
			 
			 if(result > 0)
				 System.out.println(">> 회원 정보 입력 완료~!!!");
			 
			 i++;
			 
		
		 } while (true);
		  	
		
		System.out.println("-------------------------------------");
		int count = dao.count();
		System.out.println("전체 회원 수 :" + count);
	
		System.out.println("-------------------------------------");
		System.out.println("번호       이름        전화번호");
		
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
