package com.ding.jvm;


/**
 * VM args:-Xss128k
 * @author daniel 2018-1-5 0005.
 * ˵��:hotspot
 */
public class Study2JavaVMStackSOF {

    private int stackLength = 1;

    public void statckLeak() {
        stackLength++;
        statckLeak();
    }

    /**
     * java.lang.StackOverflowError
     * stack length:970
     * hotspot�����������ջ�ͱ��ط���ջ��-Xss������
     * �߳�����ջ��ȴ��������������������׳�StackOverflowError�쳣
     * ��������㹻�ڴ��׳�OutOfMemoryError
     *
     * @param args
     */
    public static void main(String[] args) {
        Study2JavaVMStackSOF oom=new Study2JavaVMStackSOF();

        try {
            oom.statckLeak();
        }catch (Throwable e){
            System.out.println("stack length:"+oom.stackLength);
            e.printStackTrace();
        }


    }
}
