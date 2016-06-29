package com.ding.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {

	// String �ᱻ JVM �Ż�
	private final String FINAL_VALUE  = "FINAL";

	//��Ŀ����� �����Ż�
	//private final String FINAL_VALUE =  null == null ? "FINAL" : null;
	
	public String getFinalValue() {
		// �ᱻ�Ż�Ϊ: return "FINAL" ,��Ŀ�Դ���
		return FINAL_VALUE;
	}

/*	���캯����ֵһ�����Ա����Ż�
 * public TestClass() {
		this.FINAL_VALUE = "FINAL";
	}*/

	/**
	 * �޸Ķ���˽�г�����ֵ Ϊ�����룬�ڷ������׳��ܵ��쳣��ʵ�ʿ���������
	 */
	private static void modifyFinalFiled() throws Exception {
		// 1. ��ȡ Class ��ʵ��
		TestClass testClass = new TestClass();
		Class mClass = testClass.getClass();

		// 2. ��ȡ˽�г���
		Field finalField = mClass.getDeclaredField("FINAL_VALUE");

		// 3. �޸ĳ�����ֵ
		if (finalField != null) {

			// ��ȡ˽�г����ķ���Ȩ
			finalField.setAccessible(true);

			// ���� finalField �� getter ����
			// ��� FINAL_VALUE �޸�ǰ��ֵ
			System.out.println("Before Modify��FINAL_VALUE = "
					+ finalField.get(testClass));

			// �޸�˽�г���
			finalField.set(testClass, "Modified");

			// ���� finalField �� getter ����
			// ��� FINAL_VALUE �޸ĺ��ֵ
			System.out.println("After Modify��FINAL_VALUE = "
					+ finalField.get(testClass));

			// ʹ�ö��������� getter ����
			// ��ȡֵ�����
			System.out.println("Actually ��FINAL_VALUE = "
					+ testClass.getFinalValue());
		}
	}

	/**
	 * 
	 * ������: Before Modify��FINAL_VALUE = FINAL After Modify��FINAL_VALUE =
	 * Modified Actually ��FINAL_VALUE = Modified
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		TestClass.modifyFinalFiled();		
		ApplicationContext a = new ClassPathXmlApplicationContext("");  		
		StringBuffer sb=new StringBuffer();
		sb.append("1111");
		sb.append("2222");
		System.out.println(sb);
			
		Method[] methods=TestClass.class.getDeclaredMethods();
		for(Method method:methods){
			if(method.getName().equals("")){
				method.setAccessible(true);
				
			}
			
			
		}
		
		
	}

}
