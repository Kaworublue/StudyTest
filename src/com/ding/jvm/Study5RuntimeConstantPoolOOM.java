package com.ding.jvm;

/**
 * ������-��Ӫʱ������-6��6�Ժ��в��intern����ʱ���ʡ�ڴ�
 * @author daniel 2018-1-8 0008.
 */
public class Study5RuntimeConstantPoolOOM {

    /**
     *http://blog.csdn.net/seu_calvin/article/details/52291082
     * http://blog.csdn.net/bigtree_3721/article/details/74907670
     *������jdk7��ǰ�����洢�����ԱȽϵ��ǳ����صĵ�ַ��new����ĵ�ַ
     * jdk7�Ժ����ط��ڶ�����Ե�ַһ����a��c��������ĸ
     * ����������������౻JVM����ʱ������ֵ���� a, b, c �ͻᱻ���ص� String �������У�ע�⣬�����ڱ���׶ξ�ȷ���˵ĳ����ַ�������
     * ���ԱȽ�C��ʱ��һ�����ڶѵĳ������һ������new�Ķ���
     * @param args
     * @throws Throwable
     */
    public static void main(String[] args) throws Throwable {
        String str1=new StringBuilder("�����").append("���").toString();
        System.out.println(str1.intern()==str1);

        String str2=new StringBuilder("c").toString();
        System.out.println(str2.intern()==str2);


    }

}
