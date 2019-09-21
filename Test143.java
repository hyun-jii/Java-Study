/*===============================================
	 ■■■ 자바의 주요(중요) 클래스 ■■■
	 - Calendar 클래스
=================================================*/

//실습문제
//오늘을 기준으로 입력받는 날짜만큼 후의 년, 월, 일, 요일을
//확인하여 결과를 출력하는 프로그램을 구현한다.

//실행 예)
//오늘 날짜 : 2019-8-22 목요일
//몇 일 후의 날짜를 확인하고자 하십니까? : 200 

//============[확인 결과]=================
//200일 후 : 2020-xx-xx x요일
//========================================
//계속하려면 아무 키나 누르세요...

// ※ 현재 날짜를 기준으로 날 수를 더하는 연산 메소드
//    객체.add(Calendar.DATE, 날 수);

import java.util.Calendar;
import java.util.Scanner;

public class Test143
{
	public static void main(String[] args)
	{

		//Scanner 클래스 기반 인스턴스 생성
		Scanner sc = new Scanner(System.in);

		//Calendar 클래스 기반 인스턴스 생성
		Calendar now = Calendar.getInstance();

		//주요 변수 선언
		int nalsu;        //-- 사용자로부터 입력받은 날 수
		int y,m,d,w;      //-- 연, 월, 일, 요일
		String[] week = {"일","월","화","수","목","금","토"};

		//현재의 연,월,일,요일 확인(가져오기 : get())
		y = now.get(Calendar.YEAR);
		m = now.get(Calendar.MONTH)+1;
		d = now.get(Calendar.DATE);
		w = now.get(Calendar.DAY_OF_WEEK);

		//현재의 연,월,일,요일 확인결과 출력
		System.out.println("오늘 날짜 : " + y + "-" + m + "-" + d
			+ " " + week[w-1] + "요일");

		do
		{
			System.out.print("몇 일 후의 날짜를  확인하고자 하십니까? : ");
			nalsu = sc.nextInt();
		}
		while (nalsu < 1);

		// check~!!!
		now.add(Calendar.DATE, nalsu);

		//결과출력
		System.out.println();
		System.out.println("===================[확인 결과]====================");
		System.out.printf("%d 일 후 : %tF %tA\n" , nalsu, now, now);
		System.out.println("==================================================");

		
		/*--------------------------------------내가 한 풀이------------------------------------
		Scanner sc = new Scanner(System.in);

		//캘린더 클래스 기반의 인스턴스 생성
		Calendar cal = Calendar.getInstance();

		int d;            //사용자에게 입력받을 몇일 후의 날짜

		int week = cal.get(Calendar.DAY_OF_WEEK);

		String w="";
		
		switch(week)
		{
			case Calendar.SUNDAY: w="일요일"; break;
			case Calendar.MONDAY: w="월요일"; break;
			case Calendar.TUESDAY: w="화요일"; break;
			case Calendar.WEDNESDAY: w="수요일"; break;
			case Calendar.THURSDAY: w="목요일"; break;
			case Calendar.FRIDAY: w="금요일"; break;
			case Calendar.SATURDAY: w="토요일"; break;
		}

		//오늘 날짜 출력
		System.out.println(cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DATE) + " " +  w);

		System.out.print("몇 일 후의 날짜를 확인하고자 하십니까? : ");
		d = sc.nextInt();

		cal.add(Calendar.DATE, d);

        week = cal.get(Calendar.DAY_OF_WEEK);

		switch(week)
		{
			case Calendar.SUNDAY: w="일요일"; break;
			case Calendar.MONDAY: w="월요일"; break;
			case Calendar.TUESDAY: w="화요일"; break;
			case Calendar.WEDNESDAY: w="수요일"; break;
			case Calendar.THURSDAY: w="목요일"; break;
			case Calendar.FRIDAY: w="금요일"; break;
			case Calendar.SATURDAY: w="토요일"; break;
		}

		
		//System.out.println(cal.get(Calendar.DATE));
		
		System.out.println(cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DATE) + " " +  w);

		--------------------------------------------------------------------------------------------------*/



	}
}