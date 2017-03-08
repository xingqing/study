/**
 * ZooKeeperOperator.java
 * ��Ȩ����(C) 2013 
 * ����:cuiran 2013-01-16 15:03:40
 */
package com.codefun;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;

/**
 * TODO
 * @author cuiran
 * @version TODO
 */
public class ZooKeeperOperator extends AbstractZooKeeper {
	
	private static Log log = LogFactory.getLog(ZooKeeperOperator.class.getName());

	/**
	 * 
	 *<b>function:</b>�����־�̬��znode,��֧�ֶ�㴴��.�����ڴ���/parent/child�������,��/parent.�޷�ͨ��
	 *@author cuiran
	 *@createDate 2013-01-16 15:08:38
	 *@param path
	 *@param data
	 *@throws KeeperException
	 *@throws InterruptedException
	 */
	public void create(String path,byte[] data)throws KeeperException, InterruptedException{
		/**
		 * �˴����õ���CreateMode��PERSISTENT  ��ʾThe znode will not be automatically deleted upon client's disconnect.
		 * EPHEMERAL ��ʾThe znode will be deleted upon the client's disconnect.
		 */ 
		this.zooKeeper.create(path, data, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
	}
	/**
	 * 
	 *<b>function:</b>��ȡ�ڵ���Ϣ
	 *@author cuiran
	 *@createDate 2013-01-16 15:17:22
	 *@param path
	 *@throws KeeperException
	 *@throws InterruptedException
	 */
	public void getChild(String path) throws KeeperException, InterruptedException{   
		try{
			List<String> list=this.zooKeeper.getChildren(path, false);
			if(list.isEmpty()){
				log.debug(path+"��û�нڵ�");
			}else{
				log.debug(path+"�д��ڽڵ�");
				for(String child:list){
					log.debug("�ڵ�Ϊ��"+child);
				}
			}
		}catch (KeeperException.NoNodeException e) {
			 //TODO: handle exception
			 throw e;   

		}
	}
	
	public byte[] getData(String path) throws KeeperException, InterruptedException {   
        return  this.zooKeeper.getData(path, false,null);   
    }  
	
	 public static void main(String[] args) {
		 try {   
			 TimeUnit.HOURS.sleep(2);
	            ZooKeeperOperator zkoperator = new ZooKeeperOperator();   
	            zkoperator.connect("192.168.68.128:2181,192.168.68.129:2181,192.168.68.130:2181");
	            log.info("sdfsdfsdf");
	            byte[] data = new byte[]{'a','b','c','d'};   
	            Stat stat = null;
	            if((stat=zkoperator.zooKeeper.exists("/root", false))!= null){
	            	 log.info(stat.getVersion());
	            	zkoperator.zooKeeper.delete("/root", -1);
	            }
	            
	            zkoperator.create("/root",null);
	            System.out.println(Arrays.toString(zkoperator.getData("/root")));
	            
	            zkoperator.create("/root/child1",data);
	            System.out.println(Arrays.toString(zkoperator.getData("/root/child1")));   

	            zkoperator.create("/root/child2",data);
	            System.out.println(Arrays.toString(zkoperator.getData("/root/child2")));   

	            String zktest="ZooKeeper��Java API����";
	            zkoperator.create("/root/child3", zktest.getBytes());
	            log.debug("��ȡ���õ���Ϣ��"+new String(zkoperator.getData("/root/child3")));
	            
	            System.out.println("�ڵ㺢����Ϣ:");
	            zkoperator.getChild("/root");

	            zkoperator.close();
	            
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	}
}
