package com.ding.acm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * ����
���������ַ��������ظ����󣬰����ַ���ASCII���С�����˳������������ַ���
����
��һ������һ����N,��ʾ��N��������ݡ������N������������ݣ�ÿ���������ݶ���ռһ�У��������ַ���ɣ�֮���޿ո�
���
����ÿ���������ݣ����һ�У��ַ��м���һ���ո�ֿ���
��������
2
qwe
asd
�������
e q w
a d s
 * @author daniel
 * @email 576699909@qq.com
 * @time 2016-4-13 ����3:47:42
 */
public class Acm4 { 
	/**
	 * @author daniel
	 * @time 2016-4-13 ����3:16:33
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("��������Դ�����");
		String count = strin.readLine();
		int c = Integer.parseInt(count);
		while (c-- > 0) {
			System.out.print("�������ַ�����");
			String str = strin.readLine();
			System.out.println("���������:" + str + ";�����:" + sort(str));
		} 
	} 
	/**
	 * ����
	 * 
	 * @author daniel
	 * @time 2016-4-13 ����3:20:44
	 * @param str
	 */
	public static String sort(String str) {
		char[] ch = new char[str.length()];
		char temp;
		for (int i = 0; i < str.length(); i++) {
			ch[i] = str.charAt(i);
		}
		//ð��
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < str.length() - 1; j++) {
				if (ch[j] > ch[j + 1]) {
					temp = ch[j];
					ch[j] = ch[j + 1];
					ch[j + 1] = temp;
				}
			}
		} 
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<ch.length;i++){
			sb.append(ch[i]);
			sb.append(" ");
		}		
		return sb.toString();
	}
}
