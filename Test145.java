/*===============================================
	 ■■■ 자바의 주요(중요) 클래스 ■■■
	 - Random 클래스
=================================================*/

/*
○ java.util.Random 클래스는
  
   여러 형태의 난수를 발생시켜 제공하는 클래스이다.
   Math 클래스의 정적 메소드인 random()메소드도 난수를 제공하는 메소드 이지만
   0.0 ~ 1.0 사이의 실수 형태만 발생하게 되므로
   필요한 여러 형태의 난수를 만들어내기 위해서는 추가적인 연산들을 수행해야 한다.
   그래서 자바는 여러 형태의 난수를 발생시켜주는
   전용 클래스인 Random 클래스를 별도로 제공하고 있다.
*/

//로또 번호 생성기(난수 발생 프로그램)

//프로그램이 실행되면 기본적으로 로또를 5게인 수행하는 프로그래믈 구현한다.

//실행 예)
// 3 5 12 24 31 41
// 1 2 8 23 36 38
// 4 9 11 13 22 30
// 5 10 12 15 27 40
// 22 31 32 33 40 45
//계속하려면 아무 키나 누르세요...

import java.util.Random;
import java.util.Arrays;

class Lotto
{
	//배열 변수 선언 및 메모리 할당 -> 로또 번호를 담아둘 배열방 6개
	private int[] num = new int[6];

	//getter
	public int[] getNum()
	{
		return num;
	}

	//6개의 난수를 발생시키는 메소드 정의
	public void start()
	{

		int cnt = 0;
		Random rd = new Random();
		int n;

		jump:

		while (cnt<6)                // 0	1	2
		{		
			n = rd.nextInt(45)+1;    // 10  7	10
			for (int i=0; i<cnt; i++)
			{
				if (num[i]==n)
					continue jump;
			}
			num[cnt++] = n;         // num[0] = 10;
			                        // num[1] = 7;
		}

		//정렬 메소드 호출
		sorting();
		/*---------------------------------내가 한것----------------------------
		Random rd = new Random();
		int temp;

		for(int i=0; i<num.length; i++)
		{
			num[i] = rd.nextInt(45)+1;

			for(int j=i; j<num.length; j++)
			{
				if(num[i] == num[j])
				{
					i--;
					num[i] = rd.nextInt(45)+1;
				}
			}


		}


		for(int i=0; i<num.length-1; i++)
		{
			for(int j=i+1; j<num.length; j++)
			{

				if(num[i] > num[j])
				{
					temp=num[i];
					num[i]=num[j];
					num[j]=temp;
				}
			}
		}

		-------------------------------------------------------------*/

	}

	//정렬 메소드
	public void sorting()
	{
		Arrays.sort(num);
	}
}

public class Test145
{
	public static void main(String[] args)
	{
		//Lotto 클래스 기반 인스턴스 생성
		Lotto lotto = new Lotto();

		//기본 5게임
		for(int i=1; i<=5; i++)
		{
			lotto.start();

			//결과 출력
			for(int n : lotto.getNum())
			{
				System.out.printf("%4d", n);
			}
			System.out.println();
		}
	}
}