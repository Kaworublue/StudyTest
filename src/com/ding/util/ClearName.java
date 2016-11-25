package com.ding.util;
 

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * �ȶ�����
 * @author daniel
 *
 */
public class ClearName {

	/**
	 * 
	 * @param realName
	 *            ��ȷ�ϵ���ʵϵ����
	 * @param currentName
	 *            �������Ӫ������
	 * @return
	 */
	public static boolean clearName(String realName, String currentName) {
		System.out.println("�ȶ�����:" + realName + ";" + currentName);

		boolean bo = false;
		if (realName == null || currentName == null) {
			System.out.println("������Ϊ��:" + realName + ";" + currentName);
			return bo;
		}

		// ȥ�����ַ�
		realName = realName.replaceAll(" ", "");
		currentName = currentName.replaceAll(" ", "");

		// ���Ȳ�һ������ƥ��
		if (realName.length() != currentName.length()) {
			System.out.println("�������Ȳ�һ��:" + realName + ";" + currentName);
			return bo;
		}
		
		// ȫ������
		String reg = "[\\u4e00-\\u9fa5]*";
		Pattern pat = Pattern.compile(reg);
		Matcher mat = pat.matcher(currentName);
		StringBuilder sb = new StringBuilder();
		while (mat.find()) {
			String t = mat.group();
			sb.append(t);
		}
		
		String charTmp = sb.toString();
		// ץȡ��������������
		if (charTmp.length() < 1) {
			return bo;
		}
		int trueCount = 0;		

		for (int i = 0; i < charTmp.length(); i++) {
			char t = charTmp.charAt(i);
			if (realName.charAt(currentName.indexOf(t, (i < 1 ? 0 : i - 1))) == t) {
				trueCount++;
			}
		}

		if (trueCount == charTmp.length()) {
			bo = true;
		}

		return bo;

	}

	public static void main(String[] args) throws Exception { 

		System.out.println("1:" + ClearName.clearName("����", "��*") + "\n\n");
		System.out.println("2:" + ClearName.clearName("����", "*��") + "\n\n");
		System.out.println("3:" + ClearName.clearName("����", "*��") + "\n\n");
		System.out.println("4:" + ClearName.clearName("������", "����*") + "\n\n");
		System.out.println("5:" + ClearName.clearName("������", "*��*") + "\n\n");
		System.out.println("6:" + ClearName.clearName("������", "***") + "\n\n");
		System.out.println("7:" + ClearName.clearName("������", "��**") + "\n\n");
		System.out.println("8:" + ClearName.clearName("������", "**��") + "\n\n");
		System.out.println("aa1:" + ClearName.clearName("������", "������") + "\n\n");
		System.out.println("aa2:" + ClearName.clearName("������", "xx��") + "\n\n");
		System.out.println("aa3:" + ClearName.clearName("������", "x����") + "\n\n");
		System.out.println("aa4:" + ClearName.clearName("������", "��x��") + "\n\n");
		System.out.println("aa5:" + ClearName.clearName("������", "��xz") + "\n\n");
		System.out.println("aa6:" + ClearName.clearName("������", "������") + "\n\n");
		System.out.println("aa7:" + ClearName.clearName("������", "����z") + "\n\n");
		System.out.println("aa8:" + ClearName.clearName("������", "xxx") + "\n\n");
		System.out.println("bb1:" + ClearName.clearName("����", "����") + "\n\n");
		System.out.println("bb2:" + ClearName.clearName("����", "��*") + "\n\n");
		System.out.println("bb3:" + ClearName.clearName("����", "*��") + "\n\n");
		System.out.println("bb4:" + ClearName.clearName("����", "*z") + "\n\n");
		System.out.println("ccc1:" + ClearName.clearName("��ʫ�����״�Ԥ���ֻ���Ѳ��˻���", "************˾") + "\n\n");
	}

}
