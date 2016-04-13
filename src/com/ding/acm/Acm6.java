package com.ding.acm;

import java.util.Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ���� ����һ���ƺ����Ϊ20�ף���Ϊ2�ף�Ҫ�ں��������Ϸ��ð뾶ΪRi����ˮװ�ã�ÿ����ˮװ�õ�Ч������������Ϊ���ĵİ뾶Ϊʵ��Ri(0<Ri<15)
 * ��Բ��ʪ�����г������ˮװ��i��1<i<600)��������һ���ܰѲ�ƺȫ��ʪ����Ҫ�����ǣ�ѡ�����ٵ���ˮװ�ã���������ƺ��ȫ��ʪ�� ����
 * ��һ��m��ʾ��m��������� ÿһ��������ݵĵ�һ����һ��������n��n��ʾ����n����ˮװ�ã�����һ�У���n��ʵ��ri��ri��ʾ����ˮװ���ܸ��ǵ�Բ�İ뾶��
 * ��� �������װ�õĸ��� �������� 2 5 2 3.2 4 4.5 6 10 1 2 3 1 2 1.2 3 1.1 1 2 ������� 2 5
 * 
 * ˼·�������������һ��ߵĳ��ȡ��뾶ƽ��-����/2��ƽ��
 * 
 * @author daniel
 * @email 576699909@qq.com
 * @time 2016-4-13 ����6:09:14
 */
public class Acm6 {

	/**
	 * ����
	 */
	private final static double width = 20;
	/**
	 * �߶ȿ��
	 */
	private final static double high = 2;

	/**
	 * @author daniel
	 * @time 2016-4-13 ����5:40:50
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("��������Դ�����");
		int n = Integer.parseInt(strin.readLine());

		while (n-- > 0) {
			System.out.print("��������ͷ������");
			// �����м�����ˮװ��
			int num = Integer.parseInt(strin.readLine());

			// ������
			Double[] rArray = new Double[num];
			// ������ַ�����ȡ������
			String[] split = strin.readLine().split(" ");

			// ����һ���ַ��������һ���ַ�������
			for (int i = 0; i < num; i++) {
				rArray[i] = Double.parseDouble(split[i]);
			}
			// ��������
			Arrays.sort(rArray);

			/*
			 * //ȷ����� StringBuffer sb=new StringBuffer(); for(Double
			 * str:rArray){ sb.append(str); sb.append(" "); }
			 * System.out.println("���������:"+sb);
			 */

			// �ϼƳ���
			double sumWidth = 0;
			for (int j = rArray.length - 1; j > 0; j--) {
				
				//�뾶С�ڿ�ȵ�һ�룬û����
				if(rArray[j]<(high/2)){
					continue;
				}
				
				// ȡ���������е����ֵ
				sumWidth = sumWidth + 2 * Math.sqrt(rArray[j] * rArray[j] - ((high / 2) * (high / 2)));

				if (sumWidth > width) {
					// ˵��
					System.out.println("��Ҫ:" + (rArray.length - j) + " ��");
					// ˵���ҵ��˾����ٵ���ˮװ��
					break;
				}
			}

		}

	}

}
