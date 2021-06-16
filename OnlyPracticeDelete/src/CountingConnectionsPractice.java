import java.util.ArrayList;
import java.util.List;

//not tested
public class CountingConnectionsPractice {

	public static int count(List<List<Integer>> a) {
		int m = a.size();
		int n = a.get(0).size();
		int count = 0;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (a.get(i).get(j) == 1)
					count += getConnections(a, i, j);
		return count;
	}

	private static int getConnections(List<List<Integer>> a, int i, int j) {
		if (i < 0 || j < 0 || i >= a.size() || j >= a.get(0).size() || a.get(i).get(j) == 0)
			return 0;

		a.get(i).set(j, 0);
		int connections = 0;
		connections += isConnection(a, i - 1, j - 1);
		connections += isConnection(a, i - 1, j);
		connections += isConnection(a, i - 1, j + 1);
		connections += isConnection(a, i, j - 1);
		connections += isConnection(a, i, j + 1);
		connections += isConnection(a, i + 1, j - 1);
		connections += isConnection(a, i + 1, j);
		connections += isConnection(a, i + 1, j + 1);

		return connections;
	}

	private static int isConnection(List<List<Integer>> a, int i, int j) {
		if (i < 0 || j < 0 || i >= a.size() || j >= a.get(0).size() || a.get(i).get(j) == 0)
			return 0;
		if (a.get(i).get(j) == 1)
			return 1;
		return 0;
	}

	public static void main(String[] args) {
		List<List<Integer>> a = new ArrayList<>();
		List<Integer> a1 = new ArrayList<>();
		a1.add(1);
		a1.add(0);
		List<Integer> a2 = new ArrayList<>();
		a2.add(0);
		a2.add(1);
		a.add(a1);
		a.add(a2);
		System.out.println(count(a));
	}
}
