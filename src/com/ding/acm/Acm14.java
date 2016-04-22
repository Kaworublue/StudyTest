package com.ding.acm;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 �᳡��������
ʱ�����ƣ�3000 ms  |  �ڴ����ƣ�65535 KB
�Ѷȣ�4
����
ѧУ��С����ÿ�춼�����������ʱ����Щ��ļƻ�ʱ��ᷢ����ͻ����Ҫѡ���һЩ����оٰ졣С���Ĺ������ǰ���ѧУС���õĻ��ÿ��ʱ����ల��һ���������С����һЩ��ƻ���ʱ������뾡���ܵİ��Ÿ���Ļ������������ΰ��š�
����
��һ����һ��������m(m<100)��ʾ����m��������ݡ�
ÿ��������ݵĵ�һ����һ������n(1<n<10000)��ʾ�ò������ݹ���n�����
����n�У�ÿ��������������Bi,Ei(0<=Bi,Ei<10000),�ֱ��ʾ��i�������ʼ�����ʱ�䣨Bi<=Ei)
���
����ÿһ�����룬�������ܹ����ŵĻ������
ÿ������ռһ��
��������
2
2
1 10
10 11
3
1 10
10 11
11 20
�������
1
2
��ʾ
ע�⣺�����һ�����tʱ���������һ�������Ӧ����t+1ʱ�俪ʼ
 * @author daniel
 * @email 576699909@qq.com
 * @time 2016-4-22 ����4:47:50
 */
public class Acm14 {

	/**
	 * @author daniel
	 * @time 2016-4-22 ����3:49:51
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner input = new java.util.Scanner(System.in);
		int count = input.nextInt();

		List<ActiveTime> list = new ArrayList<ActiveTime>();
		for (int i = 0; i < count; i++) {

			int activeCount = input.nextInt();
			for (int j = 0; j < activeCount; j++) {
				ActiveTime obj = new ActiveTime();
				obj.setBegin(input.nextInt());
				obj.setEnd(input.nextInt());
				list.add(obj);
			}
            //���ջ����ʱ������
			Collections.sort(list);
			int current = -1;
			int activeSum = 0;
			for (ActiveTime obj : list) {

				//��������Ļ�Ŀ�ʼʱ��
				if (obj.getBegin() > current) {
					activeSum++;
					//����ʱ�丳ֵ����ǰʱ��
					current = obj.getEnd();
				}
			}
			System.out.println("��������:" + activeSum);

		}

	}
}

/**
 * ����ʱ��
 * 
 * @author daniel
 * @email 576699909@qq.com
 * @time 2016-4-22 ����3:56:28
 */
class ActiveTime implements Comparable<ActiveTime> {
	private int begin;
	private int end;

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	/**
	 * ���ս���ʱ���С��������
	 */
	@Override
	public int compareTo(ActiveTime o) {

		return this.end - o.end;
	}

}
