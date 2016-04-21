package com.ding.acm;

import java.util.Scanner;

/**
 * ���� ��������1��1��2��3��5��8��13��21��34��55...��ΪFibonacci���У������Եݹ�ض���Ϊ F(n)=1
 * ...........(n=1��n=2) F(n)=F(n-1)+F(n-2).....(n>2) ��Ҫ�������n��쳲�������������1�����ڶ�����Ϊ1)
 * ���� ��һ����һ������m(m<5)��ʾ����m��������� ÿ�β�������ֻ��һ�У���ֻ��һ��������n(n<20) ���
 * ��ÿ������n�������n��Fibonacci�� �������� 3 1 3 5 ������� 1 2 5
 * 
 * @author daniel
 * @email 576699909@qq.com
 * @time 2016-4-21 ����11:28:28
 */
public class Acm13 {

	/**
	 * @author daniel
	 * @time 2016-4-21 ����10:34:13
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		int[] sum = new int[n];
		for (int i = 0; i < n; i++) {
			sum[i] = input.nextInt();
		}

		for (int i = 0; i < n; i++) {
			System.out.println(fibB(sum[i]));
			// System.out.println(fib(sum[i]));
		}

	}

	/**
	 * �ݹ�ʵ��
	 * 
	 * @author daniel
	 * @time 2016-4-21 ����11:37:33
	 * @param n
	 * @return
	 */
	public static long fib(int n) {
		if (n <= 1) {
			// System.out.println("if:" + n);
			return n;
		} else {
			// System.out.println("else:" + n);
			return fib(n - 1) + fib(n - 2);
		}
	}

	/**
	 * ѭ��ʵ�� 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610,
	 * 
	 */
	private static long fibB(int n) {
		long a = 0;
		long b = 1;
		long c = 0;
		if (n <= 1) {
			return n;
		}
		for (int i = 1; i < n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}

}
