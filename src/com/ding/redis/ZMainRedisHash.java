package com.ding.redis;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ZMainRedisHash extends JedisTools {

	/**
	 * @author daniel
	 * @time 2016-5-9 ����11:08:13
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		/*
		 * // ��������key String requestKey = "/xxx/password:" ;
		 * 
		 * Map<String, String> interfaceCount = new HashMap<String, String>();
		 * ZMainRedisHash test=new ZMainRedisHash();
		 * 
		 * 
		 * // ɾ��integralValidationSms.deleteUserSendSmsCount(requestKey);
		 * test.delKeyFromJedis(requestKey);
		 * 
		 * 
		 * // ��hash interfaceCount = test.getHashMapFromJedis(requestKey); int
		 * requestCount = Integer.parseInt(interfaceCount.get("USERCOUNT"));
		 * Long.parseLong(interfaceCount.get("COUNTTIME"));
		 * 
		 * // set���ÿ��Ե��õĴ��� interfaceCount.put("USERCOUNT", "2"); // �����״ε���ʱ��
		 * interfaceCount.put("COUNTTIME",""); // set
		 * test.addHashMapToJedis(requestKey, interfaceCount, 10, false);
		 */

/*		// ����redis��������192.168.0.100:6379
		Jedis jedis = new Jedis("10.141.4.119", 6379);
		// Ȩ����֤
		jedis.auth("mima");

		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "xinxin");
		map.put("age", "22");
		map.put("qq", "123456");
		jedis.hmset("tdc_user", map);
    
		//jedis.hmget(arg0, arg1)
		Iterator<String> iter = jedis.hkeys("tdc_user").iterator();
		List<String>list=new ArrayList<String>();
		while (iter.hasNext()) {
			String key = iter.next();
			List<String>	value= jedis.hmget("tdc_user", key);
			System.out.println(key + ":" +value);
		
			for(String t:value){
				System.out.println("aaaa:"+t);

			}
			
			
		}*/
		
		String key="Daniel";
		
		ZMainRedisHash test =new ZMainRedisHash();
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "xinxin");
		map.put("age", "22");
		map.put("qq", "123456");
		test.addHashMapToJedis(key, map, 5, true);
		
		Map<String, String> testMap=	test.getHashMapFromJedis(key);
		System.out.println("��һ�����:");
		test.outMap(testMap);
		//getHashMapFromJedis
		
		Thread.sleep(1000*9);
		System.out.println("�ڶ������:");
		testMap=	test.getHashMapFromJedis(key);
		test.outMap(testMap);

		

	}
	public void outMap(Map map){
		Set<String> keys = map.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
		String key = it.next();
		System.out.println(key + "-->" + map.get(key));
		}
 
		
	}

	 
	@Override
	public int getDBIndex() {
		return 0;
	}
}
