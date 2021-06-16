import java.util.Stack;

public class FindTheCelebrity {

	public int findCelebrity1(int n) {
		for (int i = 0; i < n; i++) {
			int noOfPeopleWhoKnowI = 0;
			for (int j = 0; j < n; j++) {
				if (i != j) {
					if (knows(i, j) || !knows(j, i))
						break;
					else
						noOfPeopleWhoKnowI++;
				}
			}
			if (noOfPeopleWhoKnowI == n - 1)
				return i;
		}
		return -1;
	}

	public int findCelebrity2(int n) {
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < n; i++)
			s.push(i);
		while (s.size() >= 2) {
			int first = s.pop();
			int second = s.pop();
			if (knows(first, second) && !knows(second, first))
				s.push(second);
			else if (knows(second, first) && !knows(first, second))
				s.push(first);
		}
		if (s.isEmpty())
			return -1;
		int j = s.pop();
		for (int i = 0; i < n; i++)
			if (i != j) {
				if (knows(j, i) || !knows(i, j))
					return -1;
			}
		return j;
	}

	public int findCelebrity3(int n) {
		int i = 0, j = n - 1;
		while (i < j) {
			if (knows(i, j) || !knows(j, i))
				i++;
			else
				j--;
		}

		for (int a = 0; a < n; a++)
			if (a != i) {
				if (knows(i, a) || !knows(a, i))
					return -1;
			}
		return i;
	}

	private boolean knows(int j, int i) {
		// TODO Auto-generated method stub
		return false;
	}
}
