package com.ding.util.aes;
/**
 * ������
 * ���:
 * ԭ:yuanwen
���ܺ�:pF5lucWGXeeFwmendXQyVA==
���ܺ�:yuanwen

 * 
 * @author daniel
 * @email 576699909@qq.com
 * @time 2016-6-11 ����7:51:47
 */
public class Zmain {

	/**
	 * @author daniel
	 * @time 2016-6-11 ����7:48:12
	 * @param args
	 */

 

	public static void main(String[] args) {
		// ����ԭ��
		String plaintext = "yuanwen";
		// ��Կ
		String key = "123456";
		//����
		String ciphertext;
		try {
			ciphertext = AES.encrypt(plaintext.getBytes("UTF-8"), key);
			String de = AES.decrypt(ciphertext, key);
			System.out.println("ԭ:" + plaintext);
			System.out.println("���ܺ�:" + ciphertext);
			System.out.println("���ܺ�:" + de);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
