/*====================================================
■■■ 컬렉션 프레임워크(Collection Framework) ■■■
======================================================*/

/*
○ 큐(Queue)

   큐(Queue) 는 FIFO(Frist In First Out) 구조로
   먼저 입력된 자료를 먼저 출력하며
   Queue 인터페이스를 구현한 클래스는 큐와 관련된 다양한 기능을 제공한다.

※ Queue 인터페이스 인스턴스를 생성하기 위해서는
   new 연산자를 이용하여 Queue 인터페이스를 구현한(implements)
   클래스의 생성자를 호출한다.

   ex)Queue ob = new LinkedList();

○ 주요 메소드

   - E elemnet()
     큐의 head 요소를 반환하며 삭제하지 않는다.

   - boolean offer(E o)
     지정된 요소를 큐에 삽입한다.

   - E peek()
     큐의 헤드요소를 반환하고 삭제하지 않으며,
	 큐 자료구조가 empty인 경우 null을 반환한다.

   - E poll()
     큐의 head 요소를 반환하고 삭제하며
	 큐 자료구조가 empty인 경우 null을 반환한다.

   - E remove()
     큐의 head요소를 반환하고 삭제한다.


*/

import java.util.Queue;
import java.util.LinkedList;

public class Test155
{
	public static void main(String[] args)
	{
		//Queue 자료구조 생성
		//Queue myQue = new Queue();  //x

		Queue<Object> myQue = new LinkedList<Object>();

		//데이터 준비
		String str1 = "김창기";
		String str2 = "김현우";
		String str3 = "박종호";
		String str4 = "박지혜";

		//myQue 라는 Queue 자료구조에 데이터 추가
		//offer()
		myQue.offer(str1);
		myQue.offer(str2);
		myQue.offer(str3);
		myQue.offer(str4);

		//큐 자료구조에서 요소를 제거하지 않고 head요소 반환
		System.out.println("값1 : " + (String)myQue.element());
		System.out.println("값2 : " + (String)myQue.element());
		//--==>> 값1 : 김창기
		//		 값2 : 김창기

		System.out.println();   //개행

		String val;

		// 1
		// 큐의 head 요소 반환. 삭제 안함.
		// 큐가 empty 일 경우 null 반환.
		// peek()
		/*
		while(myQue.peek() != null)
		{
			//큐의 head요소 반환. 삭제함.
			//큐가 empty일 경우 null 반환

			val = (String)myQue.poll();
			System.out.println("요소 : " + val);
		}
		*/
		//--==>>
		/*
		요소 : 김창기
		요소 : 김현우	
		요소 : 박종호
		요소 : 박지혜
		*/

		//테스트
		/*
		while(myQue.poll() != null)
		{
			//큐의 head요소 반환. 삭제함.
			//큐가 empty일 경우 null 반환

			val = (String)myQue.poll();
			System.out.println("요소 : " + val);
		}
		*/
		//--==>> 요소 : 김현우
		//		 요소 : 박지혜

		// 2
		/*
		while (true)
		{
			val = (String)myQue.poll();

			if(val==null)
				break;
			else
				System.out.println("값 : " + val);	

		}
		*/
		//--==>>
		/*
		값 : 김창기
		값 : 김현우
		값 : 박종호
		값 : 박지혜
		*/

		// 3

		while(!myQue.isEmpty())
		{
			val = (String)myQue.poll();
			System.out.println("값 : " + val);
		}
		//--==>>
		/*
		값 : 김창기
		값 : 김현우
		값 : 박종호
		값 : 박지혜
		*/






	}
}