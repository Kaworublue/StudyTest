package com.ding.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat; 
public class TestZookeeper {
/**
    String connectionString="10.199.88.169:2181";
	      int connectionTimeout=50000;
	      
	      ZkClient zkClient=new ZkClient(connectionString, connectionTimeout);
	      
	      System.out.println(zkClient.getChildren("/taobao"));
	      
	      String Path="/thirdName";
	      
	   // ����һ���������������
	      ZooKeeper zk = new ZooKeeper(connectionString, 
	    		  connectionTimeout, new Watcher() { 
	                 // ������б��������¼�
	                 public void process(WatchedEvent event) { 
	                     System.out.println("�Ѿ�������" + event.getType() + "�¼���"); 
	                 } 
	             }); 
	      // ����һ��Ŀ¼�ڵ�
	      zk.create(Path, "testRootData".getBytes(), Ids.OPEN_ACL_UNSAFE,
	        CreateMode.PERSISTENT); 
	      // ����һ����Ŀ¼�ڵ�
	      zk.create(Path+"/testChildPathOne", "testChildDataOne".getBytes(),
	        Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT); 
	      System.out.println(new String(zk.getData(Path+"",false,null))); 
	      // ȡ����Ŀ¼�ڵ��б�
	      System.out.println(zk.getChildren(Path+"",true)); 
	      // �޸���Ŀ¼�ڵ�����
	      zk.setData(Path+"/testChildPathOne","modifyChildDataOne".getBytes(),-1); 
	      System.out.println("Ŀ¼�ڵ�״̬��["+zk.exists(Path+"",true)+"]"); 
	      // ��������һ����Ŀ¼�ڵ�
	      zk.create(Path+"/testChildPathTwo", "testChildDataTwo".getBytes(), 
	        Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT); 
	      System.out.println(new String(zk.getData(Path+"/testChildPathTwo",true,null))); 
	      // ɾ����Ŀ¼�ڵ�
	       zk.delete(Path+"/testChildPathTwo",-1); 
	      zk.delete(Path+"/testChildPathOne",-1); 
	      // ɾ����Ŀ¼�ڵ�
	      zk.delete(Path+"",-1); 
	      // �ر�����
	      zk.close();
	      
	      
 * @param args
 */
	public static void main(String[] args) throws Exception {

	      
	  //    String Path="/thirdName/ALLBAIDULBS";
	//    String []aa=  "10.199.88.169;10.1.120.124".split(";");
	    
	   //   System.out.println(aa[0]+";"+aa[1]);
	    String connectionString="10.141.4.141:2181";
	      int connectionTimeout=50000;
	      
	 /*     ZkClient zkClient= new ZkClient(connectionString, connectionTimeout);
	      
	  //    System.out.println(zkClient.getChildren("/TAOBAO"));
	      System.out.println(zkClient.readData(Path+"/TAOBAO"));
	      
	      if(1==1){
		      return;

	      }*/
	      

	   // ����һ���������������
	      ZooKeeper zk = new ZooKeeper(connectionString, 
	    		  connectionTimeout, new Watcher() { 
	                 // ������б��������¼�
	                 public void process(WatchedEvent event) {
	                     System.out.println("�Ѿ�������" + event.getType() + "�¼���");
	                 }
	             });
	      // ����һ��Ŀ¼�ڵ�
	   //   zk.create(Path, "testRootData".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT); 
	      // ����һ����Ŀ¼�ڵ�
	    //   zk.create(Path, "testTAOBAO".getBytes(), Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT); 
	     // System.out.println(new String(zk.getData(Path+"",false,null))); 
	      // ȡ����Ŀ¼�ڵ��б�
	     // System.out.println(zk.getChildren(Path+"",true)); 
	      // �޸���Ŀ¼�ڵ�����
	    //  zk.setData(Path,"10.141.4.141".getBytes(),-1); 
	    //  System.out.println("Ŀ¼�ڵ�״̬��["+zk.exists(Path,true)+"]"); 
		//	Stat stat=zk.exists(Path,true);
	      
	      // ��������һ����Ŀ¼�ڵ�
	    //  zk.create(Path+"/testChildPathTwo", "testChildDataTwo".getBytes(),  Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT); 
	   //   System.out.println(Path+"ֵ:"+new String(zk.getData(Path,true,null))); 
	      // ɾ����Ŀ¼�ڵ�
	   //    zk.delete(Path+"/testChildPathTwo",-1); 
	   //   zk.delete(Path+"/testChildPathOne",-1); 
	      // ɾ����Ŀ¼�ڵ�
	    //  zk.delete(Path+"",-1); 
	      // �ر�����
	      zk.close();
	      

	      
	      
	      
	      
	      
	}

}
