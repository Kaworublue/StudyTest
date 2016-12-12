package com.ding.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * �ȶ�����
 * 
 * @author daniel
 * 
 */
public class ClearUtil {

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

/**
 * 
 * @param realIdCard ��ʵ���֤
 * @param currentIdCard ģ�����֤
 * @return
 */
	public static boolean clearIdCard(String realIdCard, String currentIdCard) {
		System.out.println("���֤:" + realIdCard + ";" + currentIdCard);
		boolean bo = false;

		if (realIdCard == null || currentIdCard == null) {
			System.out.println("���֤��Ϊ��:" + realIdCard + ";" + currentIdCard);
			return bo;
		}

		// ȥ�����ַ�
		realIdCard = realIdCard.replaceAll(" ", "");
		currentIdCard = currentIdCard.replaceAll(" ", "");

		// ���Ȳ�һ������ƥ��
		if (realIdCard.length() != currentIdCard.length()) {
			System.out.println("���֤���Ȳ�һ��:" + realIdCard + ";" + currentIdCard);
			return bo;
		}

		int numberCount = 0;
		int tureCount=0;

	 
		for (int i = currentIdCard.length(); --i >= 0;) {	
			System.out.println("currentIdCard:" + currentIdCard.charAt(i) + ";realIdCard:" + realIdCard.charAt(i));
			if (Character.isDigit(currentIdCard.charAt(i))) {
				//�����ֵĸ���
				numberCount++;
				if(currentIdCard.charAt(i)==realIdCard.charAt(i)){
					//ƥ����ȵĸ���
					tureCount++;
				}
			}
		}
		
		
 
        //���ֲ���ȫ�����
		if (numberCount == tureCount) {
			bo = true;
		}
		
		return bo;

	}

	public static void main(String[] args) throws Exception {
		
		System.out.println("1:" + ClearUtil.clearIdCard("52262619800410121X", "522626**800410121X") + "\n\n");
		System.out.println("2:" + ClearUtil.clearIdCard("220503198006080528", "*****3198006080528") + "\n\n");
		System.out.println("1:" + ClearUtil.clearIdCard("632824197603110117", "632824197603110***") + "\n\n");
		System.out.println("3:" + ClearUtil.clearIdCard("110107198408270939", "uu0107198408270***") + "\n\n");
		System.out.println("5:" + ClearUtil.clearIdCard("500384199104244185", "500384*******44185") + "\n\n");
		System.out.println("6:" + ClearUtil.clearIdCard("52262619800410121X", "52262619800410121X") + "\n\n\n\n");
		System.out.println("7:" + ClearUtil.clearIdCard("220503198006080528", "*****3198006080521") + "\n\n");
		System.out.println("8:" + ClearUtil.clearIdCard("632824197603110117", "632824197603111***") + "\n\n");
		System.out.println("9:" + ClearUtil.clearIdCard("110107198408270939", "uu0107198408271***") + "\n\n");
		System.out.println("10:" + ClearUtil.clearIdCard("500384199104244185", "500384*******41185") + "\n\n");

	/*	System.out.println("1:" + ClearName.clearName("����", "��*") + "\n\n");
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
		System.out.println("ccc1:"
				+ ClearName.clearName("��ʫ�����״�Ԥ���ֻ���Ѳ��˻���", "************˾")
				+ "\n\n");*/
	}

}
