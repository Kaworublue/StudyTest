
package ding.study.designpatterns.visitor;

public class Woman extends IPersonShow {
 private String sexMessage="Ů��";

 @Override
 /**
  * ����Ů��ʱ������ �����ߵ� Ŀ��
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