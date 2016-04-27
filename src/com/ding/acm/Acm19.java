package com.ding.acm;
import java.util.Scanner;
/**
 �ó����е�С��
ʱ�����ƣ�1000 ms  |  �ڴ����ƣ�65535 KB
�Ѷȣ�4
����
С��ʮ�ִ���������ʮ���ó����м��㡣�����С��һ������5���������̸���1-5���ֵ����ȫ���У��������Ϊ����������5��������ѡ������������������ȫ���У���ô��ʹ��ˣ���ͬ���ĺ��ó���������Ҫ��дһ����������֤�ó����е�С�����׶Բ��ԡ�
����
��һ����������N��1<N<10����ʾ������������ݣ�
ÿ��������ݵ�һ���������� n m (1<n<9,0<m<=n)
���
��1-n��ѡȡm���ַ�����ȫ���У����ֵ���ȫ�����,ÿ������ռһ�У�ÿ�����ݼ䲻��ֽ硣������
��������
2
3 1
4 2
�������
1
2
3
12
13
14
21
23
24
31
32
34
41
42
43
 * @author daniel
 * @email 576699909@qq.com
 * @time 2016-4-27 ����12:32:37
 */
public class Acm19 {
	public static int[][] prev(int n, int m) {
		if (m == 1) {
			int a[][] = new int[n][1];
			for (int i = 0; i < n; i++) {
				a[i][0] = i + 1;
			}
			return a;
		} else {
			int a[][] = prev(n, m - 1);
			int b[][] = new int[a.length * (n - m + 1)][m];
			for (int i = 0; i < a.length * (n - m + 1); i++) {
				for (int j = 0; j < m - 1; j++) {
					b[i][j] = a[i / (n - m + 1)][j];
				}
				int c[] = new int[n];
				int k = 0;
				for (int j = 0; j < n; j++) {
					boolean flag = true;
					for (int l = 0; l < m - 1; l++) {
						if (b[i][l] == j + 1) {
							flag = false;
							break;
						}
					}
					if (flag) {
						c[k] = j + 1;
						k++;
					}
				}
				b[i][m - 1] = c[i % (n - m + 1)];
			}
			return b;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
 		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int a[][] = prev(n, m);
			for (int j = 0; j < a.length; j++) {
				for (int k = 0; k < a[0].length; k++) {
					System.out.print(a[j][k]);
				}
				System.out.println();
			}
		}
	}


}
