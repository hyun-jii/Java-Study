/*===============================================
	 ���� �ڹ��� �ֿ�(�߿�) Ŭ���� ����
	 - Calendar Ŭ����
=================================================*/

//�ǽ�����
//������ �������� �Է¹޴� ��¥��ŭ ���� ��, ��, ��, ������
//Ȯ���Ͽ� ����� ����ϴ� ���α׷��� �����Ѵ�.

//���� ��)
//���� ��¥ : 2019-8-22 �����
//�� �� ���� ��¥�� Ȯ���ϰ��� �Ͻʴϱ�? : 200 

//============[Ȯ�� ���]=================
//200�� �� : 2020-xx-xx x����
//========================================
//����Ϸ��� �ƹ� Ű�� ��������...

// �� ���� ��¥�� �������� �� ���� ���ϴ� ���� �޼ҵ�
//    ��ü.add(Calendar.DATE, �� ��);

import java.util.Calendar;
import java.util.Scanner;

public class Test143
{
	public static void main(String[] args)
	{

		//Scanner Ŭ���� ��� �ν��Ͻ� ����
		Scanner sc = new Scanner(System.in);

		//Calendar Ŭ���� ��� �ν��Ͻ� ����
		Calendar now = Calendar.getInstance();

		//�ֿ� ���� ����
		int nalsu;        //-- ����ڷκ��� �Է¹��� �� ��
		int y,m,d,w;      //-- ��, ��, ��, ����
		String[] week = {"��","��","ȭ","��","��","��","��"};

		//������ ��,��,��,���� Ȯ��(�������� : get())
		y = now.get(Calendar.YEAR);
		m = now.get(Calendar.MONTH)+1;
		d = now.get(Calendar.DATE);
		w = now.get(Calendar.DAY_OF_WEEK);

		//������ ��,��,��,���� Ȯ�ΰ�� ���
		System.out.println("���� ��¥ : " + y + "-" + m + "-" + d
			+ " " + week[w-1] + "����");

		do
		{
			System.out.print("�� �� ���� ��¥��  Ȯ���ϰ��� �Ͻʴϱ�? : ");
			nalsu = sc.nextInt();
		}
		while (nalsu < 1);

		// check~!!!
		now.add(Calendar.DATE, nalsu);

		//������
		System.out.println();
		System.out.println("===================[Ȯ�� ���]====================");
		System.out.printf("%d �� �� : %tF %tA\n" , nalsu, now, now);
		System.out.println("==================================================");

		
		/*--------------------------------------���� �� Ǯ��------------------------------------
		Scanner sc = new Scanner(System.in);

		//Ķ���� Ŭ���� ����� �ν��Ͻ� ����
		Calendar cal = Calendar.getInstance();

		int d;            //����ڿ��� �Է¹��� ���� ���� ��¥

		int week = cal.get(Calendar.DAY_OF_WEEK);

		String w="";
		
		switch(week)
		{
			case Calendar.SUNDAY: w="�Ͽ���"; break;
			case Calendar.MONDAY: w="������"; break;
			case Calendar.TUESDAY: w="ȭ����"; break;
			case Calendar.WEDNESDAY: w="������"; break;
			case Calendar.THURSDAY: w="�����"; break;
			case Calendar.FRIDAY: w="�ݿ���"; break;
			case Calendar.SATURDAY: w="�����"; break;
		}

		//���� ��¥ ���
		System.out.println(cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DATE) + " " +  w);

		System.out.print("�� �� ���� ��¥�� Ȯ���ϰ��� �Ͻʴϱ�? : ");
		d = sc.nextInt();

		cal.add(Calendar.DATE, d);

        week = cal.get(Calendar.DAY_OF_WEEK);

		switch(week)
		{
			case Calendar.SUNDAY: w="�Ͽ���"; break;
			case Calendar.MONDAY: w="������"; break;
			case Calendar.TUESDAY: w="ȭ����"; break;
			case Calendar.WEDNESDAY: w="������"; break;
			case Calendar.THURSDAY: w="�����"; break;
			case Calendar.FRIDAY: w="�ݿ���"; break;
			case Calendar.SATURDAY: w="�����"; break;
		}

		
		//System.out.println(cal.get(Calendar.DATE));
		
		System.out.println(cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DATE) + " " +  w);

		--------------------------------------------------------------------------------------------------*/



	}
}