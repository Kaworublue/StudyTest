package com.ding.acm;

import java.util.Scanner;

/**
 * ��ż������ ʱ�����ƣ�3000 ms | �ڴ����ƣ�65535 KB �Ѷȣ�1 ���� ��һ������ż��n(2<= n
 * <=10000),��Ҫ�����ǣ��Ȱ�1��n�е�����������С����������ٰ����е�ż����С��������� ���� ��һ����һ������i��2<=i<30)��ʾ�� i
 * ��������ݣ� ÿ����һ������ż��n�� ��� ��һ��������е����� �ڶ���������е�ż�� �������� 2 10 14 ������� 1 3 5 7 9 2 4 6
 * 8 10
 * 
 * 1 3 5 7 9 11 13 2 4 6 8 10 12 14
 * 
 * @author daniel
 * @email 576699909@qq.com
 * @time 2016-4-18 ����2:10:55
 */
public class Acm11 {

	/**
	 * @author daniel
	 * @time 2016-4-18 ����1:49:12
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("��������Դ�����");
		int count = input.nextInt();

		for (int testCount = 0; testCount < count; testCount++) {

			System.out.print("�����뼸�����ݣ�");
			int num = input.nextInt();
			StringBuffer odd = new StringBuffer();
			StringBuffer even = new StringBuffer();
			for (int i = 1; i <= num; i++) {
				if (i % 2 != 0) {
					odd.append(i);
					odd.append(" ");
				} else {
					even.append(i);
					even.append(" ");
				}

			}
			System.out.println(odd.toString() + " \n\n" + even);
		}

	}

}
