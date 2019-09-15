/*====================================================
���� �÷��� �����ӿ�ũ(Collection Framework) ����
======================================================*/

// Set -> HashSet, TreeSet
// - ���� ����
// - �ߺ� ������� �ʴ� ����(�⺻)
 
/*
�� TreeSet<E> Ŭ����

   java.util.TreeSet<E> Ŭ������
   Set �������̽��� ����� SortedSet �������̽��� ������ Ŭ������
   �����͸� �߰��ϸ� �����͵��� �ڵ����� �������� ������ �ȴ�.

*/

import java.util.TreeSet;
import java.util.Iterator;
import java.util.Comparator;

//VO  -> Value Object
//DTO -> Data Transfer Object
//DAO -> Data Access Object

class GradeVO
{
	//�ֿ� �Ӽ� ����
	private String hak;        //-- �й�
	private String name;       //-- �̸�
	private int kor, eng, mat; //-- ��������, ��������, ��������

	//������(����� ���� ������ -> 5���� �Ű������� ���� ������)
	GradeVO(String hak, String name, int kor, int eng, int mat)
	{
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	//������(����� ���� ������ -> �Ű����� ���� ������)
	GradeVO()
	{

	}

	//getter / setter ����
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

	//�߰� �޼ҵ� ����(����)
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

		//���� ����
		//return s1.getTot() - s2.getTot();  
		//return s2.getTot() - s1.getTot(); 

		//�̸� ����
		//return s1.getName().compareTo(s2.getName());
		return s2.getName().compareTo(s1.getName());
	}
}

public class Test169
{
	public static void main(String[] args)
	{
		//TreeSet �ڷᱸ�� �ν��Ͻ� ����
		TreeSet<String> set = new TreeSet<String>();

		//TreeSet �ڷᱸ�� set�� ��� �߰� -> add()
		set.add("���ǽ�");
		set.add("���ϸ���");
		set.add("�ܿ�ձ�");
		set.add("�������");
		set.add("���ݸ�");
		set.add("���̿�ŷ");
		set.add("¯���� ������");
		set.add("�˶��");
		set.add("��Ǭ��");
		set.add("���Ϸ���");
		set.add("������");
		set.add("��Ž���ڳ�");


		//Iterator�� Ȱ���� set ��� ��ü ���
		Iterator<String> it = set.iterator();

		while(it.hasNext())
			System.out.print(it.next()+ " ");
		System.out.println();
		//--==>> �ܿ�ձ� ������ ���̿�ŷ ��Ǭ�� ��Ž���ڳ� ���Ϸ��� �˶�� ���ݸ� ���ǽ� ¯���� ������ ������� ���ϸ���

		//TreeSet �ڷᱸ�� �ν��Ͻ� ����
		//TreeSet<GradeVO> set2 = new TreeSet<GradeVO>();

		//TreeSet �ڷᱸ�� �ν��Ͻ� �ٽ� ����
		TreeSet<GradeVO> set2 = new TreeSet<GradeVO>(new MyComparator<GradeVO>());
		

		set2.add(new GradeVO("1911013", "������", 50, 60, 70));
		set2.add(new GradeVO("1911025", "������", 91, 83, 76));
		set2.add(new GradeVO("1911032", "��â��", 58, 36, 81));
		set2.add(new GradeVO("1911049", "������", 62, 48, 78));
		set2.add(new GradeVO("1911053", "Ȳ����", 82, 68, 90));


		//���� ������ �־�� ��....
		Iterator<GradeVO> it2 = set2.iterator();

		while (it2.hasNext())
		{
			GradeVO vo = it2.next();
			System.out.printf("%7s %7s %4d %4d %4d %6d\n", vo.getHak(), vo.getName(), vo.getKor(), vo.getEng(), vo.getMat(), vo.getTot());
		}
		System.out.println();


		


		
	}
}