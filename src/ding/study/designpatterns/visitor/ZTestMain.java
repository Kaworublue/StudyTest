
package ding.study.designpatterns.visitor;

public class ZTestMain {

 /**
  * ���Է�����ģʽ
  * @param args
  */
 public static void main(String[] args) {
   //����ṹ��
  ObjectStructure o=new ObjectStructure();
  //�������˺�Ů��
  o.add(new Man());
  o.add(new Woman());
  //�ɹ�״̬�·���
  Success visitor1=new Success();
  o.show(visitor1);
  //ʧ��״̬�·���
  Failing visitor2=new Failing();
  o.show(visitor2);

 }

}

 