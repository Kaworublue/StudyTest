package com.ding.study.thread.ReadWriteLock;

import java.util.Map;

import java.util.concurrent.locks.ReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

import java.util.HashMap;

public class ReadWriteLockMain {
	/**
	 * �������
	 */
	private Map<String, Object> cache = new HashMap<String, Object>();
	/**
	 * ��д������
	 */
	private ReadWriteLock rw1 = new ReentrantReadWriteLock();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ReadWriteLockMain m=	new ReadWriteLockMain();
		m.cache.put("1", "1");
		for (int i=0;i<90;i++){
			m.cache.put(i+"", i+"");
		}
		
		
		System.out.println(m.getData("2"));
		
		System.out.println(m.getData("2"));
	}

	public Object getData(String key) {
		rw1.readLock().lock();
		Object value = cache.get(key);
		if (value == null) {
			rw1.readLock().unlock();
			rw1.writeLock().lock();
			// ����߳�ͬʱ�����ظ��ж�
			if (value == null) {
				value = "aaaa";
			}
			rw1.writeLock().unlock();
			rw1.readLock().lock();
		}
		rw1.readLock().lock();
		return value;
	}
}
