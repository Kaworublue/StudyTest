package com.ding.acm;
/**
 * Ч�ʱ�x*x*x*x*x��
 * @author daniel
 * @email 576699909@qq.com
 * @time 2016-5-25 ����5:36:13
 */
public class XtoN {

	/**
	 * @author daniel
	 * @time 2016-5-25 ����5:29:59
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(cube(2,4));
	}
/**
 * x��n�η�����
 * @author daniel
 * @time 2016-5-25 ����5:35:33
 * @param x
 * @param n
 * @return
 */
	public static int cube(int x, int n) {
		int returnData = -1;
		if (n == 1) {
			returnData = x;
		} else if (n > 1) {

			int m = n / 2;
			int s = cube(x, m);
			if (n % 2 == 0) {
				returnData = s * s;
			} else {
				returnData = x * s * s;
			}

		}

		return returnData;
	}

}
