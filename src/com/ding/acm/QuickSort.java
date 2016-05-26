package com.ding.acm;

import java.util.Arrays;
/**
 ��ʼ:[4, 6, 8, 3, 5, 2, 1, 7]
 
 
 
 ----------------------- ��4��ʼ�԰��ۿ� ����߱�4С�ұ߱�4��----------------------
---low:0--high:7--key:4
a:[1, 6, 8, 3, 5, 2, 1, 7]
b:[1, 6, 8, 3, 5, 2, 6, 7]
a:[1, 2, 8, 3, 5, 2, 6, 7]
b:[1, 2, 8, 3, 5, 8, 6, 7]
a:[1, 2, 3, 3, 5, 8, 6, 7]
---[1, 2, 3, 4, 5, 8, 6, 7]  

 ----------------------- 4��ߵĽ�������----------------------
---low:0--high:2--key:1
---[1, 2, 3, 4, 5, 8, 6, 7]


---low:1--high:2--key:2
---[1, 2, 3, 4, 5, 8, 6, 7]

 ----------------------- 4�ұߵĽ�������----------------------

---low:4--high:7--key:5
---[1, 2, 3, 4, 5, 8, 6, 7]


---low:5--high:7--key:8
a:[1, 2, 3, 4, 5, 7, 6, 7]
---[1, 2, 3, 4, 5, 7, 6, 8]


---low:5--high:6--key:7
a:[1, 2, 3, 4, 5, 6, 6, 8]
---[1, 2, 3, 4, 5, 6, 7, 8]

 ----------------------- ���----------------------

����:[1, 2, 3, 4, 5, 6, 7, 8]

 * @author daniel
 * @email 576699909@qq.com
 * @time 2016-5-26 ����5:48:21
 */
public class QuickSort {

	/**
	 * @author daniel
	 * @time 2016-5-26 ����4:16:55
	 * @param args
	 */

	@SuppressWarnings("all")
	public static void sort(int[] data, int left, int right) {
		// ��ŦԪ��һ���Ե�һ��Ԫ��Ϊ��׼���л���
		int leftCurrent = left;
		int rightCurrent = right;
		if (left < right) {

			// ���������˽�������м�ɨ��
			int pivotKey = data[left];
			System.out.println("---leftCurrent:" + leftCurrent + "--rightCurrent:" + rightCurrent + "--key:" + pivotKey);
			// leftCurrent��������ɨ�裬rightCurrent��������ɨ��
			while (leftCurrent < rightCurrent) {
				// �ҵ��������ұ߱�keyС��ֵ���±�
				while (leftCurrent < rightCurrent && pivotKey < data[rightCurrent]) {
					rightCurrent--;
				}
				if (leftCurrent < rightCurrent) {
					// ���ұ߱�keyС��ֵ��ǰŲ
					data[leftCurrent] = data[rightCurrent];
					leftCurrent++;
					System.out.println("a:" + Arrays.toString(data));

				}
				// �ҵ���߱�key���ֵ���±�
				while (leftCurrent < rightCurrent && pivotKey > data[leftCurrent]) {
					leftCurrent++;
				}

				if (leftCurrent < rightCurrent) {
					// ����߱�key���ֵ����Ų
					data[rightCurrent] = data[leftCurrent];
					rightCurrent--;
					System.out.println("b:" + Arrays.toString(data));
				}
			}// end while
				// ��ŦԪ���ƶ�����ȷλ��
			data[leftCurrent] = pivotKey;
			System.out.println("---" + Arrays.toString(data) + "\n\n");
			// ǰ����ӱ�ݹ�����
			sort(data, left, leftCurrent - 1);
			// �����ӱ�ݹ�����
			sort(data, leftCurrent + 1, right);
		}// end if
	}// end sort

	public static void main(String[] args) {

		int[] c = { 4, 6, 8, 3, 5, 2, 1, 7 };

		System.out.println("��ʼ:" + Arrays.toString(c)); 
		
		sort(c, 0, c.length - 1);
		System.out.println("����:" + Arrays.toString(c));

	}

}
