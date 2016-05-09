package com.ding.redis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class ZMainRedisHash {

	/**
	 * @author daniel
	 * @time 2016-5-9 ����11:08:13
	 * @param args
	 */
	public static void main(String[] args) {
		// ��������key
		String requestKey = "/xxx/password:" + mobile;

		// ɾ��integralValidationSms.deleteUserSendSmsCount(requestKey);
		// this.delKeyFromJedis(RedisSetKeyConstant.USER_SEND_SMS_COUNT + ":" +
		// uid);

		Map<String, String> interfaceCount = new HashMap<String, String>();

		// ��hash
		interfaceCount = this.getHashMapFromJedis(requestKey);
		int requestCount = Integer.parseInt(interfaceCount.get("USERCOUNT"));
		Long.parseLong(interfaceCount.get("COUNTTIME"));

		// set���ÿ��Ե��õĴ���
		interfaceCount.put("USERCOUNT", REQUEST_COUNT);
		// �����״ε���ʱ��
		interfaceCount.put("COUNTTIME", this.getTime());
		// set
		this.addHashMapToJedis(requestKey, interfaceCount, seconds, false);

	}

	/**
	 * �����޸�hash��ֵ
	 * 
	 * @param key
	 * @param map
	 * @param cacheSeconds
	 * @param isModified
	 * @param methodName
	 */
	public boolean addHashMapToJedis(String key, Map<String, String> map, int cacheSeconds, boolean isModified) {
		boolean isBroken = true;
		boolean status = true;
		Jedis jedis = null;
		if (map != null && map.size() > 0) {
			try {
				jedis = this.getJedis();
				jedis.select(getDBIndex());
				jedis.hmset(key, map);
				if (cacheSeconds > 0) {
					jedis.expire(key, cacheSeconds);
				}
			} catch (Exception e) {
				e.printStackTrace();
				isBroken = true;
				status = false;
			} finally {
				release(jedis, isBroken);
			}
		}
		return status;
	}
}
