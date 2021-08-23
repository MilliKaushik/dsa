import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Arrays.asList("A", "B", "A", "C", "D", "B", "A"); winner A
//Time complexity O(n)
//Space complexity O(n)
public class ElectionWinner {

	public static String findWinner1(List<String> votes) {
		if (votes.isEmpty())
			return "";

		int maxVote = 0;
		String str = new String();
		Map<String, Integer> candidateVoteCount = new HashMap<>();
		for (int i = votes.size() - 1; i >= 0; i--) {
			candidateVoteCount.put(votes.get(i), candidateVoteCount.getOrDefault(votes.get(i), 0) + 1);
			int currVote = candidateVoteCount.get(votes.get(i));
			if (currVote > maxVote) {
				str = votes.get(i);
				maxVote = currVote;
				if (maxVote > votes.size() / 2)
					return str;
			}
		}
		return str;
	}

	// P1 -> {B, A, C} B -> 3, A -> 2, C -> 1
	// P2-> {A,C, B} A-> 3, C -> 2, B -> 1
	// A-> 5, B-> 4, C-> 3
	//Time complexity O(mn)
	//Space complexity O(mn)
	public static String findWinner2(List<List<String>> votes) {
		if (votes.isEmpty())
			return "";

		int maxVote = 0;
		String str = new String();
		Map<String, Integer> candidateVoteCount = new HashMap<>();
		for (int i = votes.size() - 1; i >= 0; i--) {
			List<String> weightedVotes = votes.get(i); // {B, A, C}

			for (int j = 0; j < 3; j++) {
				candidateVoteCount.put(weightedVotes.get(j),
						candidateVoteCount.getOrDefault(weightedVotes.get(j), 0) + (3 - j));
				int currVote = candidateVoteCount.get(weightedVotes.get(j));
				if (currVote > maxVote) {
					str = weightedVotes.get(j);
					maxVote = currVote;
				}
			}
		}
		return str;
	}

	public static void main(String[] args) {
//		System.out.println(findWinner1(Arrays.asList("A", "B", "A", "C", "D", "B", "A")));
//		System.out.println(findWinner1(Arrays.asList("A")));
//		System.out.println(findWinner1(Arrays.asList("A", "B", "C", "D")));
//		System.out.println(findWinner1(Arrays.asList("")));
//		System.out.println(findWinner1(Arrays.asList("A", "B", "B")));
//		System.out.println(findWinner1(Arrays.asList("A", "A", "A", "B", "B")));
//		System.out.println(findWinner1(Arrays.asList("A", "A", "B", "B")));

		List<List<String>> votes = new ArrayList<>();
		List<String> vote1 = Arrays.asList("B", "A", "C");
		List<String> vote2 = Arrays.asList("A", "C", "B");
		List<String> vote3 = Arrays.asList("G", "A", "C");
		//A - 7
		//B - 4
		//C - 4
		votes.add(vote1);
		votes.add(vote2);
		System.out.println(findWinner2(votes));
	}

}
