package com.ding.acm;

import java.util.Scanner;

import java.util.Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 
 * 
 * @author daniel
 * @email 576699909@qq.com
 * @time 2016-4-13 ����6:09:14
 */
public class Acm12 {

	/**
	 * ����
	 */
	private   static double width = 20;
	/**
	 * �߶ȿ��
	 */
	private   static double high = 2;

	/**
	 * @author daniel
	 * @time 2016-4-13 ����5:40:50
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.print("��������Դ�����");
		int n = input.nextInt();

		while (n-- > 0) {
			System.out.print("��������n,w,��");
			// �����м�����ˮװ��
			int num = input.nextInt();

			// ������
			int[][] rArray = new int[num][2];

			width=input.nextInt();
			high=input.nextInt();
			
			
			

			// ����һ���ַ��������һ���ַ�������
			for (int i = 0; i < num; i++) {
				rArray[i][0] =input.nextInt();
				rArray[i][1] =input.nextInt();
			}

			
			
			
			

		}

	}

}
