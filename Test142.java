/*===============================================
	 ���� �ڹ��� �ֿ�(�߿�) Ŭ���� ����
	 - Calendar Ŭ����
=================================================*/

/*
�� java.util.Calendar Ŭ������
   ��¥�� �ð��� ��ü �𵨸�ȭ �� Ŭ������
   ��, ��, ��, ����, ��, ��, �ʱ�����
   �ð��� ��¥�� ���õ� ������ �����Ѵ�.
   �׸���, Calendar Ŭ������ �߻�Ŭ�����̹Ƿ� ���� ��ü�� ������ �� ������
   �������� �޼ҵ� ������ Calendar Ŭ������ ���� Ŭ������
   GregorianCalendar Ŭ������ ���ǵǾ� �ִ�.

   �ý������κ��� ���� �ý��� �ð� ������ ���� ��
   getInstance() ��� ����(static) �޼ҵ带 �̿��Ͽ� ��ü�� ������ �� �ִ�.
   ������ Calendar Ŭ���� ��ü�� �ý����� ���� ��¥�� �ð� ������ ������,
   �� ��ü�� �����Ǹ� �����ִ� �ð� ��������
   get() �޼ҵ带 �̿��Ͽ� ���� ������(�����) �� �ִ�.

   getInstance() �޼ҵ�� ���������� GregorianCalendar ��ü�� �����Ͽ�
   �����ֱ� ������ GregorianCalendar ��ü�� ���� �����Ͽ� �ð� ������
   ���� ���� �ִ�.
*/

//�� �ǽ� ����
// ����ڷκ��� ��,���� �Է¹޾�
// �޷��� �׷��ִ�(����ϴ�) ���α׷��� �����Ѵ�.
// ��, ����޷��� �ƴ϶� CalendarŬ������ Ȱ���Ͽ� �ۼ��� �� �ֵ��� �Ѵ�.

//���� ��)
//���� �Է� : 0
//���� �Է� : 2019
//�� �Է� : -2
//�� �Է� : 16
//�� �Է� : 8
/*

				[ 2019��8�� ]

		  ��  ��  ȭ  ��  ��  ��  ��
		=============================
						   1   2   3
		   4   5   6   7   8   9  10
		  11  12  13  14  15  16  17
		  18  19  20  21  22  23  24
		  25  26  27  28  29  30  31
		=============================
		����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/
import java.util.Scanner;
import java.util.Calendar;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test142
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Calendar cal = Calendar.getInstance();

		int y,m;
		int w;
		int i;

		do
		{
			System.out.print("���� �Է� : " );
			y = Integer.parseInt(br.readLine());
		}
		while (y<1);

		do
		{
			System.out.print("�� �Է� : ");
			m = Integer.parseInt(br.readLine());
		}
		while (m<1 || m>12);

		//����ڷκ��� �Է¹��� ��(y), ��(m)�� �̿��Ͽ�
		//�޷��� ��¥ ����
		cal.set(y, m-1, 1);
		//-- �� ���� �� �Է°�(m)�� �״�� ����ϴ� ���� �ƴ϶�
		//   �Է°����� 1�� �� ������ ���� �����ؾ� �Ѵ�.
		//-- �� ���� �� �Է¹��� ��, ���� �ش��ϴ� 1�Ϸ� �����ؾ� �Ѵ�.

		//���� ��������
		w = cal.get(Calendar.DAY_OF_WEEK);

		//�׽�Ʈ
		//System.out.println(w);
		
		//��� ��� -> �޷� �׸���
		System.out.println();
		System.out.println("\t[" + y + "��" + m + "��]\n");
		System.out.println("  ��  ��  ȭ  ��  ��  ��  ��");
		System.out.println("============================");
		for (i=1; i<w; i++)
		{
			System.out.printf("    ");
		}

		// Calendar Ŭ������ getActualMaximum() �޼ҵ� check~!!!
		for (i=1; i<=cal.getActualMaximum(Calendar.DATE); i++)
		{
			System.out.printf("%4d", i);

			w++;        //-- �ݺ����� �����ϸ� ��¥�� ������ ������
		                //   ���ϵ� �Բ� ������ �� �ֵ��� ó��

			if(w%7==1)
				System.out.println();
		}

		if(w%7 != 1)
			System.out.println();

		System.out.println("=============================");
		/*---------------------------���� �� ��---------------------------------
		Scanner sc = new Scanner(System.in);
		int y, m;              //����ڷκ��� �Է¹��� ��, ��

		//����ڷκ��� ���� �Է¹ޱ�
		do
		{
			System.out.print("���� �Է� :");
			y = sc.nextInt();
		
		}
		while (y < 1);

		//����ڷκ��� �� �Է¹ޱ�
		do
		{
			System.out.print("�� �Է� : ");
			m = sc.nextInt();
		}
		while (m <1 || m >12);

		//Calendar Ŭ���� ��� �ν��Ͻ� ����
		Calendar cal = Calendar.getInstance();

		//�޷��� ��¥ ����
		cal.set(y,m-1,1);

		int lastday = cal.getActualMaximum(Calendar.DATE);

		//�׽�Ʈ
		//System.out.println(lastday);
		System.out.printf("[ %d�� %d�� ]\n", y, m);

		System.out.println("  ��  ��  ȭ  ��  ��  ��  ��");
		System.out.println("=============================");

	    int w = cal.get(Calendar.DAY_OF_WEEK);

		//�׽�Ʈ
		//System.out.println(w);

		for(int i=1; i<w; i++)
		{
			System.out.print("    ");
		}

		for(int i=1; i<=lastday; i++)
		{
			System.out.printf("%4d" , i);

			if(w%7 == 0)
				System.out.println();

			w++;
		}

		if(w%7 != 0)
			System.out.println();
		

		System.out.println("=============================");
		System.out.println();

		-------------------------------------------------------------*/

	
	}
}
//������
/*
���� �Է� : 2019
�� �Է� : 8

        [2019��8��]

  ��  ��  ȭ  ��  ��  ��  ��
============================
                   1   2   3
   4   5   6   7   8   9  10
  11  12  13  14  15  16  17
  18  19  20  21  22  23  24
  25  26  27  28  29  30  31
=============================
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .


���� �Է� : 2020
�� �Է� : 1

        [2020��1��]

  ��  ��  ȭ  ��  ��  ��  ��
============================
               1   2   3   4
   5   6   7   8   9  10  11
  12  13  14  15  16  17  18
  19  20  21  22  23  24  25
  26  27  28  29  30  31
=============================
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

*/