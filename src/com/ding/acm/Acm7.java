package com.ding.acm;

import java.util.Scanner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * ����
һ�������кܶ�ס���������Ľֵ�ֻ��Ϊ�������ϱ����ַ���

ס��ֻ�������Žֵ����ߡ�

�����ֵ�֮��ļ����ȡ�

��(x,y)����ʾס�����ڵĽ�����

���磨4,20������ʾ�û��ڶ��������4���ֵ����ϱ������20���ֵ���

����Ҫ��һ���ʾ֣�ʹ�ø���ס�����ʾֵľ���֮�����١�

����������ʾ�Ӧ�ý����Ǹ��ط�ʹ������ס������֮����С��

����
��һ��һ������n<20����ʾ��n��������ݣ�������n������;
ÿ���һ��һ������m<20,��ʾ������m��ס���������m��ÿ������������0<x,y<100����ʾĳ���û����ڽ��������ꡣ
m�к�����һ������ݣ�
���
ÿ������������ʾ���С�ľ���ͣ��س�������
��������
2
3
1 1
2 1
1 2
5
2 9 
5 20
11 9
1 1
1 20
�������
2
44





����:
ÿ��ס�������X,Y����ٷ�
1.�����һ�������ֱ�ÿ��ס���ľ��룬Ȼ����ӡ�
2.�������������㵽����ס���ľ��룬������С����
 * @author daniel
 * @email 576699909@qq.com
 * @time 2016-4-14 ����3:56:29
 */
public class Acm7 {

	// ��������ֵ
	private static int maxX = 20;
	// ���������ֵ
	private static int maxY = 100;
	// ��̾���
	private static int minF = 0;

	private static int currentX = 0;
	private static int currentY = 0;

	/**
	 * @author daniel
	 * @time 2016-4-14 ����3:09:34
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("��������Դ�����");
		int n = Integer.parseInt(strin.readLine());

		for (int testCount = 0; testCount < n; testCount++) {
			// ��ʼ����̾���
			minF = 0;
			System.out.print("�����뼸���˼ң�");
			// �����˼�
			int users = Integer.parseInt(strin.readLine());
			Scanner input = new Scanner(System.in);
			int[][] u = new int[users][2];
			for (int user = 0; user < users; user++) {

				int x = input.nextInt();
				int y = input.nextInt();
				u[user][0] = x;
				u[user][1] = y;

			}
			count(u);

		}
	}

	/**
	 * ������̾���
	 * 
	 * @author daniel
	 * @time 2016-4-14 ����3:52:01
	 * @param user
	 */
	public static void count(int[][] user) {

		for (int i = 0; i < maxX; i++) {
			for (int j = 0; j < maxY; j++) {
				//��ǰ�������
				int currentDistance = 0;
				
				//���㵱ǰ�ڵ㵽����ס���ľ����
				for (int k = 0; k < user.length; k++) {
					currentDistance +=  Math.abs(i - user[k][0]) + Math.abs(j - user[k][1]);
				}

				// �״ν�������ʼֵ
				if ((i == 0) && (j == 0)) {
					minF = currentDistance;
				}
				if (currentDistance < minF) {
					currentX = i;
					currentY = j;
					minF = currentDistance;
				}

			}

		}

		System.out.print("��̾��룺" + minF);
		System.out.print("���꣺" + currentX + "��" + currentY);
	}

}
