/*========================================
   			ScoreMain.java 
==========================================*/

//○ 실습문제
//	 성적 처리 프로그램을 구현한다. -> 데이터베이스 연동 -> ScoreDAO, ScoreDTO 활용

//	 여러 명의 이름, 국어점수, 영어점수, 수학점수를 입력받아
//   총점, 평균을 연산하여 출력하는 프로그램을 구현한다.
//   출력 시 번호(이름, 총점 등) 오름차순 정렬하여 출력한다.

//   실행 예)
/*
 1번 학생 성적 입력(이름 국어 영어 수학) : 박혜민 80 75 60
 2번 학생 성적 입력(이름 국어 영어 수학) : 오지은 100 90 80
 3번 학생 성적 입력(이름 국어 영어 수학) : 김종범 80 85 80
 4번 학생 성적 입력(이름 국어 영어 수학) : .
 
 -------------------------------------------------------------
 번호	이름	국어	영어	수학	총점	평균
 -------------------------------------------------------------
 1   박혜민       80       75      60   xxx     xx.x
 2   오지은       100      90      80   xxx     xx.x
 3   김종범       80      85       80   xxx     xx.x
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
	
			System.out.print((dao.count()+1) +"학생 성적 입력(이름 국어 영어 수학) : ");
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
		System.out.println("번호  이름  국어  영어  수학  총점  평균");
		System.out.println("----------------------------------------------------------------------------------");
		for (ScoreDTO ob : dao.lists())
		{
			System.out.printf("%4d %4s %4d %4d %4d %4d %4f",ob.getSid(),ob.getName(), ob.getKor(), ob.getEng(), ob.getMat(),  ob.getTot(),  ob.getAvg());
			
		}
		System.out.println("----------------------------------------------------------------------------------");
		
		
	}

}
