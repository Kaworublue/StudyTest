package com.ding.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * VM args:-Xms20m -Xmx20m -XX:HeapDumpOnOutOfMemoryError
 * Created by �϶� on 2018-1-5 0005.
 * ˵��:
 * �Ѵ�С����Ϊ20m ������չ(xms��xmxһ��������չ)������heapDumpOnOutOfMemoryError���ڴ����ʱDUMP����ǰ�ڴ��ת������
 */
public class Study1HeapOOM {
    static class OOMObject{

    }

    /**
     * java.lang.OutOfMemoryError:java heap space
     * �ѷŶ������
     * @param args
     */
    public static void main(String [] args){
        List<OOMObject> list=new ArrayList<OOMObject>();
        while (true){
            list.add(new OOMObject());
        }

    }

}
