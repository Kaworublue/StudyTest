package com.ding.acm;

import java.util.Stack;

import java.io.InputStreamReader;

import java.io.BufferedReader;

/**
 * ����
���ڣ���һ���������У����������������Ƿ���ԡ�
����
��һ������һ����N��0<N<=100��,��ʾ��N��������ݡ������N����������������ݣ�ÿ���������ݶ���һ���ַ���S(S�ĳ���С��10000����S���ǿմ���������������������5�顣���ݱ�֤S��ֻ����"[","]","(",")"�����ַ�
���
ÿ���������ݵ����ռһ�У�������ַ�������������������Եģ������Yes,�������������No
��������
3
[(])
(])
([[]()])

 * Stack ���ʾ����ȳ���LIFO���Ķ����ջ����ͨ������������� Vector ��������չ ������������Ϊ��ջ�����ṩ��ͨ���� push �� pop
 * �������Լ�ȡ��ջ����� peek ���������Զ�ջ�Ƿ�Ϊ�յ� empty �������ڶ�ջ�в����ȷ������ջ������� search ������
 * 
 * @author daniel
 * @email 576699909@qq.com
 * @time 2016-4-12 ����6:56:30
 */
public class ACM2 {

	/**
	 * @author daniel
	 * @time 2016-4-12 ����6:30:07
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
 		try {
			BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
			//System.out.print("��������Դ�����");
			String count = strin.readLine();
			int c = Integer.parseInt(count);
			while (c-- > 0) {
				//System.out.print("�������ַ�����");
				String str = strin.readLine();
				check(str);
				//System.out.println("���������:" + str + ";�Ƿ�ƥ��:" + );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
/**
 * ʵ��ϸ��
 * @author daniel
 * @time 2016-4-12 ����6:59:49
 * @param str
 * @return
 */
	public static boolean check(String str) {
		boolean bo = false;
		int length = str.length();
		Stack<Character> stack = new Stack<Character>();

	 
			for (int i = 0; i < length; i++) {
				if (stack.isEmpty()) {
					stack.push(str.charAt(i));
				} else if (stack.peek() == '[' && str.charAt(i) == ']') {
					stack.pop();
				} else if (stack.peek() == '(' && str.charAt(i) == ')') {
					stack.pop();
				} else {
					stack.push(str.charAt(i));
				}

			}
	 

		if (stack.isEmpty()) {
			// ���ջ�ǿյģ�˵������ƥ��
			bo = true;
			 System.out.println("Yes");

		} else {
			bo = false;
			// ˵��ջ��Ϊ�գ����Ų�ƥ��
		 System.out.println("No");
		}

		return bo;
	}

}
