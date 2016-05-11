package ding.study.designpatterns.visitor;
/**
 * ״̬Ϊ�ɹ�ʱ ������
 * @author daniel
 *
 */
public class Success extends Visitor {
    private String type="�ɹ�";

 /**
  * ��������
  */
 @Override
 public void getVisitor(Man concreteElementA) {
  System.out.println(concreteElementA.getSexMessage()+type+"ʱ,��������һ��ΰ���Ů�ˡ�");
 }

 /**
  * ����Ů��
  */
 @Override
 public void getVisitor(Woman concreteElementB) {
  System.out.println(concreteElementB.getSexMessage()+type+"ʱ,��������һ�����ɹ������ˡ�");
 }

}