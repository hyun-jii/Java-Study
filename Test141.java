/*===============================================
	 ���� �ڹ��� �ֿ�(�߿�) Ŭ���� ����
	 - Calendar Ŭ����
=================================================*/

/*
�� Calendar Ŭ������ �߻� Ŭ���� �̱� ������ ��ü�� ������ �� ����.
   (�߻� Ŭ���� : �̿ϼ��� Ŭ����)

   Calendar ob = new Calendar();   -> �̿� ���� ������ ���� �ν��Ͻ� ���� �Ұ�.

�� Calendar Ŭ���� ��ü(�ν��Ͻ�)�� ������ �� �ִ� ���

   1. Calendar ob1 = Calendar.getInstance();

   2. Calendar ob2 = new GregorianCalendar();

   3. GregorianCalendar ob3 = new GregorianCalendar();
   
   (�� GregorianCalendar : Calendar Ŭ������ ���� Ŭ����)
*/

// ��, ��, ��, ������ Calendar Ŭ�����κ��� �����ͼ� ���
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test141
{
	public static void main(String[] args)
	{
		//Calendar Ŭ���� ��� �ν��Ͻ� ����
		Calendar rightNow = Calendar.getInstance();

		//������ �޷�(Calendar) �ν��Ͻ��� ����
		//��¥ ���� ������ �� �� �ִ� �޼ҵ� -> get()
		int y = rightNow.get(Calendar.YEAR);
		System.out.println(y);
		//--==>> 2019

		int m = rightNow.get(Calendar.MONTH) + 1; // +1 check~!!!
		System.out.println(m);
		//--==>> 8

		int d = rightNow.get(Calendar.DATE);
		System.out.println(d);
		//--==>> 22

		int w = rightNow.get(Calendar.DAY_OF_WEEK);
		System.out.println(w);
		//--==>> 5

		System.out.println(y + "-" + m + "-" + d + "-" + w);
		//--==>> 2019-8-22-5

		//�׽�Ʈ
		System.out.println(Calendar.SUNDAY);     //--==>> 1 -> �Ͽ���
		System.out.println(Calendar.MONDAY);     //--==>> 2 -> ������
		System.out.println(Calendar.TUESDAY);    //--==>> 3 -> ȭ����
		System.out.println(Calendar.WEDNESDAY);  //--==>> 4 -> ������
		System.out.println(Calendar.THURSDAY);   //--==>> 5 -> �����
		System.out.println(Calendar.FRIDAY);     //--==>> 6 -> �ݿ���
		System.out.println(Calendar.SATURDAY);   //--==>> 7 -> �����
		

		String week = "";
		switch(w)
		{
			case Calendar.SUNDAY: week = "�Ͽ���"; break;
			//case 2: week = "������"; break;
			case Calendar.MONDAY: week = "������"; break;
			//case 3: week = "ȭ����"; break;
			case Calendar.TUESDAY: week = "ȭ����"; break;
			//case 4: week = "������"; break;
			case Calendar.WEDNESDAY: week = "������"; break;
			//case 5: week = "�����"; break;
			case Calendar.THURSDAY: week = "�����"; break;
			//case 6: week = "�ݿ���"; break;
			case Calendar.FRIDAY: week = "�ݿ���"; break;
			//case 7: week = "�����"; break;
			case Calendar.SATURDAY: week = "�����"; break;
		}
		System.out.println(y + "-" + m + "-" + d + " " + week);
		//--==>> 2019-8-22 �����


		///////////////////////////////////////////////////////////////////////

		//Calendar Ŭ���� �ν��Ͻ� ����
		Calendar rightNow2 = new GregorianCalendar();

		String[] week2 = {"�Ͽ���", "������", "ȭ����", "������", "�����", "�ݿ���", "�����"};

		//�޷��� ��¥ ���� -> set() �޼ҵ� Ȱ��
		rightNow2.set(2019,7,22); // 8�� -- check~!!!
		
		System.out.println(rightNow2.get(Calendar.DAY_OF_WEEK));
		//--==>> 5 -> �����

		System.out.println(week2[rightNow2.get(Calendar.DAY_OF_WEEK)-1]);
		//--==>> �����

		//�޷��� ��¥ ����
		rightNow2.set(1995,11,21);    
		System.out.println(week2[rightNow2.get(Calendar.DAY_OF_WEEK)-1]);
		//--==>> �����


	}
}