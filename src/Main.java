import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * ���ĵĹ��� ʱ�����ƣ�1000 ms | �ڴ����ƣ�65535 KB �Ѷȣ�3 ����
 * ��һ�����ĵĹ�������N�����У���N�����м�ֻ��N-1��·�����N��������������
 * �����ڣ�Tom�ڵ�S�ų��У������Ÿù���ͼ������֪������Լ�Ҫȥ�ι۵�T�ų��У����뾭����ǰһ�������Ǽ��ų��У������㲻���ظ���·���� ����
 * ��һ������һ������M��ʾ�������ݹ���M(1<=M<=5)��
 * ÿ��������ݵĵ�һ������һ��������N(1<=N<=100000)��һ��������S(1<=S<=100000)��N��ʾ���е��ܸ�����S��ʾ�ι������ڳ��еı��
 * ����N-1�У�ÿ��������������a,b(1<=a,b<=N)����ʾ��a�ų��к͵�b�ų���֮����һ��·��ͨ�� ���
 * ÿ�����������N�������������У���i������ʾ��S�ߵ�i�ų��У�����Ҫ��������һ�����еı�š�������i=Sʱ�������-1�� �������� 1 10 1 1 9
 * 1 8 8 10 10 3 8 6 1 2 10 4 9 5 3 7 ������� -1 1 10 10 9 8 3 1 1 8
 * 
 * @author daniel
 * @email 576699909@qq.com
 * @time 2016-5-12 ����2:53:46
 */
public class Main {
	public static void main(String[] args) {
		// ���������Ϣ
		Scanner in = new Scanner(System.in);
		int M = in.nextInt();
		int[] N = new int[M];
		int[] S = new int[M];
		Queue<Integer> result = new ConcurrentLinkedQueue<Integer>();

		for (int i = 0; i < M; i++) {
			N[i] = in.nextInt();
			S[i] = in.nextInt();
			int[] a = new int[N[i] - 1];
			int[] b = new int[N[i] - 1];
			for (int j = 0; j < N[i] - 1; j++) {
				a[j] = in.nextInt();
				b[j] = in.nextInt();
			}
			// �ҳ���i�����֣���b[l]=i��ʱ��a[l]��ֵ����result
			for (int k = 1; k <= N[i]; k++) {
				if (S[i] == k)
					result.add(-1);
				for (int l = 0; l < N[i] - 1; l++) {
					if (b[l] == k) {
						result.add(a[l]);
						break;
					}
				}
			}
		}
		// ���
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N[i]; j++) {
				int num = result.poll();
				System.out.print(num + " ");
			}

		}
	}
}