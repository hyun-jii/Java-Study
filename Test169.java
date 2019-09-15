/*====================================================
■■■ 컬렉션 프레임워크(Collection Framework) ■■■
======================================================*/

// Set -> HashSet, TreeSet
// - 순서 없음
// - 중복 허용하지 않는 구조(기본)
 
/*
○ TreeSet<E> 클래스

   java.util.TreeSet<E> 클래스는
   Set 인터페이스를 상속한 SortedSet 인터페이스를 구현한 클래스로
   데이터를 추가하면 데이터들이 자동으로 오름차순 정렬이 된다.

*/

import java.util.TreeSet;
import java.util.Iterator;
import java.util.Comparator;

//VO  -> Value Object
//DTO -> Data Transfer Object
//DAO -> Data Access Object

class GradeVO
{
	//주요 속성 구성
	private String hak;        //-- 학번
	private String name;       //-- 이름
	private int kor, eng, mat; //-- 국어점수, 영어점수, 수학점수

	//생성자(사용자 정의 생성자 -> 5개의 매개변수를 가진 생성자)
	GradeVO(String hak, String name, int kor, int eng, int mat)
	{
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	//생성자(사용자 정의 생성자 -> 매개변수 없는 생성자)
	GradeVO()
	{

	}

	//getter / setter 구성
	String getHak()
	{
		return hak;
	}
	void setHak(String hak)
	{
		this.hak = hak;
	}

	String getName()
	{
		return name;
	}
	void setName(String name)
	{
		this.name = name;
	}

	int getKor()
	{
		return kor;
	}
	void setKor(int kor)
	{
		this.kor = kor;
	}

	int getEng()
	{
		return eng;
	}

	void setEng(int eng)
	{
		this.eng = eng;
	}

	int getMat()
	{
		return mat;
	}
	void setMat(int mat)
	{
		this.mat = mat;
	}

	//추가 메소드 정의(총점)
	int getTot()
	{
		return kor+eng+mat;
	}

}

class MyComparator<T> implements Comparator<T>
{
	@Override
	public int compare(T o1, T o2)
	{
		GradeVO s1 = (GradeVO)o1;
		GradeVO s2 = (GradeVO)o2;

		//총점 기준
		//return s1.getTot() - s2.getTot();  
		//return s2.getTot() - s1.getTot(); 

		//이름 기준
		//return s1.getName().compareTo(s2.getName());
		return s2.getName().compareTo(s1.getName());
	}
}

public class Test169
{
	public static void main(String[] args)
	{
		//TreeSet 자료구조 인스턴스 생성
		TreeSet<String> set = new TreeSet<String>();

		//TreeSet 자료구조 set에 요소 추가 -> add()
		set.add("원피스");
		set.add("포켓몬스터");
		set.add("겨울왕국");
		set.add("톰과제리");
		set.add("원펀맨");
		set.add("라이온킹");
		set.add("짱구는 못말려");
		set.add("알라딘");
		set.add("라푼젤");
		set.add("세일러문");
		set.add("나루토");
		set.add("명탐정코난");


		//Iterator를 활용한 set 요소 전체 출력
		Iterator<String> it = set.iterator();

		while(it.hasNext())
			System.out.print(it.next()+ " ");
		System.out.println();
		//--==>> 겨울왕국 나루토 라이온킹 라푼젤 명탐정코난 세일러문 알라딘 원펀맨 원피스 짱구는 못말려 톰과제리 포켓몬스터

		//TreeSet 자료구조 인스턴스 생성
		//TreeSet<GradeVO> set2 = new TreeSet<GradeVO>();

		//TreeSet 자료구조 인스턴스 다시 생성
		TreeSet<GradeVO> set2 = new TreeSet<GradeVO>(new MyComparator<GradeVO>());
		

		set2.add(new GradeVO("1911013", "정광현", 50, 60, 70));
		set2.add(new GradeVO("1911025", "정민하", 91, 83, 76));
		set2.add(new GradeVO("1911032", "최창훈", 58, 36, 81));
		set2.add(new GradeVO("1911049", "한현수", 62, 48, 78));
		set2.add(new GradeVO("1911053", "황보영", 82, 68, 90));


		//비교할 기준이 있어야 함....
		Iterator<GradeVO> it2 = set2.iterator();

		while (it2.hasNext())
		{
			GradeVO vo = it2.next();
			System.out.printf("%7s %7s %4d %4d %4d %6d\n", vo.getHak(), vo.getName(), vo.getKor(), vo.getEng(), vo.getMat(), vo.getTot());
		}
		System.out.println();


		


		
	}
}