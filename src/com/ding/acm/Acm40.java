package com.ding.acm;

import java.util.HashSet;

import java.util.Set;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
/**
һ������
ʱ�����ƣ�3000 ms  |  �ڴ����ƣ�65535 KB
�Ѷȣ�3
����
�����кܶ೤���Σ�ÿһ�������ζ���һ����ţ������ſ����ظ�����֪����������εĿ�ͳ�����š�������������������Ҫ����һ�·�ʽ����Ĭ����������Ǵ�С���󣩣�

1.���ձ�Ŵ�С��������

2.���ڱ����ȵĳ����Σ����ճ����εĳ�����

3.�����źͳ�����ͬ�����ճ����εĿ�����

4.�����š���������ͬ����ֻ����һ����������������,ɾ������ĳ����Σ�����ź�����ָ����ʽ��ʾ���еĳ����Σ�
����
��һ����һ������ 0<n<10000,��ʾ��������n��������ݣ�
ÿһ���һ����һ������ 0<m<1000����ʾ��m�������Σ�
��������m�У�ÿһ���������� ����һ������ʾ�����εı�ţ�

�ڶ����͵�������ֵ��ı�ʾ������ֵС�ı�ʾ�����
˵������һ�������Σ�����Լ���������Ŷ�С��10000����
���
˳�����ÿ�����ݵ����з��������ĳ����ε� ��� �� ��
��������
1
8
1 1 1
1 1 1
1 1 2
1 2 1
1 2 2
2 1 1
2 1 2
2 2 1
�������
1 1 1
1 2 1
1 2 2
2 1 1
2 2 1


I.˼·
II.������������� ������
II.�ж��Ƿ��Ѵ��ڣ����������
II.���������ݽ����������

 * @author daniel
 * @email 576699909@qq.com
 * @time 2016-4-15 ����11:43:12
 */
public class Acm40 {

	/**
	 * @author daniel
	 * @time 2016-4-15 ����10:59:34
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		Scanner input = new Scanner(System.in);
		System.out.print("��������Դ�����");
		int count = input.nextInt();
		
		Set set=new HashSet();
		set.add("");

		for (int testCount = 0; testCount < count; testCount++) {

			System.out.print("�����뼸�����ݣ�");
			int num = input.nextInt();

			List<Rectangle> list = new ArrayList<Rectangle>();
			boolean isSave = true;
			// ��������������
			for (int i = 0; i < num; i++) {
				Rectangle obj = new Rectangle();
				obj.setId(input.nextInt());
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
				for (Rectangle o : list) {
					if (o.compareTo(obj) == 0) {
						isSave = false;
					}
				}
				//�����ھͱ���
				if (isSave) {
					list.add(obj);
				}

			}
			// ����
			Collections.sort(list);

			// ������
			for (Rectangle o : list) {
				System.out.println(o);
			}
		}

	}

}

