package com.ding.webservice;
/**
 * 
 * apache��axis1.4��ܡ���Ŀǰ���ȶ���ʹ����㷺�İ汾������webservice����

1��CXF_HOME=C:\DingSai\Tools\apache-cxf-2.7.18

2����path������� %CXF_HOME%/bin;

��cmd����������wsdl2java���������ʾusage���ͱ������óɹ�


 

��ʼʹ��
set Axis_Lib=C:\Users\Desktop\axis\WEB-INF\lib  
set Java_Cmd=java -Djava.ext.dirs=%Axis_Lib% 
set Output_Path=C:\webservice
set Package=com.ding.webservice
%Java_Cmd% org.apache.axis.wsdl.WSDL2Java -o%Output_Path% -p%Package%  http://10.xx.xx.xx/webservice/?wsdl

 wsdl��ʱ����ҪСд
 * @author daniel
 * @email 576699909@qq.com
 * @time 2016-5-5 ����11:02:46
 */
public class ZTestMain {

	/**
	 * @author daniel
	 * @time 2016-5-5 ����11:00:05
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		WsdlPortType service = new WsdlLocator().getwsdlPort(new java.net.URL("http://10.xx.xx.xx/webservice/?WSDL"));

		String retMsg = service.getCinemas("xxxx", "xxxx");
		System.out.println("" + retMsg);

	}

}
