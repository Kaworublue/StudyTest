package ding.study.designpatterns.visitor;
/**
 * �����߳�����
 * @author daniel
 *
 */
abstract class Visitor {
/**
 * �������˵ķ�Ӧ ����
 * @param concreteElementA
 */
 public abstract void getVisitor(Man concreteElementA); 
 
 /**
  *����Ů�˵ķ�Ӧ ����
  */
 
 public abstract void getVisitor(Woman concreteElementB);
}

/**
 * �������
 * @author daniel
 *
 */
abstract class Person{ 
 /**
  * ���ܷ���
  * @param visitor
  */
 public abstract void accept(Visitor visitor);
}

 