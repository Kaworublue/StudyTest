package com.ding.acm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * ����ˮ��
ʱ�����ƣ�1000 ms  |  �ڴ����ƣ�65535 KB
�Ѷȣ�4
����
��������ˮ������С��һ������ֻ������ˮ����ˮ��װ���ģ���������Ϊ�ձ��ӡ�����ˮ��֮���໥��ˮ������ˮ��û�б�ʶ��ֻ�ܸ��ݸ�����ˮ����������㡣����Ҫ����д��һ������ʹ�����ʹ��ʼ״̬����Ŀ��״̬�����ٴ�����
����
��һ��һ������N(0<N<50)��ʾN���������
������ÿ��������������У���һ�и�����������V1 V2 V3 (V1>V2>V3 V1<100 V3>0)��ʾ����ˮ���������
�ڶ��и�����������E1 E2 E3 �����С�ڵ�����Ӧˮ���������ʾ������Ҫ������״̬
���
ÿ�������Ӧ�����������ٵĵ�ˮ����������ﲻ��Ŀ��״̬���-1
��������
2
6 3 1
4 1 1
9 3 2
7 1 1
�������
3
-1
 * @author daniel
 * @email 576699909@qq.com
 * @time 2016-5-17 ����10:20:59
 */
public class Acm21 {

	public static boolean[][][] visited = new boolean[100][100][100];
	public static Queue<CupNode> nodeQueue;
	public static int[] cupCapacity = new int[3];
	public static int[] targetState = new int[3];

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testnum = input.nextInt();
		for (int i = 0; i < testnum; i++) {
			for (int j = 0; j < 3; j++) {
				cupCapacity[j] = input.nextInt();
			}
			for (int j = 0; j < 3; j++) {
				targetState[j] = input.nextInt();
			}
			for (int j = 0; j < 100; j++)
				for (int k = 0; k < 100; k++)
					for (int l = 0; l < 100; l++)
						visited[j][k][l] = false;

			System.out.println(BFS());
		}
		input.close();
	}

	public static class CupNode {
		int[] state = new int[3];
		int stepNum;
	}

	public static boolean isAchieveTarget(CupNode currentNode) {
		for (int i = 0; i < 3; i++) {
			if (currentNode.state[i] != targetState[i]) {
				return false;
			}
		}
		return true;
	}

	public static void pourWater(int destination, int source, CupNode newNode) {
		int leftWaterFiled = cupCapacity[destination] - newNode.state[destination];
		if (newNode.state[source] >= leftWaterFiled) {
			newNode.state[destination] += leftWaterFiled;
			newNode.state[source] -= leftWaterFiled;
		} else {
			newNode.state[destination] += newNode.state[source];
			newNode.state[source] = 0;
		}
	}

	public static int BFS() {
		nodeQueue = new LinkedList<CupNode>();
		CupNode currentNode = new CupNode();
		currentNode.state[0] = cupCapacity[0];
		currentNode.state[1] = currentNode.state[2] = 0;
		nodeQueue.add(currentNode);
		visited[currentNode.state[0]][currentNode.state[1]][currentNode.state[2]] = true;
		while (!nodeQueue.isEmpty()) {
			currentNode = nodeQueue.poll();
			if (isAchieveTarget(currentNode)) {
				return currentNode.stepNum;
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 1; j < 3; j++) {
					int k = (i + j) % 3;
					if (currentNode.state[i] != 0 && cupCapacity[k] > currentNode.state[k]) {
						CupNode newNode = new CupNode();
						for (int l = 0; l < 3; l++) {
							newNode.state[l] = currentNode.state[l];
						}
						newNode.stepNum = currentNode.stepNum;
						pourWater(k, i, newNode);
						newNode.stepNum = currentNode.stepNum + 1;
						if (!visited[newNode.state[0]][newNode.state[1]][newNode.state[2]]) {
							nodeQueue.add(newNode);
							visited[newNode.state[0]][newNode.state[1]][newNode.state[2]] = true;
						}
					}
				}
			}
		}
		return -1;
	}
}