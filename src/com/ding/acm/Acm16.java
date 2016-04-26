package com.ding.acm;
import java.util.ArrayList;
import java.util.Collections;
 import java.util.Scanner;
/**
 * 
 * 
 * 
 * ����Ƕ��
ʱ�����ƣ�3000 ms  |  �ڴ����ƣ�65535 KB
�Ѷȣ�4
����
��n�����Σ�ÿ�����ο�����a,b����������ʾ���Ϳ�����X(a,b)����Ƕ���ھ���Y(c,d)�е��ҽ���a<c,b<d����b<c,a<d���൱����תX90�ȣ������磨1,5������Ƕ���ڣ�6,2���ڣ�������Ƕ���ڣ�3,4���С����������ѡ�������ܶ�ľ����ų�һ�У�ʹ�ó����һ���⣬ÿһ�����ζ�����Ƕ������һ�������ڡ�
����
��һ����һ��������N(0<N<10)����ʾ��������������
ÿ��������ݵĵ�һ����һ��������n����ʾ������������к��о��εĸ���(n<=1000)
����n�У�ÿ����������a,b(0<a,b<100)����ʾ���εĳ��Ϳ�
���
ÿ��������ݶ����һ��������ʾ�����������ľ�����Ŀ��ÿ�����ռһ��
��������
1
10
1 2
2 4
5 8
6 10
7 9
3 1
5 8
12 10
9 7
2 2
�������
5
 * @author daniel
 * @email 576699909@qq.com
 * @time 2016-4-25 ����1:46:22
 */
public class Acm16 {

	/**
	 * @author daniel
	 * @time 2016-4-25 ����12:18:52
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int count = input.nextInt();

		for (int testCount = 0; testCount < count; testCount++) {

			int num = input.nextInt();

			ArrayList<Rectangle2> list = new ArrayList<Rectangle2>();
			boolean isSave = true;
			// ��������������
			for (int i = 0; i < num; i++) {
				Rectangle2 obj = new Rectangle2();

				obj.setLength(input.nextInt());
				obj.setWidth(input.nextInt());

				/**
				 * �滻���ߺͿ�
				 */
				if (obj.getWidth() > obj.getLength()) {
					int j = obj.getWidth();
					obj.setWidth(obj.getLength());
					obj.setLength(j);
				}

				isSave = true;
				// �ж��Ƿ����
				for (Rectangle2 o : list) {
					if (o.compareTo(obj) == 0) {
						isSave = false;
					}
				}
				// �����ھͱ���
				if (isSave) {
					list.add(obj);
				}

			}
			// ����
			Collections.sort(list);
			int sum = 0;

			int x = list.size();
			boolean isPlus = true;

			for (int i = 0; i < x;) {
				isPlus = true;
				Rectangle2 one = list.get(i);
				for (int j = 1; j < list.size() - i; j++) {
					Rectangle2 two = list.get(i + j);
					if ((two.getLength() > one.getLength()) && two.getWidth() > one.getWidth()) {
						sum++;
						i = i + j;
						isPlus = false;
						break;

					}

				}

				if (isPlus) {
					i++;
				}

			}

			System.out.println(returnAnsNum(list));

		}

	}

	public static int returnAnsNum(ArrayList<Rectangle2> recList) {
		int[] dp = new int[1001];
		int totalCount = 1;
		for (int i = 0; i < recList.size(); i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (recList.get(j).getWidth() < recList.get(i).getWidth() && recList.get(j).getLength() < recList.get(i).getLength() && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
			if (dp[i] > totalCount) {
				totalCount = dp[i];
			}
		}
		return totalCount;

	}

}

/**
 * ID,�������
 * 
 * @author daniel
 * @email 576699909@qq.com
 * @time 2016-4-15 ����11:47:27
 */
class Rectangle2 implements Comparable<Rectangle2> {

	private int length;
	private int width;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public String toString() {
		// return id + " " + length + " " + width ;
		return "Rectangle [ length=" + length + ", width=" + width + "]";
	}

	@Override
	public int compareTo(Rectangle2 o) {

		// ��������
		if (this.length > o.length) {
			return 1;
		} else if (this.length < o.length) {
			return -1;
		}

		// �������
		if (this.width > o.width) {
			return 1;
		} else if (this.width < o.width) {
			return -1;
		}

		// ��ֵͬ
		if (this.length == o.length && this.width == o.width) {
			return 0;
		}
		return 404;
	}

}
