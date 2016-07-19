package com.ding.thread;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * �̳߳�
 * 
 * @author danield
 * 
 */
public class ThreadPoolExecutorTest {
	private static int produceTaskMaxNumber = 200;

	public static void main(String[] args) {
		// ����һ���̳߳�;���ģ���󣻵ȴ�ʱ�䣻��λ;��200���޾��׳� RejectedExecutionException�쳣
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 20, 3,
				TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

		
		
		
		for (int i = 1; i <= produceTaskMaxNumber; i++) {
			System.out.println(Thread.currentThread().getName());
			System.out.println("�̲߳���getMaximumPoolSize:"
					+ threadPool.getMaximumPoolSize());
			System.out.println("�̲߳���corePoolSize:"
					+ threadPool.getCorePoolSize());
			System.out.println("�̲߳���getActiveCount:"
					+ threadPool.getActiveCount());
			System.out.println("�̲߳���getTaskCount:" + threadPool.getTaskCount());
			System.out.println("�����getLargestPoolSize:"
					+ threadPool.getLargestPoolSize());
			System.out.println("�̲߳���getPoolSize���س��еĵ�ǰ�߳�����:"
					+ threadPool.getPoolSize());
			
			try {
				// ����һ�����񣬲�������뵽�̳߳�
				final String task = "task@ " + i;
				// System.out.println("put " + task);
				threadPool.execute(new Runnable() {
					@Override
					public void run() {
						System.out.println("ִ��"+task);
						// ˯60��
						try {
							Thread.sleep(1000 * 3);
							System.out.println(System.currentTimeMillis());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			} catch (RejectedExecutionException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}

		}

		System.out.println("------------------end------------------------:");

		for (int i = 1; i <= 1; i++) {
			// ˯60��
			try {
				Thread.sleep(1000 * 10);
				System.out.println("������");
				System.out.println("�̲߳���getMaximumPoolSize:"
						+ threadPool.getMaximumPoolSize());
				System.out.println("�̲߳���corePoolSize:"
						+ threadPool.getCorePoolSize());
				System.out.println("�����getActiveCount:"
						+ threadPool.getActiveCount());
				System.out.println("�����getTaskCount:"
						+ threadPool.getTaskCount());
				System.out.println("�����getLargestPoolSize:"
						+ threadPool.getLargestPoolSize());
				System.out.println("�����getPoolSize:"
						+ threadPool.getPoolSize() + "\n\n");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
