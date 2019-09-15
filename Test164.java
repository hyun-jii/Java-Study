/*====================================================
���� �÷��� �����ӿ�ũ(Collection Framework) ����
======================================================*/

// List -> Vector, ArrayList
// - ���� ����
// - �迭�� ����
// - �ߺ� ���

/*
�� ArrayList Ŭ����

   - ArrayList �� Vector Ŭ������
     List �� ũ�� ������ ������ �迭�� ������ ������
	 �������� Vector Ŭ������ ��ü�� �⺻������ ����ȭ ������,
	 ArrayList �� �׷��� �ʴٴ� ���̴�.

   - �񵿱�ȭ �÷����� ����ȭ�� �÷��Ǻ��� �� ���� ������ �����ϸ�
     ��������� �÷����� �������� �ʴ� ���α׷�������
	 �Ϲ������� ArrayList�� Vector���� �� ��ȣ�ϸ�,
	 ArrayList �� ����ȭ�� �������� ���� Vector ó�� ���������ν�
	 ������ ����ȭ�� ���� �δ��� ������ �ʱ� ������
	 Vector���� �� ������ ����ȴ�.

   - null �� ������ ��� ��Ҹ� ����ϸ�
     List �������̽��� �����ϴ� �� �ܿ� ����Ʈ�� �ݳ��ϱ� ����
	 ���������� ���Ǵ� �迭�� ����� �����ϴ� �޼ҵ带 �����Ѵ�.
*/
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Test164
{
	public static void main(String[] args)
	{
		// ArrayList �ڷᱸ�� �ν��Ͻ� ����
		//ArrayList<String> list = new ArrayList<String>();
		//Vector<String> list = new Vector<String>();
		//List<String> list = new Vector<String>();
		List<String> list1 = new ArrayList<String>();

		//list1 �� ��� �߰� -> add()
		list1.add("����������");
		list1.add("�˶��");
		list1.add("���̽��丮");

		// ArrayList �ڷᱸ�� �ν��Ͻ� ����
		List<String> list2 = new ArrayList<String>(list1);

		//list2�� ��� �߰�
		list2.add("����Ʈ");
		
		//ArrayList �ڷᱸ�� �ν��Ͻ� ����
		List<String> list3 = new ArrayList<String>();

		//list3�� list2�� ��ü ��� �߰� -> addAll()
		list3.addAll(list2);


		//"�˶��" �տ�  "�ܿ�ձ�" �߰�
		//-- 1 "�˶��" ã�� -> indexOf() -> ��ġ�� �ε��� ��ȯ
		int n = list3.indexOf("�˶��");

		//�׽�Ʈ
		//System.out.println(n);   //--==>> 1

		//-- 2 "�˶��" ã�� �ε��� ��ġ�� "�ܿ�ձ�" ����(����)
		list3.add(n, "�ܿ�ձ�");


		// ��� -> ���� ������ Ȯ��
		System.out.println("=============================");
		System.out.println(list1);
		//--==>> [����������, �˶��, ���̽��丮]
		System.out.println(list2);
		//--==>> [����������, �˶��, ���̽��丮]
		System.out.println(list3);
		//--==>> [����������, �ܿ�ձ�, �˶��, ���̽��丮, ����Ʈ]


		System.out.println();

		//��� -> listIterator() �޼ҵ带 Ȱ���Ͽ� ���
		System.out.println("============================");
		ListIterator<String> li = list3.listIterator();
		
		while (li.hasNext())
			System.out.print(li.next() + " " );
		System.out.println("\n");
		//--==>> ���������� �ܿ�ձ� �˶�� ���̽��丮 ����Ʈ

		//��� -> �������� ���
		System.out.println("==============================");
		while (li.hasPrevious())	
			System.out.print(li.previous() + " ");}
		System.out.println();
		//--==>> ����Ʈ ���̽��丮 �˶�� �ܿ�ձ� ����������


	}
}