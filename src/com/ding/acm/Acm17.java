package com.ding.acm;

import java.lang.reflect.Array;

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
/**
 * ���������������
ʱ�����ƣ�3000 ms  |  �ڴ����ƣ�65535 KB
�Ѷȣ�4
����
��һ���ַ���������������еĳ���
�磺dabdbf����������о���abdf������Ϊ4
����
��һ��һ������0<n<20,��ʾ��n���ַ���Ҫ����
����n�У�ÿ����һ���ַ��������ַ����ĳ��Ȳ��ᳬ��10000
���
����ַ���������������еĳ���
��������
3
aaa
ababc
abklmncdefg
�������
1
3
7
 * @author daniel
 * @email 576699909@qq.com
 * @time 2016-4-27 ����12:33:47
 */
public class Acm17 {

	private static char arr[] = new char[10001];
	private static int maxlen[] = new int[10001];

	public static void lis() {
 	Array.setInt(maxlen, maxlen.length - 1, 0);
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			maxlen[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					if (maxlen[i] < 1 + maxlen[j]) {
						maxlen[i] = 1 + maxlen[j];
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0, len;
		int n = sc.nextInt();
		while (n-- > 0) {
			max = 0;
			String str = sc.next();
			arr = str.toCharArray();
 			lis();
 			len = arr.length;
			for (int i = 0; i < len; i++) {
				if (max < maxlen[i]) {
					max = maxlen[i];
 				}
			}
			System.out.println(max);
		}
		sc.close();
	}
}
