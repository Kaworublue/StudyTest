package ding.study.designpatterns.visitor;
/**
 * ʧ��ʱ��ķ�����
 * @author daniel
 *
 */
public class Failing extends Visitor {
    private String type="ʧ��";
    /**
     * ��������
     */
 @Override
 public void getVisitor(Man concreteElementA) {
  System.out.println(concreteElementA.getSexMessage()+type+"ʱ,��ͷ�Ⱦ�˭Ҳ����Ȱ��");

 }

 /**
  * ����Ů��
  */
 @Override
 public void getVisitor(Woman concreteElementB) {
  System.out.println(concreteElementB.getSexMessage()+type+"ʱ,����������˭ҲȰ���ˡ�");
 }

}