package com.ding.util.md5;

public class Zmain {

	// ����������
	public static void main(String args[]) {
		// ԭ��
		String plaintext = "DingSai";
	//  plaintext = "123456";
		System.out.println("ԭʼ��" + plaintext);
		System.out.println("��ͨMD5��" + MD5Util.MD5(plaintext));

		// ��ȡ���κ��MD5ֵ
		String ciphertext = MD5Util.generate(plaintext);
		System.out.println("���κ�MD5��" + ciphertext);
		System.out.println("�Ƿ���ͬһ�ַ���:" + MD5Util.verify(plaintext, ciphertext));
		/**
		 * ����ĳ��DingSai�ַ�����MD5ֵ
		 */
		String[] tempSalt = { "c4d980d6905a646d27c0c437b1f046d4207aa2396df6af86", "66db82d9da2e35c95416471a147d12e46925d38e1185c043", "61a718e4c15d914504a41d95230087a51816632183732b5a" };

		for (String temp : tempSalt) {
			System.out.println("�Ƿ���ͬһ�ַ���:" + MD5Util.verify(plaintext, temp));
		}
		
		
		
		
		
		
	}
}
