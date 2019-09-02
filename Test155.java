/*====================================================
���� �÷��� �����ӿ�ũ(Collection Framework) ����
======================================================*/

/*
�� ť(Queue)

   ť(Queue) �� FIFO(Frist In First Out) ������
   ���� �Էµ� �ڷḦ ���� ����ϸ�
   Queue �������̽��� ������ Ŭ������ ť�� ���õ� �پ��� ����� �����Ѵ�.

�� Queue �������̽� �ν��Ͻ��� �����ϱ� ���ؼ���
   new �����ڸ� �̿��Ͽ� Queue �������̽��� ������(implements)
   Ŭ������ �����ڸ� ȣ���Ѵ�.

   ex)Queue ob = new LinkedList();

�� �ֿ� �޼ҵ�

   - E elemnet()
     ť�� head ��Ҹ� ��ȯ�ϸ� �������� �ʴ´�.

   - boolean offer(E o)
     ������ ��Ҹ� ť�� �����Ѵ�.

   - E peek()
     ť�� ����Ҹ� ��ȯ�ϰ� �������� ������,
	 ť �ڷᱸ���� empty�� ��� null�� ��ȯ�Ѵ�.

   - E poll()
     ť�� head ��Ҹ� ��ȯ�ϰ� �����ϸ�
	 ť �ڷᱸ���� empty�� ��� null�� ��ȯ�Ѵ�.

   - E remove()
     ť�� head��Ҹ� ��ȯ�ϰ� �����Ѵ�.


*/

import java.util.Queue;
import java.util.LinkedList;

public class Test155
{
	public static void main(String[] args)
	{
		//Queue �ڷᱸ�� ����
		//Queue myQue = new Queue();  //x

		Queue<Object> myQue = new LinkedList<Object>();

		//������ �غ�
		String str1 = "��â��";
		String str2 = "������";
		String str3 = "����ȣ";
		String str4 = "������";

		//myQue ��� Queue �ڷᱸ���� ������ �߰�
		//offer()
		myQue.offer(str1);
		myQue.offer(str2);
		myQue.offer(str3);
		myQue.offer(str4);

		//ť �ڷᱸ������ ��Ҹ� �������� �ʰ� head��� ��ȯ
		System.out.println("��1 : " + (String)myQue.element());
		System.out.println("��2 : " + (String)myQue.element());
		//--==>> ��1 : ��â��
		//		 ��2 : ��â��

		System.out.println();   //����

		String val;

		// 1
		// ť�� head ��� ��ȯ. ���� ����.
		// ť�� empty �� ��� null ��ȯ.
		// peek()
		/*
		while(myQue.peek() != null)
		{
			//ť�� head��� ��ȯ. ������.
			//ť�� empty�� ��� null ��ȯ

			val = (String)myQue.poll();
			System.out.println("��� : " + val);
		}
		*/
		//--==>>
		/*
		��� : ��â��
		��� : ������	
		��� : ����ȣ
		��� : ������
		*/

		//�׽�Ʈ
		/*
		while(myQue.poll() != null)
		{
			//ť�� head��� ��ȯ. ������.
			//ť�� empty�� ��� null ��ȯ

			val = (String)myQue.poll();
			System.out.println("��� : " + val);
		}
		*/
		//--==>> ��� : ������
		//		 ��� : ������

		// 2
		/*
		while (true)
		{
			val = (String)myQue.poll();

			if(val==null)
				break;
			else
				System.out.println("�� : " + val);	

		}
		*/
		//--==>>
		/*
		�� : ��â��
		�� : ������
		�� : ����ȣ
		�� : ������
		*/

		// 3

		while(!myQue.isEmpty())
		{
			val = (String)myQue.poll();
			System.out.println("�� : " + val);
		}
		//--==>>
		/*
		�� : ��â��
		�� : ������
		�� : ����ȣ
		�� : ������
		*/






	}
}