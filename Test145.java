/*===============================================
	 ���� �ڹ��� �ֿ�(�߿�) Ŭ���� ����
	 - Random Ŭ����
=================================================*/

/*
�� java.util.Random Ŭ������
  
   ���� ������ ������ �߻����� �����ϴ� Ŭ�����̴�.
   Math Ŭ������ ���� �޼ҵ��� random()�޼ҵ嵵 ������ �����ϴ� �޼ҵ� ������
   0.0 ~ 1.0 ������ �Ǽ� ���¸� �߻��ϰ� �ǹǷ�
   �ʿ��� ���� ������ ������ ������ ���ؼ��� �߰����� ������� �����ؾ� �Ѵ�.
   �׷��� �ڹٴ� ���� ������ ������ �߻������ִ�
   ���� Ŭ������ Random Ŭ������ ������ �����ϰ� �ִ�.
*/

//�ζ� ��ȣ ������(���� �߻� ���α׷�)

//���α׷��� ����Ǹ� �⺻������ �ζǸ� 5���� �����ϴ� ���α׷��� �����Ѵ�.

//���� ��)
// 3 5 12 24 31 41
// 1 2 8 23 36 38
// 4 9 11 13 22 30
// 5 10 12 15 27 40
// 22 31 32 33 40 45
//����Ϸ��� �ƹ� Ű�� ��������...

import java.util.Random;
import java.util.Arrays;

class Lotto
{
	//�迭 ���� ���� �� �޸� �Ҵ� -> �ζ� ��ȣ�� ��Ƶ� �迭�� 6��
	private int[] num = new int[6];

	//getter
	public int[] getNum()
	{
		return num;
	}

	//6���� ������ �߻���Ű�� �޼ҵ� ����
	public void start()
	{

		int cnt = 0;
		Random rd = new Random();
		int n;

		jump:

		while (cnt<6)                // 0	1	2
		{		
			n = rd.nextInt(45)+1;    // 10  7	10
			for (int i=0; i<cnt; i++)
			{
				if (num[i]==n)
					continue jump;
			}
			num[cnt++] = n;         // num[0] = 10;
			                        // num[1] = 7;
		}

		//���� �޼ҵ� ȣ��
		sorting();
		/*---------------------------------���� �Ѱ�----------------------------
		Random rd = new Random();
		int temp;

		for(int i=0; i<num.length; i++)
		{
			num[i] = rd.nextInt(45)+1;

			for(int j=i; j<num.length; j++)
			{
				if(num[i] == num[j])
				{
					i--;
					num[i] = rd.nextInt(45)+1;
				}
			}


		}


		for(int i=0; i<num.length-1; i++)
		{
			for(int j=i+1; j<num.length; j++)
			{

				if(num[i] > num[j])
				{
					temp=num[i];
					num[i]=num[j];
					num[j]=temp;
				}
			}
		}

		-------------------------------------------------------------*/

	}

	//���� �޼ҵ�
	public void sorting()
	{
		Arrays.sort(num);
	}
}

public class Test145
{
	public static void main(String[] args)
	{
		//Lotto Ŭ���� ��� �ν��Ͻ� ����
		Lotto lotto = new Lotto();

		//�⺻ 5����
		for(int i=1; i<=5; i++)
		{
			lotto.start();

			//��� ���
			for(int n : lotto.getNum())
			{
				System.out.printf("%4d", n);
			}
			System.out.println();
		}
	}
}