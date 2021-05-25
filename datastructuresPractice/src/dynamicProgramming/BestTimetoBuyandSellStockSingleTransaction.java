package dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestTimetoBuyandSellStockSingleTransaction {

	public int maxProfit1(int[] prices) {
		return 0;
	}

//199/210 test cases passed - TLE
	public int maxProfit(int[] prices) {

		int n = prices.length;
		Map<Integer, List<Integer>> indexToSmallerElementsIndexes = new HashMap<>();
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i - 1; j >= 0; j--)
				if (prices[j] < prices[i])
					addToMap(prices, indexToSmallerElementsIndexes, i, j);
		}
		int[] profitValue = new int[n + 1];
		for (int k = 0; k <= n; k++)
			profitValue[k] = -1;
		return maxProfitMemoizedHelper(prices, 0, n - 1, profitValue, indexToSmallerElementsIndexes);
	}

	private int maxProfitMemoizedHelper(int[] prices, int st, int end, int[] profitValue,
			Map<Integer, List<Integer>> indexToSmallerElementsIndexes) {
		if (st >= end)
			return 0;
		if (profitValue[end] != -1)
			return profitValue[end];
		// not including this element
		int notIncludedProfit = maxProfitMemoizedHelper(prices, st, end - 1, profitValue,
				indexToSmallerElementsIndexes);
		int includedProfit = 0;
		// including this and calculating the value of the profit for every smaller
		// price
		if (indexToSmallerElementsIndexes.get(end) == null)
			return notIncludedProfit;
		for (int smallerIndex : indexToSmallerElementsIndexes.get(end)) {
			includedProfit = Math.max(prices[end] - prices[smallerIndex], includedProfit);
		}
		profitValue[end] = Math.max(notIncludedProfit, includedProfit);
		return profitValue[end];
	}

	private void addToMap(int[] prices, Map<Integer, List<Integer>> indexToSmallerElementsIndexes, int i, int j) {
		List<Integer> smallerElementsIndexList;
		if (indexToSmallerElementsIndexes.containsKey(i))
			smallerElementsIndexList = indexToSmallerElementsIndexes.get(i);
		else
			smallerElementsIndexList = new ArrayList<>();

		smallerElementsIndexList.add(j);
		indexToSmallerElementsIndexes.put(i, smallerElementsIndexList);
	}

	// maximum difference between two elements
	public int maxProfit2(int[] prices) {
		int minElement = prices[0];
		int maxDiff = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] - minElement > maxDiff)
				maxDiff = prices[i] - minElement;
			if (prices[i] < minElement)
				minElement = prices[i];
		}
		return maxDiff;
	}
}
