package com.ding.acm;
 
import java.util.Scanner;

/**
����
С����һ���������ס�ˣ�������Ҫ����æ�������ǣ�����������������������ǵ����Լ������С��������
����
��һ������һ������n��0<n<=10000)����ʾ��n���������;
����n��������������i,j��0<i,j<=32767)��
���
���ÿ��������ݵ����Լ������С������
��������
3
6 6
12 11
33 22
�������
6 6
1 132
11 66


����������a,b���Լ����p,��С��������q
��ô�������Ĺ�ϵ:ab=pq
����q=ab/p

 * @author daniel
 * @email 576699909@qq.com
 * @time 2016-4-15 ����11:43:12
 */
public class Acm40 {
	public static void main(String[] atg) throws Exception {
		Scanner s = new Scanner(System.in);
		int i = s.nextInt();
 		int n = 0;
		int row[] = new int[i];
		int col[] = new int[i];
		while (n < i) {
			int one = s.nextInt();
			int two = s.nextInt();
			row[n] = one;
			col[n] = two;
			n++;
			int maxGongYue=gongYueShu(one,two);
			//a*b=p*q
			System.out.println(maxGongYue + " " + (one * two) / maxGongYue);
		}
		s.close();


	}
	/**
	 ����������a,b���Լ����p,��С��������q
��ô�������Ĺ�ϵ:ab=pq
����q=ab/p
	 */
	private static int gongYueShu(int i ,int j){
		int t;
		while(i%j!=0){
			t=i%j;
			i=j;
			j=t;
		}	
		return j;
	}
	
	 
}
