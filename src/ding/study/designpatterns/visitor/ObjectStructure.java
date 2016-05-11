package ding.study.designpatterns.visitor;

import java.util.ArrayList;
import java.util.List;
/**
 * �˵Ķ��󼯺ϲ���
 * @author daniel
 *
 */
public class ObjectStructure {

 /**
  * �ܶ��˵Ľ��
  */
 private List<Person> elements=new ArrayList<Person>();
 /**
  * ����
  * @param element
  */
 public void add(Person element){
  elements.add(element);
 }
 /**
  * ɱ��
  * @param element
  */
 public void delete(Person element){
  elements.remove(element);
 }
 /**
  * �Ŷӱ���  ����״̬�� �˵ķ�Ӧ
  * @param visitor
  */
 public void show(Visitor visitor){
  for(Person e :elements){
   e.accept(visitor);
  }
 } 
 
 
}