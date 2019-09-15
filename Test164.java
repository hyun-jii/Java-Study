/*====================================================
■■■ 컬렉션 프레임워크(Collection Framework) ■■■
======================================================*/

// List -> Vector, ArrayList
// - 순서 있음
// - 배열과 유사
// - 중복 허용

/*
○ ArrayList 클래스

   - ArrayList 와 Vector 클래스는
     List 를 크기 변경이 가능한 배열로 구현한 것으로
	 차이점음 Vector 클래스의 객체는 기본적으로 동기화 되지만,
	 ArrayList 는 그렇지 않다는 점이다.

   - 비동기화 컬렉션은 동기화된 컬렉션보다 더 나은 성능을 제공하며
     스레드들이 컬렉션을 공유하지 않는 프로그램에서는
	 일반적으로 ArrayList를 Vector보다 더 선호하며,
	 ArrayList 는 동기화를 고려하지 않은 Vector 처럼 동작함으로써
	 스레드 동기화에 따른 부담을 가지지 않기 때문에
	 Vector보다 더 빠르게 실행된다.

   - null 을 포함한 모든 요소를 허용하며
     List 인터페이스를 구현하는 것 외에 리스트에 격납하기 위해
	 내부적으로 사용되는 배열의 사이즈를 조작하는 메소드를 제공한다.
*/
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Test164
{
	public static void main(String[] args)
	{
		// ArrayList 자료구조 인스턴스 생성
		//ArrayList<String> list = new ArrayList<String>();
		//Vector<String> list = new Vector<String>();
		//List<String> list = new Vector<String>();
		List<String> list1 = new ArrayList<String>();

		//list1 에 요소 추가 -> add()
		list1.add("봉오동전투");
		list1.add("알라딘");
		list1.add("토이스토리");

		// ArrayList 자료구조 인스턴스 생성
		List<String> list2 = new ArrayList<String>(list1);

		//list2에 요소 추가
		list2.add("엑시트");
		
		//ArrayList 자료구조 인스턴스 생성
		List<String> list3 = new ArrayList<String>();

		//list3에 list2의 전체 요소 추가 -> addAll()
		list3.addAll(list2);


		//"알라딘" 앞에  "겨울왕국" 추가
		//-- 1 "알라딘" 찾기 -> indexOf() -> 위치값 인덱스 반환
		int n = list3.indexOf("알라딘");

		//테스트
		//System.out.println(n);   //--==>> 1

		//-- 2 "알라딘" 찾은 인덱스 위치에 "겨울왕국" 투입(삽입)
		list3.add(n, "겨울왕국");


		// 출력 -> 더미 데이터 확인
		System.out.println("=============================");
		System.out.println(list1);
		//--==>> [봉오동전투, 알라딘, 토이스토리]
		System.out.println(list2);
		//--==>> [봉오동전투, 알라딘, 토이스토리]
		System.out.println(list3);
		//--==>> [봉오동전투, 겨울왕국, 알라딘, 토이스토리, 엑시트]


		System.out.println();

		//출력 -> listIterator() 메소드를 활용하여 출력
		System.out.println("============================");
		ListIterator<String> li = list3.listIterator();
		
		while (li.hasNext())
			System.out.print(li.next() + " " );
		System.out.println("\n");
		//--==>> 봉오동전투 겨울왕국 알라딘 토이스토리 엑시트

		//출력 -> 역순으로 출력
		System.out.println("==============================");
		while (li.hasPrevious())	
			System.out.print(li.previous() + " ");}
		System.out.println();
		//--==>> 엑시트 토이스토리 알라딘 겨울왕국 봉오동전투


	}
}