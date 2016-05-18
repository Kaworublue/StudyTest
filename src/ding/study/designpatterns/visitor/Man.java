
package ding.study.designpatterns.visitor;

public class Man extends IPersonShow {
 private String sexMessage="����";
 @Override
 /**
  * ��������ʱ ���� �����ߵķ��ʷ���
  */
 public void accept(Visitor visitor) {
  visitor.getVisitor(this);
  }

 /**
  * @return the sexMessage
  */
 public String getSexMessage() {
  return sexMessage;
 }

}