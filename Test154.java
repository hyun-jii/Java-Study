/*====================================================
■■■ 컬렉션 프레임워크(Collection Framework) ■■■
======================================================*/
import java.util.Stack;

public class Test154
{

	//정적 문자열 배열 선언 및 초기화
	private static final String[] colors
		= {"검정","노랑","초록","파랑","빨강","연두"};

	//생성자
	public Test154()
	{
		//st 라는 Stack 자료구조 생성
		//제네릭을 활용하여 자료구조에 담기는 데이터 표현 -> 『<String>』
		Stack<String> st = new Stack<String>();

		//st라는 Stack 자료구조에 데이터 담기
		for(String color : colors)
			st.push(color);

		//데이터 추가
		st.push("보라");

		//데이터 추가
		//st.push(10.0);
		//--==>> 에러 발생(컴파일 에러)
		//-- 제네릭 표현식을 통해 선언하고 있는
		//   String이 아닌 다른 자료형(double)을 스택 st에 push()하려고 했기 때문에...

		//출력 메소드 호출
		popStack(st);
		
	}

	//출력 메소드
	private void popStack(Stack<String> st)
	{
		System.out.print("pop :  ");
		while (!st.empty())
			System.out.print(st.pop()+ " ");
		System.out.println();
	}

	public static void main(String[] args)
	{
		new Test154();

	}
}